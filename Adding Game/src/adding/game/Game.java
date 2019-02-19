/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adding.game;

import java.util.Random;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
 /*
 * @author pattt
 */
public class Game {
    
    Voice voice;
    
    private String[] submission = new String[20];
    private int[] question = new int[2];
    private int score = 0;
    private int topScore = 5;
    
    private String introText = "";
    
    Game() {
        // Initiate a new voice object 
        // set up a Voicemanager object and use it to link voice with a particular voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16"); 
        // load the selected voice
        voice.allocate();
    }
    
    // Method generates two random numbers between 0-10 and adds it to question array
    public void generateQuestion(int selectedIndex) {
        Random random = new Random();
        question[0] = random.nextInt(11);
        question[1] = random.nextInt(11);
        
        // Call to speak the questions generated
        speakQuestion(selectedIndex);
    }
    
    // Method takes an index from the dropdown menu that says "Addition/Subtraction" and creates dialog
    public void speakQuestion(int selectedIndex) {
        String text;
        switch(selectedIndex) {
            case 0: // Case for addition
                text = "What is the answer to " + question[0] + "+" + question[1];
                voice.speak(text);
                break;
            case 1: // Case for subtraction
                text = "What is the answer to " + question[0] + "minus" + question[1];
                voice.speak(text);
                break;
        }
    }
    
    public void checkSubmission(int selectedIndex) {
        switch(selectedIndex) {
            case 0:
                int userResult = 0, answer = question[0] + question[1];
                if(submission != null) {
                    try{
                        for (String submission1 : submission) {
                            userResult = userResult + Integer.parseInt(submission1);
                        }
                    }catch(NumberFormatException e) {
                    }
                }
                if(userResult == answer && answer != 0) {
                    voice.speak("Correct mate, the answer was " + answer);
                    score++;
                }else if(userResult == answer && answer != 0){
                    voice.speak("Wrong mate, the answer was " + answer);
                }
            case 1:
                userResult = 0;
                answer = question[0] - question[1];
                if(submission != null) {
                    try{
                        for (String submission1 : submission) {
                            userResult = userResult - Integer.parseInt(submission1);
                        }
                    }catch(NumberFormatException e) {
                    }
                }
                if(userResult == answer && answer != 0) {
                    voice.speak("Correct mate, the answer was " + answer);
                    score++;
                    reset();
                }else if(userResult == answer && answer != 0){
                    voice.speak("Wrong mate, the answer was " + answer);
                    reset();
                }
        }
    }

    public void reset() {
        this.score = 0;
        this.submission = null;
    }

    // Initializes game
    public void start(int selectedIndex) {
        generateQuestion(selectedIndex);
    }

    public String[] getSubmission() {
        return submission;
    }

    public void setSubmission(String submission, int index) {
        this.submission[index] = submission;
    }

    public int[] getQuestion() {
        return question;
    }

    public void setQuestion(int[] question) {
        this.question = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    /*
        Method called to start the game:
        Calls; start(), --> generateQuestion() --> speakQuestion()
    */
    public void setRunning(int i) {
        start(i);
    }
    
    public void stopRunning(){
        
    }
}
