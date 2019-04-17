/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package databasequery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseQuery {

    
    
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to the databasess...\n");

        // Connect to the databse by creating a Connection object that takes the IP
        Connection conn = DriverManager.getConnection("jdbc:mysql://68.178.217.12/CWHDemo", "CWHDemo", "Cwhdemo%123");

        System.out.println("Database connection established.\n");

        // Create a statement Object for this  database connection
        Statement st = conn.createStatement();

        // call a method that performs a query using Statement st
        selectFromDataBase(st);

        // Close the connection
        conn.close();
    } // end main()
    
    
    public static void selectFromDataBase(Statement s) throws SQLException, ClassNotFoundException {
        String queryString;
        ResultSet rs;
        
        // Create an SQL query as as String for this statement
        // this query returns all rows and all columns from the database  
        queryString = "SELECT crn, subject, course, section, days, time FROM fall2014;";

        // Send a statement executing the query and saving the result set 
        rs = s.executeQuery(queryString);

        writeToCSV(rs);
    }
    
    public static void writeToCSV(ResultSet rs) throws SQLException, ClassNotFoundException {
        
        System.out.printf("%-10s%-10s%n", "CRN", "Subject", "Course", "Section", "Days", "Times");
        System.out.println("*********************");

        // Iterate the result set and print name, owner, and species attributes
        while (rs.next()) {
            System.out.printf("%-10s%-10s%n", rs.getString(1), rs.getString(2), rs.getString(3), 
                rs.getString(4), rs.getString(5), rs.getString(6));
        }
    }
} // end DatabaseQuery
