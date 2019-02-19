/* myTTSDemoDemo.java 
 * 
 * CSCI 112 - Spring 2014   last edited Feb 13, 2014 by C. Herbert
 * 
 * This file is to be used by students in the programming exercise
 * Creating a TTS Demo.   When the exercise is complete, it will demonstrate 
 * using the FreeTTS library in Java programs to synthesize speech from text.
 * 
 * The program will not work as is.  The FreeTTS library of JAR files must be
 * set up in NetBeans for it to work, as decribed in the exercise. 
 */
package myttsdemo;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class MyTTSDemo {

    public static void main(String[] args) {

        // set up a variable for the text to be read

        String text = "This is your computer talking."
                + ".  ." + "Let me recite some lines made famous by Thomas Edison"
                + ".  ." + "Mary had a little lamb, its fleece was white as snow,"
                + ".  ." + "and everywhere that Mary went, the lamb was sure to go.";


        // instantiate a Voice object named voice
        Voice voice;
        
        // set up a Voicemanager object and use it to link voice with a particular voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        
        // load the selected voice
        voice.allocate();
        
        // begin speaking the text
        voice.speak(text);

  
    } // end main()
} // end class MyTTSDemo
