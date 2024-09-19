package logIn;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import homePage.HomePageClass;
import signUp.signUp;



public class SignIn extends JFrame implements ActionListener {
	
	JPanel logoPanel, userAndPasswordPanel, usernamePanel, passwordPanel, loginButtonPanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel, errorLabel;
	JTextField usernameField;
	JButton loginBtn, createAccountBtn;
	JPasswordField passwordField;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	public static String recUsername;
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
				dispose();
				new signUp().setVisible(true);
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					if(checkUsernameAndPassword()) {
						dispose();
						recUsername = usernameField.getText(); 
						HomePageClass hpc = new HomePageClass();
						hpc.recIdValueInLogin();
						hpc.setVisible(true);
					} else {
						errorLabel.setText("Incorrect username or password");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				dispose();
				
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
