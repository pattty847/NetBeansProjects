/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package stringsort;

/**
 *
 * @author Patrick McDermott
 * 
 * This program will read in a file containing 1000 randomly places words
 * and use two algorithms to sort them. Insertion and selection sort.
 */
public class StringSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sort sort = new Sort();
        
        // Call the two methods
        sort.insertionSort();
        sort.selectionSort();
    }
    
}
