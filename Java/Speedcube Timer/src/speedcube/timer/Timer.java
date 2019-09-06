/*
 * Author: Patrick McDermott
 * This project is available to anyone who chooses to use it.
 */
package speedcube.timer;

/**
 *
 * @author pattt
 */
public class Timer {
    
    private static long currentTime = 0, passedTime = 0;
    
    public static void start() {
        currentTime = System.currentTimeMillis();
    }
    
    public static void stop() {
        passedTime = System.currentTimeMillis() - currentTime;
        long elapsedSeconds = passedTime / 1000; //miliseconds to seconds
        long secondsDisplay = elapsedSeconds % 60; //seconds to minutes
        long elapsedMinutes = elapsedSeconds / 60;
        System.out.println(elapsedSeconds);
    }
    
}
