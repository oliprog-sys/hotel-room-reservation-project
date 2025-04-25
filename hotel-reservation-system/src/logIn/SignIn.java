package logIn;

import java.awt.*;


import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import homePage.HomePageClass;
import signUp.signUp;



public class SignIn extends JFrame {
	
	JPanel logoPanel, userAndPasswordPanel, usernamePanel, passwordPanel, loginButtonPanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel, errorLabel;
	JTextField usernameField;
	JButton loginBtn, createAccountBtn;
	JPasswordField passwordField;
	public static  String receptionId;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	public static String recUsername;
	public SignIn() {		
		
		// LOGO PANEL
		logoPanel = new JPanel();
		logoPanel.setBackground(null);
		
		
		//hotel name label
		hotelNameLabel = new JLabel("Platinum Hotel");
		hotelNameLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
		hotelNameLabel.setForeground(Color.WHITE);
		
		// Add the hotel name label to the logo panel
		logoPanel.add(hotelNameLabel);
		
		// USERNAME AND PASSWORD CONTAINER
		userAndPasswordPanel = new JPanel();
		userAndPasswordPanel.setBackground(null);
		
		// USERNAME ENTRY PANEL
		usernamePanel = new JPanel();
		usernamePanel.setBackground(null);
		usernamePanel.setBorder(BorderFactory.createEmptyBorder(39, 0, 0, 0));
		
		//username label
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		usernameLabel.setForeground(Color.WHITE);
		// username field
		usernameField = new JTextField(20);
		
		// Add the username components on the panel
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		
		
		// PASSWORD ENTRY PANEL
		passwordPanel = new JPanel();
		passwordPanel.setBackground(null);
		// password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Lato", Font.BOLD, 18));
		passwordLabel.setForeground(Color.WHITE);
		// password field
		passwordField = new JPasswordField(20);
		
		// Add the password components to the panel
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		errorLabel = new JLabel();
		
		
		// Add the userpanel and the password panel to the main panel 
		userAndPasswordPanel.add(usernamePanel);
		userAndPasswordPanel.add(passwordPanel);
		userAndPasswordPanel.add(errorLabel);
		
		// LOG IN PANEL
		loginButtonPanel = new JPanel();
		loginButtonPanel.setBackground(null);
		
		// log in button 
		loginBtn = new JButton("LOG IN");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 15));
		loginBtn.setPreferredSize(new Dimension(90, 30));
		loginBtn.setBackground(new Color(90, 70, 230));
		loginBtn.setBorder(null);
		loginBtn.setFocusable(false);
		
		// sign up button
		createAccountBtn = new JButton("Create account");
		createAccountBtn.setBorder(null);
		createAccountBtn.setPreferredSize(new Dimension(140, 30));
		createAccountBtn.setFont(new Font("Roboto", Font.BOLD, 15));
		createAccountBtn.setForeground(Color.WHITE);
		createAccountBtn.setBackground(new Color(90, 70, 230));
		createAccountBtn.setFocusable(false);
		
		// Add the log in button to the panel
		loginButtonPanel.add(loginBtn);
		loginButtonPanel.add(createAccountBtn);
		
		createAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(usernameField.getText()!=null){
					JOptionPane.showMessageDialog(SignIn.this, "You should login.", "Warning", JOptionPane.WARNING_MESSAGE);					
				} else {
					dispose();
					new signUp().setVisible(true);
				}
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String userName = usernameField.getText();
					String password = String.valueOf(passwordField.getPassword());
					
					if(userName.isEmpty() || password.isEmpty()) {
						 JOptionPane.showMessageDialog(SignIn.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
					}else if(checkUsernameAndPassword()) {
						dispose();
						recUsername = usernameField.getText(); 
						HomePageClass hpc = new HomePageClass();
						hpc.recIdValueInLogin();
						receptionId = hpc.receptionistIdField.getText();
						hpc.setVisible(true);
					} 
					else {
						errorLabel.setForeground(Color.RED);
						errorLabel.setText("Incorrect username or password");
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
//				dispose();
				
			}
		});

		
		setSize(480, 300);
		setLocationRelativeTo(null);
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("signIn.png");
		setIconImage(icon.getImage());
		getContentPane().setBackground(new Color(80, 80, 80));
		setResizable(false);
		add(logoPanel, BorderLayout.NORTH);
		add(userAndPasswordPanel);
		add(loginButtonPanel, BorderLayout.SOUTH);		
		setVisible(true);
		
	}
	
	public boolean checkUsernameAndPassword() throws SQLException {
	    String user = usernameField.getText();
	    String password = String.valueOf(passwordField.getPassword());
		
	    try (Connection conn = DriverManager.getConnection(connectingString)) {
	        String checkSql = "SELECT rc_username, rc_password FROM Receptionist WHERE rc_username = ?";
	        
	        try (PreparedStatement pstmtCheck = conn.prepareStatement(checkSql)) {
	            pstmtCheck.setString(1, user); // Set the username parameter

	            try (ResultSet checkResult = pstmtCheck.executeQuery()) {
	                if (checkResult.next()) { // Check if a result is returned
	                    String recepName = checkResult.getString("rc_username");
	                    String recepPass = checkResult.getString("rc_password");
	                    
	                    // Check both username and password
	                    if (!recepName.equals(user) || !recepPass.equals(password)) {
	                        System.out.println("Incorrect username or password");
	                        return false;
	                    } else {
	                        System.out.println("Login successful");
	                    }
	                } else {
	                    System.out.println("Incorrect username or password");
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
	
	
	public static void main(String[] args) {
		new SignIn();
	}
}
