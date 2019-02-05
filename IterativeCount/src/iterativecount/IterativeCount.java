/* IterativeCount.Java
 * Computer Science 112, Spring 2014
 * Last edited Jan. 20, 2014 by C. Herbert
 * 
 * This code is a simple iterative program for printing the integers from 
 * 1 to the highest integer, Integer.MAX_VALUE
 * 
 * It is intended v as a comparison to the recursive program
 * RecursiveCount, which does the same thing recursively.
 * 
 * You should run thre two programs and compare results.
 * The iterative progam will run on, until you stop it or until it reaches 
 * Integer.MAX_VALUE.  It speed is determined by the time it takes to execut the
 * System.out.println() instruction.
 * Without the printing, it get to Integer.MAX_VALUE in less than 2 seconds 
 * on most systems, often in less than 1 second
 */
package iterativecount;

public class IterativeCount {

    public static void main(String[] args) {
       int count;   // a counter
        
       // Integer.MAX_VALUE is the highest possible int value
       for(count = 1; count < Integer.MAX_VALUE; count++ ) 
            System.out.println(count);
    
} // end main()
    
} // end class IterativeCount
