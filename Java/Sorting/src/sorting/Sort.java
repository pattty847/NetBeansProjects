package sorting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick McDermott
 */
public class Sort {

    // Variables
    private static int[] intSort; // int array to sort
    private static long[] insertionTimes, bubbleTimes, selectionTimes;

    private static PrintWriter p; // PriterWriter to write to file

    // Length of the random integer array, number of times to execute algorithms
    Sort(int intSortLen) {
        System.out.print("Working..." + "\n");
        
        // Initialize an empty array with this length
        intSort = new int[intSortLen];

        // Arrays that hold time ellapsed for each sort
        insertionTimes = new long[intSort.length];
        bubbleTimes = new long[intSort.length];
        selectionTimes = new long[intSort.length];

        // Attempts to create a new file to store the results (times) of each algorithm
        try {
            p = new PrintWriter("results.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method will create random elements for the array created from the Sort object
    public static void createRandomIntArray() {
        Random r = new Random();

        for (int i = 0; i < intSort.length; i++) {
            // Initialize a new random integer for each index of the array
            intSort[i] = r.nextInt(intSort.length);
        }
    }

    // Method sorts the array intSort with selection algorithm
    public static void selectionSort(int exTimes) {
        // Execute this method as many times as set 
        for (int k = 0; k < exTimes; k++) {
            createRandomIntArray();

            // Variable grabs the starting time at which the function is executed
            long passedTime, startTime = System.currentTimeMillis();

            // Count through the length of the array - 1
            for (int i = 0; i < intSort.length - 1; i++) {
                // Find the minimum element in unsorted array 
                int min = i;
                // Look at the element after i and count to length of array
                for (int j = i + 1; j < intSort.length; j++) {
                    // If the number is smaller than the current minimum set min to this num
                    if (intSort[j] < intSort[min]) {
                        min = j;
                    } // end if
                } // end for

                // Swap the two numbers by creating a temp variable
                int temp = intSort[min];
                intSort[min] = intSort[i];
                intSort[i] = temp;
            } // end for

            passedTime = System.currentTimeMillis() - startTime;

            for (int times = 0; times < selectionTimes.length; times++) {
                selectionTimes[times] = passedTime;
            }

            writeResults(passedTime, ":2", exTimes);
            if (k == exTimes - 1) {
                writeAverage(selectionTimes, ":2");
            }
        } // end for
    } // end selectionSort()

    // Method sorts the array intSort with bubble algorithm
    public static void bubbleSort(int exTimes) {
        // Execute this method as many times as set 
        for (int k = 0; k < exTimes; k++) {
            // Variable holding the smaller of the two numbers being examined 
            int min;

            // Variable grabs the starting time at which the function is executed
            long passedTime, startTime = System.currentTimeMillis();

            createRandomIntArray();

            // Loop through length of the integer array
            for (int i = 0; i < intSort.length; i++) {

                // Loop through again, looking at one index more than previous for loop
                for (int j = i + 1; j < intSort.length; j++) {

                    if (intSort[j] < intSort[i]) {
                        // Minimum is set to the smaller numbers
                        min = intSort[i];

                        // The minimum value of the array is set to the larger
                        intSort[i] = intSort[j];

                        // The larger value of the array is set to the minimum variable
                        intSort[j] = min;
                    } // end if
                } // end inner for 
            } // end outer for

            passedTime = System.currentTimeMillis() - startTime;

            for (int times = 0; times < bubbleTimes.length; times++) {
                bubbleTimes[times] = passedTime;
            }

            writeResults(passedTime, ":1", exTimes);
            if (k == exTimes - 1) {
                writeAverage(bubbleTimes, ":1");
            }
        }
    } // end bubbleSort()

    // Method sorts the array intSort with insertion algorithm
    public static void insertionSort(int exTimes) {
        // Execute this method as many times as set 
        for (int k = 0; k < exTimes; k++) {
            // Grab start time for the sort
            long passedTime, startTime = System.currentTimeMillis();

            // Initialize a random integer array
            createRandomIntArray();

            // Variable set to hold the smaller of the two indicies
            int temp;
            // Start from element 1 (second element) to the end
            for (int i = 1; i < intSort.length; i++) {
                for (int j = i; j > 0; j--) {
                    // If element at j is smaller than j - 1 save the smaller number in temp
                    if (intSort[j] < intSort[j - 1]) {
                        temp = intSort[j];
                        // set j to the larger
                        intSort[j] = intSort[j - 1];
                        // j - 1 is set to temp
                        intSort[j - 1] = temp;
                    }
                }
            }

            // Find time results
            passedTime = System.currentTimeMillis() - startTime;

            for (int times = 0; times < insertionTimes.length; times++) {
                insertionTimes[times] = passedTime;
            }

            // Print results with time
            writeResults(passedTime, ":3", exTimes);
            if (k == (exTimes - 1)) {
                writeAverage(insertionTimes, ":3");
            }
        }
    } // end insertionSort()

    public static void writeAverage(long[] array, String s) {
        long av = 0;
        for (long l : array) {
            av += l;
        }

        //p.println("* " + (int) (av / array.length) + s + " Average");
        p.flush();
    }

    // Method will be called after sort is complete and write results to file
    public static void writeResults(long time, String type, int exTimes) {
        p.println(time + type + ":" + exTimes);

        // Flush stream
        p.flush();
    }
} // end Sort class
