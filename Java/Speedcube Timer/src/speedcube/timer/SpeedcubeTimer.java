/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package speedcube.timer;

import java.util.Scanner;

/**
 *
 * @author pattt
 */
public class SpeedcubeTimer {

    private static Timer time = new Timer();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        time.start();
        
        Scanner input = new Scanner(System.in);
        
        String s = input.nextLine();
        
        if(s.equals("stop")) {
            time.stop();
        }
    }
    
}

