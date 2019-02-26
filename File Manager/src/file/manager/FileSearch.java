/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.manager;

import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pattt
 */
public class FileSearch {

    private static ArrayList<String> folderNames = new ArrayList<>(); // Array used to hold each folder name (will further implement this)
    private static ArrayList<String> fileNames = new ArrayList<>(); // Array used to hold each file name (will further implement this)
    private static int folderCount = 0, fileCount = 0; // Ints to hold number of folders and files in a directory, and all sub-directories
    private static File mainDir; // File contining directory the user is searching
    private static Frame frame;

    // Method returns true when the file attempted to look at is real
    public boolean doesDirExist(String text) {
        mainDir = new File(text);
        return mainDir.exists();
    }

    // Method stores the amount of folders and files in a directory, and holds all their paths
    public static void grabFiles(File file) throws IOException, NullPointerException {
        // List all files sent to the method
        for (File files : file.listFiles()) {
            // If the directory is a folder, add the path and + 1
            if (files.isDirectory()) {
                folderCount++;
                folderNames.add(files.getAbsolutePath());
                // Reopen this folder and repeat
                grabFiles(files.getAbsoluteFile());
            } else if (files.isFile()) {
                // If the directory is a file, add the path and + 1
                fileCount++;
                fileNames.add(files.getAbsolutePath());
            }
        }
    }

    // Method will completely recursively copy an entire directory and all of its subcomponents
    public void copyDirectory(File copyFiles, File newLoc) throws Exception {

        if (copyFiles.isDirectory()) {
            if (!newLoc.exists()) {
                // Create a new directory for the new copy location
                newLoc.mkdirs();
            }
            // List all the files within the files to be copies
            String newFolders[] = copyFiles.list();

            // For each of the folders we create a new file with path 
            for (String f : newFolders) {
                File sFolder = new File(copyFiles, f);
                File dFolder = new File(newLoc, f);
                // Repeat this process with a call to the same method to complete all folders
                copyDirectory(sFolder, dFolder);
            }
        } else {
            // If the directory is a file we create null input/output streams and bufferedinputs
            FileInputStream sourceStream = null;
            FileOutputStream destStream = null;

            BufferedInputStream bufferedSource = null;
            BufferedOutputStream bufferedDestination = null;

            try {
                // attemt to create an input stream with the file in hand
                sourceStream = new FileInputStream(copyFiles);
                // attempt to create an output stream to the copy location
                destStream = new FileOutputStream(newLoc);

                // Create a buffer for source and destination that is 8k
                bufferedSource = new BufferedInputStream(sourceStream, 8182);
                bufferedDestination = new BufferedOutputStream(destStream, 8182);

                // Int to hold data
                int data;

                // Loop through all data in file until source reads -1
                while ((data = bufferedSource.read()) != -1) {
                    bufferedDestination.write(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "There was an IO error.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {

                // Finally close the sources and destination
                if (bufferedSource != null) {
                    bufferedSource.close();
                }
                if (bufferedDestination != null) {
                    bufferedDestination.close();
                }
            }
        }

    }

    // Method which is called from the GUI that executes a particular setting: view, copy, delete, open
    public void loadDir(String text, String setting) {
        try {
            mainDir = new File(text);
            switch (setting) {
                // "view" - counts all folders and files in a directory to display on GUI
                case "view":
                    folderCount = 0;
                    fileCount = 0;
                    grabFiles(mainDir.getAbsoluteFile());
                    break;

                // "copy" - attempts to copy a directory to another location
                case "copy":

                    // Grab the users attempted new copy directory
                    String copyLoc = JOptionPane.showInputDialog(frame, "Enter a copy location.", "Copy", JOptionPane.PLAIN_MESSAGE);
                    // If the original directory exists and the text box has a directory in it
                    if (!copyLoc.isEmpty()) {

                        // Create the file with the new location
                        File newCopy = new File(copyLoc);
                        // Check if it doesn't already exist, so we don't overwrite something
                        if (!newCopy.exists()) {
                            int option = JOptionPane.showConfirmDialog(frame, "Confirm Copy");
                            switch (option) {
                                case JOptionPane.OK_OPTION:
                                    // Call to copyDirectory()
                                    copyDirectory(mainDir, newCopy);
                                    break;
                                case JOptionPane.NO_OPTION:
                                    break;
                                case JOptionPane.CANCEL_OPTION:
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            // Error message if the user attempts to copy to an existing directory
                            JOptionPane.showMessageDialog(frame, "Location chosen is already a directory, overwriting will cause errors.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Enter a new copy directory", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }

            // Catch all possible exceptions
        } catch (IOException ex) {
            System.out.println("IO: " + ex.getLocalizedMessage());
        } catch (NullPointerException e) {
            System.out.println("Null: " + e.getLocalizedMessage());
        } catch (Exception ex) {
            Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // This method returns the directory count to the GUI
    public static String getCount() {
        return ("Folders: " + folderCount
                + " - " + mainDir.length()
                + " bytes"
                + "\nFiles: " + fileCount);
    }
    
    public File getMainDir() {
        return mainDir;
    }

}
/*
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
 */