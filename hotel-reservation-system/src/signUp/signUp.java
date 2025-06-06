package signUp;

import java.awt.*;
import javax.swing.*;

import actitvities.PostponeClass;
import homePage.HomePageClass;
import logIn.SignIn;

import java.awt.event.*;
import java.io.Reader;
import java.sql.*;

public class signUp extends JFrame {
	JPanel logoPanel, userEmailAndPasswordPanel, createUsernamePanel, createNewPasswordPanel, signUpButtonPanel,
	firstNamePanel, lastNamePanel, emailPanel, rolePanel, checkBoxesPanel, branchAndRolePanel, adminPanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel, firstNameLabel, lastNameLabel, emailLabel, adminLabel; 
	JTextField usernameField, firstNameField, lastNameField, emailField, adminUsername;
	JButton signUpBtn, backBtn;
	JRadioButton adminRbtn, receRbtn, branchOneRB, branchTwoRB, branchThreeRB;
	JPasswordField passwordField;
	JCheckBox showPasswordCH;
	String branch, role;
	
	public static String receptionId;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	public signUp() {
		// LOGO PANEL
		logoPanel = new JPanel();
		logoPanel.setBackground(null);
		
		//hotel name label
		hotelNameLabel = new JLabel("Platinum Hotel");
		hotelNameLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
		hotelNameLabel.setForeground(Color.white);
		
		// Add the hotel name label to the logo panel
		logoPanel.add(hotelNameLabel);
		
		// USERNAME AND PASSWORD CONTAINER
		userEmailAndPasswordPanel = new JPanel();
		userEmailAndPasswordPanel.setBackground(null);
		userEmailAndPasswordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// first name panel
		firstNamePanel = new JPanel();		
		firstNamePanel.setBackground(null);
		
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		firstNameLabel.setForeground(Color.white);
		
		firstNameField = new JTextField(20);
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		// last name panel
		lastNamePanel = new JPanel();	
		lastNamePanel.setBackground(null);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(Color.white);
		lastNameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		
		lastNameField = new JTextField(20);
	
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// email panel
		emailPanel = new JPanel();		
		emailPanel.setBackground(null);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lato", Font.BOLD, 18));
		emailLabel.setForeground(Color.white);
		
		emailField = new JTextField(20);
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		
		
		// role panel
		rolePanel = new JPanel();
		rolePanel.setBackground(null);
		
		adminRbtn = new JRadioButton("Admin");
		adminRbtn.setBackground(null);
		adminRbtn.setForeground(Color.white);
		adminRbtn.setFont(new Font("Lato", Font.BOLD, 16));
		receRbtn = new JRadioButton("Receptionist", true);
		receRbtn.setForeground(Color.white);
		receRbtn.setFont(new Font("Lato", Font.BOLD, 16));
		receRbtn.setBackground(null);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(adminRbtn);
		bg.add(receRbtn);
		
		rolePanel.add(adminRbtn);
		rolePanel.add(receRbtn);
		
		checkBoxesPanel = new JPanel();		
		checkBoxesPanel.setBackground(null);
		
		branchOneRB = new JRadioButton("Branch 1");
		branchOneRB.setForeground(Color.white);
		branchOneRB.setFont(new Font("Lato", Font.BOLD, 16));
		branchOneRB.setBackground(null);
		branchTwoRB = new JRadioButton("Branch 2");
		branchTwoRB.setForeground(Color.white);
		branchTwoRB.setFont(new Font("Lato", Font.BOLD, 16));
		branchTwoRB.setBackground(null);
		branchThreeRB = new JRadioButton("Branch 3");
		branchThreeRB.setForeground(Color.white);
		branchThreeRB.setFont(new Font("Lato", Font.BOLD, 16));
		branchThreeRB.setBackground(null);
		
		ButtonGroup bgBranch = new ButtonGroup();
		bgBranch.add(branchOneRB);
		bgBranch.add(branchTwoRB);
		bgBranch.add(branchThreeRB);
		
		checkBoxesPanel.add(branchOneRB);
		checkBoxesPanel.add(branchTwoRB);
		checkBoxesPanel.add(branchThreeRB);
		
		// branch and role panel
		branchAndRolePanel = new JPanel();
		branchAndRolePanel.setBackground(null);
		branchAndRolePanel.setLayout(new BoxLayout(branchAndRolePanel, BoxLayout.Y_AXIS));
		
		branchAndRolePanel.add(checkBoxesPanel);
		branchAndRolePanel.add(rolePanel);
		
		// USERNAME ENTRY PANEL
		createUsernamePanel = new JPanel();		
		createUsernamePanel.setBackground(null);
//		createUsernamePanel.setBorder(BorderFactory.createEmptyBorder(39, 0, 0, 0));
		
		//username label
		usernameLabel = new JLabel("Create username");
		usernameLabel.setForeground(Color.white);
		usernameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// username field
		usernameField = new JTextField(20);
		
		// Add the username components on the panel
		createUsernamePanel.add(usernameLabel);
		createUsernamePanel.add(usernameField);
		
		
		// PASSWORD ENTRY PANEL
		createNewPasswordPanel = new JPanel();		
		createNewPasswordPanel.setBackground(null);
		// password label
		passwordLabel = new JLabel("Add Password");
		passwordLabel.setForeground(Color.white);
		passwordLabel.setFont(new Font("Lato", Font.BOLD, 18));
		// password field
		passwordField = new JPasswordField(20);
		showPasswordCH = new JCheckBox("Show Password");
		showPasswordCH.setForeground(Color.white);
		showPasswordCH.setBackground(null);
		
//		adminPanel = new JPanel();
//		adminPanel.setBackground(null);
//		adminLabel = new JLabel("Admin Username");
//		adminLabel.setForeground(Color.white);
//		adminLabel.setFont(new Font("Lato", Font.BOLD, 18));
//		adminUsername = new JTextField(20);
//		adminPanel.add(adminLabel);
//		adminPanel.add(adminUsername);
		
		// Add the password components to the panel
		createNewPasswordPanel.add(passwordLabel);
		createNewPasswordPanel.add(passwordField);
		createNewPasswordPanel.add(showPasswordCH);
		
		
		
		// Add the userpanel and the password panel to the main panel
		userEmailAndPasswordPanel.add(firstNamePanel);
		userEmailAndPasswordPanel.add(lastNamePanel);
		userEmailAndPasswordPanel.add(emailPanel);
		userEmailAndPasswordPanel.add(createUsernamePanel);
		userEmailAndPasswordPanel.add(createNewPasswordPanel);
//		userEmailAndPasswordPanel.add(adminPanel);
		userEmailAndPasswordPanel.add(branchAndRolePanel);
		
		// LOG IN PANEL
		signUpButtonPanel = new JPanel();
		signUpButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30, 2));
		signUpButtonPanel.setBackground(null);
				
		// sign up button
		signUpBtn = new JButton("Sign up");
		signUpBtn.setPreferredSize(new Dimension(90, 30));
		signUpBtn.setBorder(null);
		signUpBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		signUpBtn.setBackground(new Color(90, 70, 230));
		signUpBtn.setForeground(Color.white);
		signUpBtn.setFocusable(false);
		
		// back button
		backBtn = new JButton("Back");
		backBtn.setPreferredSize(new Dimension(90, 30));
		backBtn.setBorder(null);
		backBtn.setFont(new Font("Roboto", Font.BOLD, 17));
		backBtn.setBackground(new Color(230, 30, 30));
		backBtn.setForeground(Color.white);
		backBtn.setFocusable(false);
		
		// Add the log in button to the panel
		signUpButtonPanel.add(signUpBtn);
		signUpButtonPanel.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new SignIn().setVisible(true);
				
			}
		});	
		
		showPasswordCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showHide();
			}
		});
		
		signUpBtn.addActionListener(new ActionListener() {
			
//			String adminName = String.valueOf(adminPassword.getPassword());
			@Override
			public void actionPerformed(ActionEvent e) {
				try {									
					
					if(branchOneRB.isSelected()) {
						branch = "b1";
					} else if(branchTwoRB.isSelected()) {
						branch = "b2";
					} else if(branchThreeRB.isSelected()) {
						branch = "b3";
					}
					if(adminRbtn.isSelected()) {
						role = "Admin";
					} else if(receRbtn.isSelected()) {
						role = "Receptionist";
					}					
					
					addRece();					
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(signUp.this, "You are not allowed to create Account.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		});
		

		
		setSize(480, 480);
		setLocationRelativeTo(null);
		setTitle("Create account");
		ImageIcon icon = new ImageIcon("signUp3.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setResizable(false);
		getContentPane().setBackground(new Color(80, 80, 80));
		add(logoPanel, BorderLayout.NORTH);
		add(userEmailAndPasswordPanel);
		add(signUpButtonPanel, BorderLayout.SOUTH);
//		setVisible(true);
		
	}
	
	void showHide() {
		if(showPasswordCH.isSelected()) {
			passwordField.setEchoChar((char) 0);
		} else {
			passwordField.setEchoChar('*');
		}
	}
	
	public void addRece() throws SQLException  {
		String fiName = firstNameField.getText();
		String laName = lastNameField.getText();
		String email = emailField.getText();
		String userName = usernameField.getText();
		String pass = String.valueOf(passwordField.getPassword());
		
		
		String recSql = "INSERT INTO Receptionist(rc_Fname, rc_Lname, rc_role, rc_email, rc_username, rc_password, Br_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(connectingString);
			PreparedStatement pstmtRec = conn.prepareStatement(recSql, Statement.RETURN_GENERATED_KEYS)){
			pstmtRec.setString(1, fiName);
			pstmtRec.setString(2, laName);
			pstmtRec.setString(3, role);
			pstmtRec.setString(4, email);
			pstmtRec.setString(5, userName);
			pstmtRec.setString(6, pass);
			pstmtRec.setString(7, branch);
			
			pstmtRec.executeUpdate();
			try(ResultSet generatedRecId = pstmtRec.getGeneratedKeys()){
				if(generatedRecId.next()) {
					int recId = generatedRecId.getInt(1);
					String recIdString = String.valueOf(recId);
					HomePageClass hpc = new HomePageClass();
					hpc.recIdValueInSignUp(recIdString);
					receptionId = hpc.receptionistIdField.getText();
					dispose();
//					hpc.setVisible(true);
					JOptionPane.showMessageDialog(signUp.this,"Reception added successfully");
				}
			}
		} catch(SQLException se) {
			System.out.println("Error: "+se.getMessage());
		}
		
		 
	}
	
	public boolean checkAdmin() throws SQLException {
		String username = usernameField.getText();
		
		try(Connection conn = DriverManager.getConnection(connectingString)){
			String adminCheck = "SELECT * FROM Receptionist WHERE rc_username=?";
			try(PreparedStatement pstmtAdmin = conn.prepareStatement(adminCheck)){
				pstmtAdmin.setString(1, username);
				pstmtAdmin.executeUpdate();
				
				 try (ResultSet checkResult = pstmtAdmin.executeQuery()) {
		                if (checkResult.next()) { // Check if a result is returned
//		                    String recepName = checkResult.getString("rc_username");
		                    String recepPass = String.valueOf(checkResult.getString("rc_username"));
		                    
		                    // Check both username and password
		                    if (!recepPass.equals(username)) {
		                        System.out.println("Incorrect username or password");
		                        return false;
		                    } else {
		                        System.out.println("SignUp successful");
		                    }
		                } else {
		                    System.out.println("Incorrect password");
		                    return false;
		                }
		            }
								
			} 
		} 			
		return true;
	}
	
//	public static void main(String[] args) {
//		new signUp();
//	}
}
