/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test.design;

public class State {
    
    private String state, capital;                                              //Values for the state and its capital
    private int population;                                                     //Value for the population
    
    State(String state, String capital, int population) {                       //State object initializer
        this.state = state;
        this.capital = capital;
        this.population = population;
    }

    public String getState() {                                                  //Will retrieve the state name of the object
        return state;
    }

    public String getCapital() {                                                //Will retrieve the capital of the object
        return capital;
    }

    public int getPopulation() {                                                //Will retrieve the population number of the object
        return population;
    }

    @Override
    public String toString() {                                                  //Creates a readable format for the all the the states features
        return "State: " + state + ", Capital: " + capital + ", Population: " + population;
    }
} //Close of State class file
