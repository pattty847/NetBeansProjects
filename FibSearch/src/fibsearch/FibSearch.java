/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pattt
 */
public class FibSearch {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadUserOptions();
    }
    
    // fibRec - calculate the nth fibonacci index through method of recursion
    public static long fibRec(long n) { 
        // if n is or reaches 0 or 1 return the input number
        if (n <= 1) {
            return n;
        }
        /*
            fib(n) = fib(n-1) + fib(n-2)
            fib(5) = fib(4) + fib(3) + fib(2) + fib(1)
            complexity = 
        */
        return fibRec(n-1) + fibRec(n-2); 
    }
    
    // fibIter - calculate the nth fibonacci index through method of iteration
    public static long fibIter(long n) {
        // Fibonacci starting state 
        int a = 0, b = 1, c = 1;
        if(n <= 1) {
            return n;
        }
        // Start at 2 because that's our starting state for c
        for(int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    // Method which is called to list current available commands to the user and execute those commands
    private static void loadUserOptions() {
        // Scanner created to grab user input
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Command List "
                + "\n'find rec' (search for nth fibonacci number by recursion)"
                + "\n'find iter' (search for nth fibonacci number by iteration)"
                + "\n'compare' (compare both methods and their times)"
                + "\n'auto compare' (auto compare methods with predefined test case)"
                + "\n'auto compare rand' (auto compare methods with random test cases <= 50)"
                + "\n'close'");
        // Their input is set to n later, so we initialize it with a 0
        int n = 0;
        // Execute commands from scanner
        switch(input.nextLine()) {
            // Find (n) through recursion
            case "find rec": //fibonacci recursion
                // Until the user enters something greater than 0 we continue to ask
                while(n <= 0) {
                    System.out.print("Enter a number > 0 \n>");
                    n = Integer.parseInt(input.nextLine());
                }
                System.out.println("Calculating with recursion fibonacci index " + "[" + n + "]");
                
                // Grab the current time in nanoseconds
                long start = System.nanoTime();
                
                // Print the recursion method
                System.out.println("Answer: " + fibRec(n));
                
                // Print the time elapsed since executed
                System.out.println("Time elapsed: " + (System.nanoTime()- start) + "ns");
                // After call the user options method
                loadUserOptions();
            // End find rec
            case "find iter": //fibonacci iteration
                // Until the user enters something greater than 0 we continue to ask
                while(n <= 0) {
                    System.out.print("Enter a number > 0 \n>");
                    n = Integer.parseInt(input.nextLine());
                }
                System.out.println("Calculating with iteration fibonacci index " + "[" + n + "]");
                
                // Grab the current time in nanoseconds
                start = System.nanoTime();
                System.out.println("Answer: " + fibIter(n));
                
                // Print the time elapsed since executed
                System.out.println("Time elapsed: " + (System.nanoTime() - start) + "ns");
                loadUserOptions();
            // End find iter
            case "compare": // recursive to iteration
                while(n <= 0) {
                    System.out.println("Enter a number > 0 \n>");
                    n = Integer.parseInt(input.nextLine());
                }
                System.out.println("Calculating with iteration..." + " | [" + n + "]");
                long startIter = System.nanoTime(); // Start time for iteration
                System.out.print("fib(" + n + ") = " + fibIter(n) + "    Time: " + (System.nanoTime() - startIter) + "ns\n");
                System.out.println("Calculating with recursion..." + " | [" + n + "]");
                long startRec = System.nanoTime(); // Start time for recursion
                System.out.print("fib(" + n + ") = " + fibRec(n) + "    Time: " + (System.nanoTime() - startRec) + "ns\n");
            // End compare functions
            case "auto compare":
                int[] testCase = {5, 8, 9, 4, 14, 20, 24, 30, 36, 40, 44, 45, 47, 50};
                for(int i = 0; i < testCase.length; i++) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Calculating with iteration..." + " | [" + testCase[i] + "]");
                    long startIter2 = System.nanoTime(); // Start time for iteration
                    System.out.print("fib(" + testCase[i] + ") = " + fibIter(testCase[i]) + "    Time: " + (System.nanoTime() - startIter2) + "ns\n");
                    System.out.println("Calculating with recursion..." + " | [" + testCase[i] + "]");
                    long startRec2 = System.nanoTime(); // Start time for recursion
                    System.out.print("fib(" + testCase[i] + ") = " + fibRec(testCase[i]) + "    Time: " + (System.nanoTime() - startRec2) + "ns\n");
                }
            case "auto compare rand":
                while(n <= 0) {
                    System.out.println("Enter a number of test cases > 0 \n>");
                    n = Integer.parseInt(input.nextLine());
                }
                Random rand = new Random();
                for(int i = 0; i < n; i++) {
                    int randTest = rand.nextInt(50) + 1;
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Calculating with iteration..." + " | [" + randTest + "]");
                    long startIter3 = System.nanoTime(); // Start time for iteration
                    System.out.print("fib(" + randTest + ") = " + fibIter(randTest) + "    Time: " + (System.nanoTime() - startIter3) + "ns\n");
                    System.out.println("Calculating with recursion..." + " | [" + randTest + "]");
                    long startRec3 = System.nanoTime(); // Start time for recursion
                    System.out.print("fib(" + randTest + ") = " + fibRec(randTest) + "    Time: " + (System.nanoTime() - startRec3) + "ns\n");
                }
            case "close": // Close program
                System.exit(0);
            default: // recursive call to same method
                System.out.println("Command not found: ");
                loadUserOptions();
            // End default case
        }// End switch
    } // End user commands method
}
