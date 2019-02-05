/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathops;

import java.math.*;

/**
 *
 * @author pattt
 */
public class MathOPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {3, 5};
        System.out.println(math(nums, "multi"));
    }
    
    public static int math(int[] i, String type) {
        switch(type) {
            case "add":
                int sum = 0;
                for(int n : i){
                    sum = sum + n;
                }
                return sum;
            case "sub":
                int sum1 = 0;
                for(int n : i){
                    sum1 = sum1 - n;
                }
                return sum1;
            case "multi":
                int sum2 = 0;
                for(int n : i){
                    sum2 = n * n;
                }
                return sum2;
            default:
                return 0;
        }
    }
    
}
