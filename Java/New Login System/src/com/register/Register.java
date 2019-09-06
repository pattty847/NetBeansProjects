package com.register;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.login.LoginSystem;
import com.login.Password;
import com.login.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField emailText;
	private JButton btnCreate;
	
	private boolean isAdminBool = false;
	private JPasswordField passwordText;
	private JLabel lblRegisterAccount;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Username");
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(56, 96, 153, 16);
		contentPane.add(label);
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		usernameText.setBounds(177, 94, 220, 26);
		contentPane.add(usernameText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(56, 126, 153, 16);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(211, 211, 211));
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEmail.setBounds(56, 156, 153, 16);
		contentPane.add(lblEmail);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(177, 154, 220, 26);
		contentPane.add(emailText);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(177, 124, 220, 26);
		contentPane.add(passwordText);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(377, 249, 73, 23);
		contentPane.add(rdbtnAdmin);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordText.getPassword());
				boolean isAdmin = false;
				if(rdbtnAdmin.isSelected()) {
					String authentication = (String) JOptionPane.showInputDialog(contentPane, "Enter admin access code.", null, JOptionPane.YES_NO_OPTION);
					if(authentication.equalsIgnoreCase("admin")) {
						isAdmin = true;
					}else {
						JOptionPane.showMessageDialog(contentPane, "Unable to verify admin privilages.", "Admin access error", JOptionPane.OK_OPTION);
					}
				}
				
				
				if(!usernameText.getText().isEmpty() && !passwordText.getPassword().toString().isEmpty() && !emailText.getText().isEmpty()) {
						User newUser;
						try {
							newUser = new User(usernameText.getText(), 
									Password.hash(passText), 
									emailText.getText(), isAdmin);
							Password.writeToFile(newUser);
							JOptionPane.showMessageDialog(getContentPane(), "User created");
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else JOptionPane.showMessageDialog(getContentPane(), 
							"You must enter a Username, Password, and Email\nto create an account.");
					}
			});
		
		
		btnCreate.setBounds(64, 215, 220, 29);
		contentPane.add(btnCreate);
		
		lblRegisterAccount = new JLabel("Register Account");
		lblRegisterAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAccount.setForeground(Color.BLACK);
		lblRegisterAccount.setFont(new Font("Arial Unicode MS", Font.BOLD, 37));
		lblRegisterAccount.setBounds(0, 0, 450, 50);
		contentPane.add(lblRegisterAccount);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginSystem reg = new LoginSystem();
				reg.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(296, 215, 101, 29);
		contentPane.add(btnLogin);
		
	}
}
