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
import javax.swing.JOptionPane;

/**
 *
 * @author pattt
 */
public class FileSearch {

    private static int folderCount = 0, fileCount = 0; // Ints to hold number of folders and files in a directory, and all sub-directories
    private static File mainDir; // File contining directory the user is searching

    private static Frame frame;

    public boolean doesDirExist(String text) {
        mainDir = new File(text);
        return mainDir.exists();
    }

    public static void countFiles(File file) throws IOException {
        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                folderCount++;
                countFiles(files.getAbsoluteFile());
            }
            if (files.isFile()) {
                fileCount++;
            }
        }
    }

    public static void copyFiles(File copyFile, File files) throws FileNotFoundException {
        if (copyFile.mkdir()) {
            try {
                int transferBytes;
                FileOutputStream outputStream = new FileOutputStream(copyFile);
                FileInputStream inputStream = new FileInputStream(files);
                while ((transferBytes = inputStream.read()) != -1) {
                    outputStream.write(transferBytes);
                }
            } catch (IOException ex) {
                ex.getLocalizedMessage();
            }
        }
    }

    public void loadDir(String text, String setting) {
        try {
            mainDir = new File(text);
            switch (setting) {
                case "view":
                    folderCount = 0; fileCount = 0;
                    countFiles(mainDir.getAbsoluteFile());
                    break;
                case "copy":
                    String copyLoc = JOptionPane.showInputDialog(frame, "Enter a copy location.", "Copy", JOptionPane.PLAIN_MESSAGE);
                    if (!copyLoc.isEmpty() && !doesDirExist(copyLoc)) {
                        int option = JOptionPane.showConfirmDialog(frame, "Confirm Copy");
                        switch (option) {
                            case JOptionPane.OK_OPTION:
                                File copyFile = new File(copyLoc);
                                copyFiles(copyFile, mainDir);
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
        }
    }
    
    public static String getCount() {
        return ("Folders: " + folderCount +
                " - " + mainDir.length() + 
                " bytes" +
                "\nFiles: " + fileCount);
    }

    public String getDir() {
        try{
            return mainDir.getName();
        }catch(NullPointerException e) {
            e.getLocalizedMessage();
        }
        return null;
    }
    
    public static int getFolderCount() {
        return folderCount;
    }

    public static int getFileCount() {
        return fileCount;
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
