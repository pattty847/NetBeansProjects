/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childrens.math.game;

/**
 *
 * @author pattt
 */
public class ChildrensMathGame {

    /**
     * @param args the command line arguments
     */
    
    // Only method call is to the GUI constructor which enables the frame
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
}
