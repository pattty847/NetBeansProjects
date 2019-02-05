package com.login;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.client.MainProgram;

public class Password {
	
	private static String[] usernames, passwords, emails, types;

    public static String hash(String p) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hash = digest.digest(p.getBytes(StandardCharsets.UTF_8));
        return bytesToHexString(hash);
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
    
    public static void writeToFile(User u) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("login.txt", true);
            writer.write(u.toString());
            writer.close();
        } catch (IOException e) {
            System.err.println("Could not open file for writing");
            System.exit(1);
        }
    }
    
    public static void writeLastLogin(String username, String password) {
		//Add method to check if user already is written in file. File.hasContext()
    	FileWriter writer = null;
        try {
            writer = new FileWriter("lastlogin.txt", true);
            String login = username + '\n'+password;
            writer.write(login);
            writer.close();
        } catch (IOException e) {
            System.err.println("Could not open file for writing");
            System.exit(1);
        }
    }
    
    public static void searchUsername(String user, String hashPass, boolean isAdmin, JFrame frame) {
    	String username, password, email, type;
    	File f = new File("login.txt");
			Scanner scan;
			try {
				scan = new Scanner(f);
				while(scan.hasNextLine()) {
					username = scan.nextLine();
					password = scan.nextLine();
					email = scan.nextLine();
					type = scan.nextLine();
					if(username.equals(user)) {
						if(password.equals(hash(hashPass))) {
							switch(type) {
							case "true": 
								if(!isAdmin) {
									System.out.println("User found: " + username + ", but has admin privilages. Select 'Admin'.");
									break;
								}
								if(isAdmin) {
									frame.dispose();
									MainProgram admin = new MainProgram();
									admin.setVisible(true);
									break;
								}
								
							case "false": 
								if (isAdmin) {
									System.out.println("User found: " + username + ", but not admin privlilages."); 
									break;
								}
								if(!isAdmin) {
									MainProgram userProg = new MainProgram();
									frame.dispose();
									userProg = new MainProgram();
									userProg.setVisible(true);
									break;
								}
							}
						}else {
							JOptionPane.showMessageDialog(frame, "Username or password incorrect.", "Error!", JOptionPane.OK_OPTION);
						}
					} 
				}
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    public static void emailReset(String username, String emailSearch, JFrame frame) {
    	String email, type, password;
    	File f = new File("login.txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
			while(scan.hasNextLine()) {
				username = scan.nextLine();
				password = scan.nextLine();
				email = scan.nextLine();
				type = scan.nextLine();
				if(emailSearch.equals(email)) {
					JOptionPane.showMessageDialog(frame, "If there is a user with this account, an email has been sent.", "Email", JOptionPane.OK_OPTION);
					break;
				}else {
					JOptionPane.showMessageDialog(frame, "If there is a user with this account, an email has been sent.", "Email", JOptionPane.OK_OPTION);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
//    public static void readFromFile() {
//    	File f = new File("login.txt");
//    	int user = 0, pass = 0, email = 0, type = 0;
//    	try {
//			Scanner scan = new Scanner(f);
//			Scanner scanner = new Scanner(f);
//			scanner.useDelimiter(":");
//			scan.useDelimiter(":");
//			whil
//				scanner.nextLine();
//			}
//			Scanner addLogin = new Scanner(f);
//			addLogin.useDelimiter(":");
//			for(int i = 0; i < type; i++) {
//				usernames[i] = addLogin.nextLine();
//				passwords[i] = addLogin.nextLine();
//				emails[i] = addLogin.nextLine();
//				types[i] = addLogin.nextLine();
//			}
//			for(String s : usernames) {e(scan.hasNextLine()) {
//				scan.nextLine();
//				user++;
//				scan.nextLine();
//				pass++;
//				scan.nextLine();
//				email++;
//				scan.nextLine();
//				type++;
//			}
//			while(scanner.hasNextLine()) {
//				usernames = new String[user];
//				scanner.nextLine();
//				passwords = new String[pass];
//				scanner.nextLine();
//				emails = new String[email];
//				scanner.nextLine();
//				types = new String[type];
//				System.out.println(s);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//    }
}
