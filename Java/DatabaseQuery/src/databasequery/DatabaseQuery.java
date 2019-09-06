/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package databasequery;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseQuery {

    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to the databasess...\n");

        // Connect to the databse by creating a Connection object that takes the IP
        Connection conn = DriverManager.getConnection("jdbc:mysql://68.178.217.12/CWHDemo", "CWHDemo", "Cwhdemo%123");

        System.out.println("Database connection established.\n");

        // Create a statement Object for this  database connection
        Statement st = conn.createStatement();

        // call a method that performs a query using Statement st
        selectFromDatabase(st);

        // Close the connection
        conn.close();
    } // end main()

    
    // Method querys the database and selects the items necessary to write to CSV file
    public static void selectFromDatabase(Statement s) throws SQLException, ClassNotFoundException {
        // This string will hold the query
        String queryString;
        // Holds the returned data from the database
        ResultSet rs;

        // Create an SQL query as as String for this statement
        // this query returns all rows and all columns from the database  
        queryString = "SELECT crn, subject, course, section, days, time FROM fall2014 ORDER BY crn ASC;";

        // Send a statement executing the query and saving the result set 
        rs = s.executeQuery(queryString);

        // Call to method and ResultSet is passed
        writeToCSV(rs);

        answerQuestion(s);
    }

    // Method answers the question 'Which courses meet three times a week?'
    public static void answerQuestion(Statement s) throws SQLException, ClassNotFoundException {
        // This string will hold the query for the question below
        String queryString = "SELECT crn, subject, course, section, days, time FROM fall2014 ORDER BY crn ASC";

        // ResultSet object will contain for query results
        ResultSet rs;

        // Question I will be querying the database
        System.out.println("What courses all meet three times a week?");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "CRN", "Subject", "Course", "Section", "Days", "Times");

        // Execute the query 
        rs = s.executeQuery(queryString);

        // This loops through the data contained in the ResultSet
        while (rs.next()) {
            // If the length of the value in column 5 (days) is 3

            if (rs.getString(5).length() == 3) {
                System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        }
    }

    // Method takes a ResultSet and writes the information to a CSV file using opencsv
    public static void writeToCSV(ResultSet rs) throws SQLException, ClassNotFoundException {
        // CSVWriter object, with methods to write information to CSV file
        CSVWriter writer;
        try {
            // Create new file for the information
            writer = new CSVWriter(new FileWriter("RESULTS.CSV"));

            // writeAll() writes information to file, 'true' includes the headers from the query
            writer.writeAll(rs, true);

            // close stream
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // end writeToCSV()

} // end DatabaseQuery
