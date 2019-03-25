package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Patrick McDermott
 */
public class Sort {

    // Variables
    private static String[] stringSort;
    private static int[] intSort;

    private static String type;
    private static String wordListFile = "words_alpha.txt";

    Sort(int intSortLen, String type) {
        intSort = new int[intSortLen];
        this.type = type;
    }

    public static void createRandomIntArray() {
        Random r = new Random();
        for (int i = 0; i < intSort.length; i++) {
            intSort[i] = r.nextInt(intSort.length);
        }
        System.out.println("Array created, sorting...");
    }

    public static void selectionSort() {
        // Variable holding the smaller of the two numbers being examined 
        int min;
        
        // Variable grabs the starting time at which the function is executed
        long startTime = System.currentTimeMillis();
        
        // integer sort
        if (type.equals("int")) {
            
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
        } // end if for integer sort
        
        // string sort
        else if(type.equals("str"))
        {
            int size = 0;
            try {
                File f = new File(wordListFile);
                Scanner s = new Scanner(f);
                
                while(s.hasNextLine()) {
                    size++;
                    s.nextLine();
                }
                
                stringSort = new String[size];
                
                Scanner input = new Scanner(f);
                for(int i = 0; i < stringSort.length; i++) {
                    stringSort[i] = input.nextLine();
                }
                
            } catch (FileNotFoundException ex) {
                System.out.println("File not found, 'words_alpha.txt'");
            }
        }
        
        System.out.println("Done.");
        
        printArray();
        
        long passedTime = System.currentTimeMillis() - startTime;
        if(passedTime < 1000) {
            System.out.println("Time: " + (passedTime) + "ms");
        }else
        {
            System.out.println("Time: " + (passedTime / 1000) + "sec\nTime: " + passedTime + "ms");
        }
    } // end selectionSort()
    
    public static void printArray() {
        if(type.equals("int")) {
            for(int i : intSort) {
                System.out.println(i);
            }
        }
        
        if(type.equals("str")) {
            for(String s : stringSort) {
                System.out.println(s);
            }
        }
    }
} // end Sort class
