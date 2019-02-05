package com.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.client.MainProgram;
import com.register.Register;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;

public class LoginSystem {

	public JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;
	
	Password pass = new Password();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWiredClientLogin = new JLabel("We dun fuck around v1");
		lblWiredClientLogin.setBounds(0, 6, 450, 50);
		lblWiredClientLogin.setForeground(SystemColor.infoText);
		lblWiredClientLogin.setFont(new Font("Arial Unicode MS", Font.BOLD, 37));
		lblWiredClientLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblWiredClientLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(211, 211, 211));
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername.setBounds(38, 80, 153, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(38, 126, 153, 16);
		frame.getContentPane().add(lblPassword);
		
		
		usernameText = new JTextField();
		usernameText.setBounds(159, 78, 220, 26);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JRadioButton isAdmin = new JRadioButton("Admin");
		isAdmin.setBounds(6, 249, 73, 23);
		frame.getContentPane().add(isAdmin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usernameText.getText().isEmpty()) {
					String hash = new String(passwordText.getPassword());
					if(!hash.isEmpty())
					{
						pass.searchUsername(usernameText.getText(), hash, isAdmin.isSelected(), frame);
					}
				}
			}
		});
		btnLogin.setBounds(69, 217, 90, 29);
		frame.getContentPane().add(btnLogin);
		
		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(chckbxRememberMe.isSelected()) {
					String hash = new String(passwordText.getPassword());
					try {
						Password.writeLastLogin(usernameText.getText(), Password.hash(hash).toString());
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		chckbxRememberMe.setForeground(new Color(211, 211, 211));
		chckbxRememberMe.setBounds(259, 162, 120, 23);
		frame.getContentPane().add(chckbxRememberMe);
		
		String[] optionList = {"Forgot Username", "Forgot Password"};
		JButton btnForgot = new JButton("Forgot Info?");
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option = (String) JOptionPane.showInputDialog(frame, "Choose an option.", null, JOptionPane.QUESTION_MESSAGE, null,
				        optionList,
				        optionList[1]);
				switch(option) {
					case "Forgot Username": 
						String forgotUser = (String) JOptionPane.showInputDialog(frame, "Enter your email.", null, JOptionPane.QUESTION_MESSAGE);
					break;
					case "Forgot Password": 
						String username = (String) JOptionPane.showInputDialog(frame, "Enter your username.", null, JOptionPane.QUESTION_MESSAGE);
						String forgotPassEmail = (String) JOptionPane.showInputDialog(frame, "Enter your email.", null, JOptionPane.QUESTION_MESSAGE);
						Password.emailReset(username, forgotPassEmail, frame);
					break;
				}
					
			}
		});
		
		btnForgot.setBounds(280, 217, 113, 29);
		frame.getContentPane().add(btnForgot);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnRegister.isEnabled()) {
					frame.setVisible(false);
					Register reg = new Register();
					reg.setVisible(true);
				}
			}
		});
		btnRegister.setBounds(178, 217, 90, 29);
		frame.getContentPane().add(btnRegister);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 197, 388, 13);
		frame.getContentPane().add(separator);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(159, 124, 220, 26);
		frame.getContentPane().add(passwordText);
		
	}
}
