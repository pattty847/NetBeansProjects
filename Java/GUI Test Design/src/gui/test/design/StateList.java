/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test.design;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pattt
 */
public class StateList {
    
    private static String statesFile = "statedata.txt";                         //Text file's name
    private static JFrame frame = new JFrame("Search");                         //JFrame to display an error message later in the searchStates method

    public static void loadData(State[] s){
        File f = new File(statesFile);                                          //Opens the statedata.txt file
        String state, capital;                                                  //Create two Strings to read the file into
        int population, count = 0;                                                  //Also add a variable for population and a counter
        try {
            Scanner readLines = new Scanner(f);                                 //Scanner created to read the file
            for(int i = 0; i < 50; i++){                                        //Loop to create 50 state objects
                state = readLines.nextLine();                                   //Variables able are initialized with each line in the scanner
                capital = readLines.nextLine();                                 
                population = Integer.parseInt(readLines.nextLine());
                s[i] = new State(state, capital, population);                   //Creates a new State object array with this information
            }
            readLines.close();                                                  //Scanner closed
        } catch (FileNotFoundException ex) {
            Logger.getLogger(State.class.getName()).log(Level.SEVERE, null, ex);//Exception for FileNotFound
        }
    } //Close of file loading method
    
    public static void searchState(State[] states) {
        System.out.println("Enter a state to lookup its information or type 'list' to view all and 'close' to exit: ");
        boolean found = false;                                                  // ifFound boolean
        Scanner input = new Scanner(System.in);                                 // Initiates a new scanner for user input
        String inState = input.nextLine();                                      // Stores the inState from the scanner
        if(inState.equals("list")){                                             // Checks if user enter list command
            displayStates(states);                                              // Executes method
        }else if(inState.equals("close")){
            System.exit(0);
        }else{
            for(State s : states){                                                  // Enhanced forloop to search array of State objects
                if(s.getState().toLowerCase().equals(inState.toLowerCase()) && !found){           // If the getState() method matches the inState, the state is printed AND found isn't true.
                    System.out.println(s.toString());                               // Print the state's .toString method.
                    found = true;                                                   // Sets the found bool to true so we know to stop checking the states.
                    searchState(states);                                        // Recursive method calls itself to 'try again'
                }
        }
        if(!found){
            JOptionPane.showMessageDialog(frame, "Your entry was not found : " + inState, "Retry?", JOptionPane.INFORMATION_MESSAGE);        // If the state isn't found we print the error. 
            searchState(states);                                                // Recursive method calls itself to 'try again'
            }
        }
    } //Close of method which returns a state's information.
    
    public static void displayStates(State[] states) {                          // Simple enhanced for loop method to display states
        for(State s : states) {
            System.out.println(s.toString());
        }
        searchState(states);                                                    //Calls this method again to give the user another chance to do something.
    } // Close of display states loop
} //Close for StateList class file
