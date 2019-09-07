/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author pattt
 */
public class FileSearch {

    // r, w, n: read, write, neither read nor write/no access
    private static String[] folders, files;
    private static String dir;
    private static File mainDir;
    private static Frame frame;

    public static void fileInput() {
        dir = JOptionPane.showInputDialog(frame, "Enter a directory to list all files and information:", "Open", JOptionPane.QUESTION_MESSAGE);
        if (doesDirExist()) {
            try {
                printDir(mainDir);
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getLocalizedMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Directory does not exist.", "Error!", JOptionPane.ERROR_MESSAGE);
            fileInput();
        }
    }

    // Method called by main() which asks for a directory to list its information
    public static boolean doesDirExist() {
        mainDir = new File(dir);
        if (mainDir.exists()) {
            return true;
        }
        return false;
    }
    
    
    static int folderCount = 0, fileCount = 0;
    public static void printDir(File file) throws IOException {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                long size = (f.length()/1000000);
                if (f.isDirectory()) {
                    if(size >= 1) {
                        System.out.println("Folder: " + f.getAbsolutePath() + "\nSize: " + size + " mb");
                    }else{
                        System.out.println("Folder: " + f.getAbsolutePath() + "\nSize: " + f.length() + " bytes");
                    }
                    printDir(f.getAbsoluteFile());
                }else if(f.isFile()) {
                    if(size >= 1) {
                        System.out.println("File: " + f.getName() + "\nSize: " + size + " mb");
                    }else{
                        System.out.println("File: " + f.getName() + "\nSize: " + f.length() + " bytes");
                    }
                }else if(f.isHidden()) {
                    if(size >= 1) {
                        System.out.println("Hidden: " + f.getName() + "\nSize: " + size + " mb");
                    }else{
                        System.out.println("Hidden: " + f.getName() + "\nSize: " + f.length() + " bytes");
                    }
                }else {
                    System.out.println("Something is here but we cannot see it.");
                }
            }
        }
    }
}
