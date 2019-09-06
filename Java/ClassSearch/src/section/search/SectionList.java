package section.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SectionList {

    // Holds the file locations name
    private static String file = "courses.txt";
    // Section array created with 20 null Section objects
    private static Section[] sections = new Section[20];

    // Method returns to console the entire Section array's .toString() method
    public static void printSections() {
        for (Section s : sections) {
            System.out.println(s.toString());
        }
    }

    // Method will attempt to locate 'file' and read in all data to Section array
    public static void loadSection() {
        //Opens the course.txt file
        File f = new File(file);

        // Attempt to read the file
        try {
            //Scanner created to read the file
            Scanner readLines = new Scanner(f);
            // Set the current scanner delimiter to a (space)
            readLines.useDelimiter(" ");
            // Created a loop that is bound to the Section array's length
            for (int i = 0; i < sections.length; i++) {
                // Initialize a new Section object to store the info in the line
                sections[i] = new Section();
                //Variables able are set with each line in the scanner. All variables are set
                //using the Section's setter methods
                sections[i].setSubject(readLines.next()); // read in the subject
                sections[i].setCourse(readLines.next()); // read in the course
                sections[i].setSection(readLines.next()); // read in the section
                sections[i].setCRN(readLines.next()); // read in the CRN 
                sections[i].setCredits(readLines.next()); // read in the credits
                sections[i].setTime(readLines.next()); // read in the time
                sections[i].setDays(readLines.nextLine()); // read in the days
            } // End for
            readLines.close(); //Scanner closed
            // If file not found catch the exception and print error.
        } catch (FileNotFoundException ex) {
            System.out.println("Error while finding the file. ");//Exception for FileNotFound
        }
    }
    
    // Method will create a user input scanner and attempt to find a Section from the CRN number
    public static void searchSections() {
        // Create a scanner object for users input
        Scanner scan = new Scanner(System.in);
        
        // String variable to later hold the input
        String input;
        
        System.out.println("Enter a CRN (number) to lookup its class information: ");
        try {
            // Set the input variable to what the user has entered
            input = scan.nextLine();
            
            // boolean variable used to tell if the section CRN has been found in the array
            boolean found = false;
            
            // Enhanced for loop
            for(Section s : sections) {
                // Try to match every Section CRN with what the user has entered
                if(s.getCRN().equals(input)) {
                    // If found print the current object's .toString() method and set 'found' variable to true
                    System.out.println(s.toString());
                    found = true;
                }
            }
            // Once method has executed the for loop it will check the 'found' variable, if not found we print the error
            if(!found) {
                System.out.println("Error, there is no matching class for that CRN.");
            }
        }catch(NumberFormatException e) {
            System.out.println("Please enter a number to search.");
            searchSections();
        }
    }
}
