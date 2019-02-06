/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.gates;

/**
 *
 * @author pattt
 */
public class Gates {
    
    public Gates() {
        
    }
    
    public static boolean AND(boolean in[]) {
        for(boolean n : in) {
            if(!n) return false;
        }
        return true;
    }
    
    public static boolean OR(boolean in, boolean in2) {
        return !(!in && !in);
    }
    
    public static boolean NOT(boolean in) {
        return !in;
    }
}
