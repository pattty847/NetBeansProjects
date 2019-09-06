/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/*
 * Create a java application that will ask the user for a directory, then display 
 * three lists –a list of all files in the directory to which we have write access,
 * a list of all file in the directory to which we have read access to but not 
 * write access and a list of all files in the directory to which we have neither 
 * read nor write access.
 */

/**
 *
 * @author pattt
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    
}
