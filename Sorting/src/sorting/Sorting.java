package sorting;

/**
 *
 * @author Patrick McDermott
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sort newSort = new Sort(100000, "str");
                
        newSort.selectionSort();
    }
    
}
