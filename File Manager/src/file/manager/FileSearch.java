/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.manager;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author pattt
 */
public class FileSearch {

    private static int folderCount = 0, fileCount = 0; // Ints to hold number of folders and files in a directory, and all sub-directories
    private static File mainDir; // File contining directory the user is searching
    private static File[] subDirs;
    private static Frame frame;

    public boolean doesDirExist(String text) {
        mainDir = new File(text);
        return mainDir.exists();
    }

    public static void countFiles(File file) throws IOException, NullPointerException {
        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                folderCount++;
                folderNames.add(files.getAbsolutePath());
                countFiles(files.getAbsoluteFile());
            } else if (files.isFile()) {
                fileCount++;
                fileNames.add(files.getAbsolutePath());
            }
        }
    }

    public static void copyFiles(String copyLoc, File files) throws FileNotFoundException {
        File copyFile = new File(copyLoc);
// Create the directory for the new copy location
        if (copyFile.mkdir()) {
            try {
                int transferBytes;
                FileOutputStream outputStream = new FileOutputStream(copyFile);
                for (File f : files.listFiles()) {
// list all files and if there is a directory in the first place open it with recursion
                    System.out.println("listing files:" + Arrays.toString(files.listFiles()));
                    if (f.isDirectory()) {
                        System.out.println("directory recursion open: " + f.getAbsolutePath());
                        copyFiles(f.getAbsolutePath(), f);
                    } else if (f.isFile()) {
                        FileInputStream inputStream = new FileInputStream(f);
                        while ((transferBytes = inputStream.read()) != -1) {
                            System.out.println(transferBytes);
                            outputStream.write(transferBytes);
                        }
                    }
                }

            } catch (IOException ex) {
                ex.getLocalizedMessage();
            }
        }
    }

    private static ArrayList<String> folderNames = new ArrayList<>();
    private static ArrayList<String> fileNames = new ArrayList<>();

    public void copyDirectory(String copyLocation, File directory) {
        File newDir = new File(copyLocation);
        if (newDir.mkdir()) {
            
            
            
        } else {
            System.out.println("Directory not made.");
        }
    }

    public void loadDir(String text, String setting) {
        try {
            mainDir = new File(text);
            switch (setting) {
                case "view":
                    folderCount = 0;
                    fileCount = 0;
                    countFiles(mainDir.getAbsoluteFile());
                    break;
                case "copy":
                    String copyLoc = JOptionPane.showInputDialog(frame, "Enter a copy location.", "Copy", JOptionPane.PLAIN_MESSAGE);
                    if (!copyLoc.isEmpty() && !doesDirExist(copyLoc)) {
                        int option = JOptionPane.showConfirmDialog(frame, "Confirm Copy");
                        switch (option) {
                            case JOptionPane.OK_OPTION:
                                copyFiles(copyLoc, mainDir);
                                break;
                            case JOptionPane.NO_OPTION:
                                break;
                            case JOptionPane.CANCEL_OPTION:
                                break;
                            default:
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Location chosen is already a directory, overwriting will cause errors.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    public static String getCount() {
        return ("Folders: " + folderCount
                + " - " + mainDir.length()
                + " bytes"
                + "\nFiles: " + fileCount);
    }

    public String getDir() {
        try {
            return mainDir.getName();
        } catch (NullPointerException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public File getMainDir() {
        return mainDir;
    }

    public static ArrayList<String> getFolderNames() {
        return folderNames;
    }

    public static ArrayList<String> getFileNames() {
        return fileNames;
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
