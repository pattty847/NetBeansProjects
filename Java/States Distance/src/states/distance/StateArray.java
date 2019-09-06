/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states.distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pattt
 */
public class StateArray {
    
    private static final String statesFile = "statedata.txt";

    
    public static void loadStates(State[] states) {
        //Opens the statedata.txt file
        File f = new File(statesFile);
        
        //Create two Strings and int to read the file into. 
        String state, capital;                                                  
        int population;
        try {
            //Scanner created to read the file
            Scanner readLines = new Scanner(f);
            
            //Loop to create 50 state objects
            for(int i = 0; i < 50; i++){
                states[i] = new State();
                //Variables able are set with each line in the scanner
                states[i].setState(readLines.nextLine());                                   
                states[i].setCapital(readLines.nextLine());
                states[i].setPopulation(Integer.parseInt(readLines.nextLine()));
            } // End for
            readLines.close();                                                  //Scanner closed
        } catch (FileNotFoundException ex) {
            Logger.getLogger(State.class.getName()).log(Level.SEVERE, null, ex);//Exception for FileNotFound
        }
    }
}
