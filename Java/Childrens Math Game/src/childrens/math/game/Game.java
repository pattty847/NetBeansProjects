/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childrens.math.game;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.Random;

/**
 *
 * @author pattt
 */
public class Game {

    Voice voice;

    private String enteredNums = "";
    private int[] questions = new int[2];
    private int score, total;

    Game() {
        // Initiate a new voice object 
        // set up a Voicemanager object and use it to link voice with a particular voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        // load the selected voice
        voice.allocate();
    }

    // Method generates two random numbers between 0-10 and adds it to question array
    public void createQuestion(int selectedIndex) {
        // Init random number generator
        Random random = new Random();
        questions[0] = random.nextInt(11); // Create to random nums
        questions[1] = random.nextInt(11);

        // Call to speak the questions generated
        speakQuestion(selectedIndex);
    }

    // Method takes an index from the dropdown menu that says "Addition/Subtraction" and creates dialog
    public void speakQuestion(int selectedIndex) {
        String text;
        switch (selectedIndex) {
            case 0: // Case for addition
                text = "What is the answer to " + questions[0] + "+" + questions[1];
                voice.speak(text);
                break;
            case 1: // Case for subtraction
                text = "What is the answer to " + questions[0] + "minus" + questions[1];
                voice.speak(text);
                break;
        }
    }

    /*
        Main method to combine all data created by program and machine and validate.
        It is passed which index is picked by the dropdown menu on the GUI (Add/Sub)
    */
    public void checkSubmission(int selectedIndex) {
        int answer = 0;
        int userAnswer = 0;
        switch (selectedIndex) {
            case 0: // Case for addition
                try {
                    // Add the two random numbers together
                    answer = questions[0] + questions[1];
                    // Turn the users entry into a integer by parsing it
                    userAnswer = Integer.parseInt(enteredNums);
                    
                } catch (NumberFormatException e) {}
                
                // Answer needed must equal what the user entered AND the score cannot be 5
                if (answer == userAnswer && score != 5) {
                    score++;
                    voice.speak("Your answer was correct!");
                } else {
                    voice.speak("That was incorrect");
                }
                break;
            case 1: // Case for subtraction
                // Boolean to track if the users entry starts with a -
                boolean negative = false;
                try {
                    // Subtract the generated numbers and store it
                    answer = questions[0] - questions[1];
                    // If it starts with '-' set 'negative' to true and delete the char
                    if (enteredNums.startsWith("-")) {
                        negative = true;
                        enteredNums.replace("-", ""); // <-- Deletes the '-'
                        userAnswer = Integer.parseInt(enteredNums);
                    } else {
                        userAnswer = Integer.parseInt(enteredNums);
                    }
                } catch (NumberFormatException e) {}
                // If the answer needed is supposed to be negative we check if the boolean is true
                if (answer < 0) {
                    if (answer == userAnswer && score != 5 && negative) { // <--- is the users number negative
                        score++;
                        voice.speak("Your answer was correct!");
                    }else{ voice.speak("That was incorrect"); } // <-- If it's not negative
                }else{
                    // If the answer needed is positive we check if it's false
                    if (answer == userAnswer && score != 5 && !negative) {
                        score++;
                        voice.speak("Your answer was correct!");
                    }else{ voice.speak("That was incorrect"); }
                }
                break;
        }
    }

    public void start(int i) {
        if (score != 5) {
            total++;
            createQuestion(i); // generateQuestion() --> speakQuestion()
            reset(); // Always resets the enteredNums array
        } else if(score == 5) {
            voice.speak("Game over! You scored " + score + "out of " + total + "That's " + (total/score) * 100 + "%");
        }
    }

    // Access modifiers
    
    public void reset() {
        enteredNums = "";
    }

    public String getEnteredNums() {
        return enteredNums;
    }

    public void setEnteredNums(String enteredNum) {
        this.enteredNums = this.enteredNums + enteredNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
