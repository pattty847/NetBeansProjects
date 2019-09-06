/* MergeSortDemo.java
 * CSCI 112 Spring 2014 Semester
 * last edited March 21, 2014 by C. Herbert
 * 
 * This application demonstrates a merge sort algorithm performed on an array 
 * of 9 digits hardcoded into the program.  The array is displayed on the Console 
 * before and after the sort. 
 * 
 * This code is written for clarity.  Changes can be made to improve effeciency.
 * 
 * The accompanying software - MergeSortDemo.java - uses the same mergeSort() and
 * merge() methods to sort an array of  1 million randomly generated integers
 * of up to six digits each.
 */

package mergesortdemo;

import java.util.Random;

public class MergeSortDemo {
    
    private static long startTime, endTime, result;

    public static void main(String[] arg) {

        int[] a = new int[10000000];
        int[] temp = new int[a.length];     // empty temporary array, the same size and type as a[]

        addRandomNumbers(a);
        
        // display array before sorting
        //displayArray(a);
        
        // sort the entire array
        mergeSort(a, temp, 0, (a.length - 1));
        
        endTime = System.currentTimeMillis();
        result = endTime - startTime;
        
        if (result < 1000) {
            System.out.println("Result: " + result + "ms");
        } else { // Larger than 1 second, write seconds and miliseconds
            System.out.println("Result: " + (result/1000) + "sec" + "\n" + result + "ms");
        }
        
        // display array after sorting
        // displayArray(a);
        
    }// end main()
    //*******************************************************************
    
    public static void addRandomNumbers(int[] i) {
        Random r = new Random();
        for(int j = 0; j < i.length; j++) {
            i[j] = r.nextInt(i.length);
        }
    }

    public static void mergeSort(int[] a, int[] temp, int low, int high) {
        startTime = System.currentTimeMillis();
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        
        Random r = new Random();
        
        int mid;  // the middle of the array – last item in low half
        
        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part

            // find middle (last element in low half)   
            mid = (low+high)/ 2;
            mergeSort(a, temp, low, mid );
            mergeSort(a, temp, mid+1, high);
            
            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if        
    }// end mergerSort()
    //********************************************************************
    
    
    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     * 
     * The work of sorting occurs as the two halves are merged back into one 
     * sorted set.
     * 
     * This version of mergesort copies the set to be sorted into the same 
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */
    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half
        
        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers 
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half 
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else
            
            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done. 
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid) 
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        else // high half is done, move rest of low half
        
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        
    } // end merge()
    // *************************************************************
    
    public static void displayArray(int[] a) {

        for (int i = 0; i < a.length; i++) 
            System.out.print(a[i] + "\n");
        System.out.println();
        
    } // end displayArray()

} // end class MergeSortDemo
