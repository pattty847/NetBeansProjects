package sorting;

/**
 *
 * @author Patrick McDermott
 */
public class Sorting {

    /**
     * This program will create a random integer array when a Sort object is created
     * and execute insertion, bubble, and selection sort x number of times and record
     * the results to "results.txt".
     * 
     * Sort(# of elements in array, # of times executed for each sort)
     */
    public static void main(String[] args) {
<<<<<<< HEAD
        Sort newSort = new Sort(20000, 10);
=======
        Sort newSort = new Sort(10000, 100);
>>>>>>> 921c995f101fcf7347342876a2be6bb607613a06
        
        newSort.insertionSort();
        newSort.bubbleSort();
        newSort.selectionSort();
        
    }
}
