/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package stringsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick McDermott
 */
public class Sort {

    // Variables
    private static String file = "strarray.txt"; // file containing words
    private static String[] strArray = new String[1000]; // array that will contain 1000 random words

    // Method sorts the array intSort with selection algorithm
    public static void selectionSort() {
        // Read in the random array
        readInArray();
        
        // Variable grabs the starting time at which the function is executed
        long startTime = System.currentTimeMillis();

        // Count through the length of the array - 1
        for (int i = 0; i < strArray.length - 1; i++) {
            // Find the minimum element in unsorted array 
            int min = i;
            // Look at the element after i and count to length of array
            for (int j = i + 1; j < strArray.length; j++) {
                // If the number is smaller than the current minimum set min to this num
                if (strArray[j].compareTo(strArray[min]) < 0) {
                    min = j;
                } // end if
            } // end for

            // Swap the two numbers by creating a temp variable
            String temp = strArray[min];
            strArray[min] = strArray[i];
            strArray[i] = temp;
        } // end for

        long passedTime = System.currentTimeMillis() - startTime;
        
        // Print corrected array
        printSelection(passedTime, "Selection");
    } // end selectionSort()

    // Method sorts the array intSort with insertion algorithm
    public static void insertionSort() {
        // Read in the random array
        readInArray();
        
        // Grab start time for the sort
        long startTime = System.currentTimeMillis();

        // Variable set to hold the smaller of the two indicies
        String temp;
        // Start from element 1 (second element) to the end
        for (int i = 1; i < strArray.length; i++) {
            for (int j = i; j > 0; j--) {
                // If element at j is smaller than j - 1 save the smaller number in temp
                if (strArray[j].compareTo(strArray[j - 1]) < 0) {
                    temp = strArray[j];
                    // set j to the larger
                    strArray[j] = strArray[j - 1];
                    // j - 1 is set to temp
                    strArray[j - 1] = temp;
                }
            }
        }

        // Find time results
        long passedTime = System.currentTimeMillis() - startTime;

        // Print corrected array
        printInsertion(passedTime, "Insertion");
    } // end insertionSort()
    
    // Method will print the results for the sorted array
    public static void printInsertion(long time, String sort) {
        try {
            // PrintWriter object to create result file
            PrintWriter p = new PrintWriter("insertion.txt");
            
            // Write the execution time
            p.println(sort + " : Time : " + time + "ms");
            
            // Print the entire array with enhanced for loop
            for(String s : strArray) {
                p.println(s);
            }
            p.flush();
        } catch (IOException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method will print the results for the sorted array
    public static void printSelection(long time, String sort) {
        try {
            // PrintWriter object to create result file
            PrintWriter p = new PrintWriter("selection.txt");
            
            // Write the execution time
            p.println(sort + " : Time : " + time + "ms");
            
            // Print the entire array with enhanced for loop
            for(String s : strArray) {
                p.println(s);
            }
            p.flush();
        } catch (IOException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(sort + " : Time : " + time + "ms");
    }

    // Method will read the file 'strarray.txt' that contains 1000 random words
    public static void readInArray() {
        // File object to open the string array file
        File f = new File(file);
        try {
            // Scanner object to read the contents
            Scanner in = new Scanner(f);

            // Loop through the 1000 elements and initialize with each line in file
            for (int i = 0; i < strArray.length; i++) {
                strArray[i] = in.nextLine();
            }
            
            // Print the entire array so it can be seen it's not sorted
            for(String s : strArray) {
                System.out.println(s);
            }
            
            // Catch error if file cannot be found
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
