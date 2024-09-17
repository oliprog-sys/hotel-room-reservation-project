package hotelReservationPro;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class signUp extends JFrame implements ActionListener {
	JPanel logoPanel, userEmailAndPasswordPanel, createUsernamePanel, createNewPasswordPanel, confirmPasswordPanel, signUpButtonPanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel, confirmPassLabel; 
	JTextField usernameField, passwordField, confirmPassField;
	JButton signUpBtn, backBtn;
	
	public signUp() {
		// LOGO PANEL
		logoPanel = new JPanel();
		
		//hotel name label
		hotelNameLabel = new JLabel("Platinum Hotel");
		hotelNameLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
		
		// Add the hotel name label to the logo panel
		logoPanel.add(hotelNameLabel);
		
		// USERNAME AND PASSWORD CONTAINER
		userEmailAndPasswordPanel = new JPanel();
		
		// USERNAME ENTRY PANEL
		createUsernamePanel = new JPanel();
		createUsernamePanel.setBorder(BorderFactory.createEmptyBorder(39, 0, 0, 0));
		
		//username label
		usernameLabel = new JLabel("Create username");
		usernameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// username field
		usernameField = new JTextField(20);
		
		// Add the username components on the panel
		createUsernamePanel.add(usernameLabel);
		createUsernamePanel.add(usernameField);
		
		
		// PASSWORD ENTRY PANEL
		createNewPasswordPanel = new JPanel();
		// password label
		passwordLabel = new JLabel("Add Password");
		passwordLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// password field
		passwordField = new JTextField(20);
		
		// Add the password components to the panel
		createNewPasswordPanel.add(passwordLabel);
		createNewPasswordPanel.add(passwordField);
		
		// confirm password panel
		confirmPasswordPanel = new JPanel();
		// confirm password label
		confirmPassLabel = new JLabel("Confirm Password");
		confirmPassLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// confirm password field
		confirmPassField = new JTextField(20);
		
		confirmPasswordPanel.add(confirmPassLabel);
		confirmPasswordPanel.add(confirmPassField);
		
		// Add the userpanel and the password panel to the main panel 
		userEmailAndPasswordPanel.add(createUsernamePanel);
		userEmailAndPasswordPanel.add(createNewPasswordPanel);
		userEmailAndPasswordPanel.add(confirmPasswordPanel);
		
		// LOG IN PANEL
		signUpButtonPanel = new JPanel();
				
		// sign up button
		signUpBtn = new JButton("Sign up");
		signUpBtn.setFocusable(false);
		
		// back button
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		
		// Add the log in button to the panel
		signUpButtonPanel.add(signUpBtn);
		signUpButtonPanel.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		

		
		setSize(480, 300);
		setLocationRelativeTo(null);
		setTitle("Create account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setResizable(false);
		//setBackground(Color.black);
		add(logoPanel, BorderLayout.NORTH);
		add(userEmailAndPasswordPanel);
		add(signUpButtonPanel, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//		new signUp();
//	}
}
