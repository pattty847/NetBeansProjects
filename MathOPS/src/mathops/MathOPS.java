/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathops;

import java.math.*;
import java.util.Scanner;

/**
 *
 * @author pattt
 */
public class MathOPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        foil();
    }

    public static void doubleNum(int num, int times) {
        int ans = num;
        for(int i = 0; i < times; i++) {
            ans += num;
            System.out.println(ans);
        }
    }

    public static void findLineEquation() {
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0, m = 0, b = 0;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter x1: ");
            x1 = Double.parseDouble(input.nextLine());
            System.out.println("Enter y1: ");
            y1 = Double.parseDouble(input.nextLine());
            System.out.println("Enter x2: ");
            x2 = Double.parseDouble(input.nextLine());
            System.out.println("Enter y2: ");
            y2 = Double.parseDouble(input.nextLine());
            
            m = (y2 - y1) / (x2 - x1);
            b = y1 - m * x1;
            
            System.out.println("Slope: " + m);
            System.out.println("Y-intercept: " + b);
            System.out.println("y = " + m + "(x)" + "+" + b);
            System.out.println(y1 + " = " + m + "(" + x1 + ")" + "+" + b);
        } catch (NumberFormatException e) {
            System.out.println("Enter only integers.");
        }
    }
    
    public static void foil() {
        double a, b, c, d;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter x1: ");
            a = Double.parseDouble(input.nextLine());
            System.out.println("Enter y1: ");
            b = Double.parseDouble(input.nextLine());
            System.out.println("Enter x2: ");
            c = Double.parseDouble(input.nextLine());
            System.out.println("Enter y2: ");
            d = Double.parseDouble(input.nextLine());
            
            System.out.println("(" + a + " + " + b + ")(" + c + " + " + d + ")");
            System.out.println("(" + a*c + " + " + a*d + " + " + b*c + " + " + b * d + ") =");
            System.out.println(a*c + a*d + b*c + b*d);
        }catch(NumberFormatException e) {
            System.out.println("Enter only integers.");
        }
    }
}
