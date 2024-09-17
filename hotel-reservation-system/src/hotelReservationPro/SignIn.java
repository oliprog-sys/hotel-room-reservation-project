package hotelReservationPro;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;


public class SignIn extends JFrame implements ActionListener {
	
	JPanel logoPanel, userAndPasswordPanel, usernamePanel, passwordPanel, loginButtonPanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel;
	JTextField usernameField, passwordField;
	JButton loginBtn, createAccountBtn;
	
	public SignIn() {
		// LOGO PANEL
		logoPanel = new JPanel();
		
		//hotel name label
		hotelNameLabel = new JLabel("Platinum Hotel");
		hotelNameLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
		
		// Add the hotel name label to the logo panel
		logoPanel.add(hotelNameLabel);
		
		// USERNAME AND PASSWORD CONTAINER
		userAndPasswordPanel = new JPanel();
		
		// USERNAME ENTRY PANEL
		usernamePanel = new JPanel();
		usernamePanel.setBorder(BorderFactory.createEmptyBorder(39, 0, 0, 0));
		
		//username label
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// username field
		usernameField = new JTextField(20);
		
		// Add the username components on the panel
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		
		
		// PASSWORD ENTRY PANEL
		passwordPanel = new JPanel();
		// password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// password field
		passwordField = new JTextField(20);
		
		// Add the password components to the panel
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		
		// Add the userpanel and the password panel to the main panel 
		userAndPasswordPanel.add(usernamePanel);
		userAndPasswordPanel.add(passwordPanel);
		
		// LOG IN PANEL
		loginButtonPanel = new JPanel();
		
		// log in button 
		loginBtn = new JButton("LOG IN");
		loginBtn.setFocusable(false);
		
		// sign up button
		createAccountBtn = new JButton("Create account");
		createAccountBtn.setFocusable(false);
		
		// Add the log in button to the panel
		loginButtonPanel.add(loginBtn);
		loginButtonPanel.add(createAccountBtn);
		
		createAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new signUp().setVisible(true);
			}
		});
		

		
		setSize(480, 300);
		setLocationRelativeTo(null);
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setResizable(false);
		//setBackground(Color.black);
		add(logoPanel, BorderLayout.NORTH);
		add(userAndPasswordPanel);
		add(loginButtonPanel, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignIn();
	}
}
