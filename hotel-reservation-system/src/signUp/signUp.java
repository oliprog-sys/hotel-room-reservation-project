package signUp;

import java.awt.*;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import homePage.HomePageClass;
import logIn.SignIn;

import java.awt.event.*;
import java.sql.*;

public class signUp extends JFrame {
	JPanel logoPanel, userEmailAndPasswordPanel, createUsernamePanel, createNewPasswordPanel, signUpButtonPanel,
	firstNamePanel, lastNamePanel, emailPanel, rolePanel, checkBoxesPanel, branchAndRolePanel;
	JLabel hotelNameLabel, usernameLabel, passwordLabel, firstNameLabel, lastNameLabel, emailLabel; 
	JTextField usernameField, firstNameField, lastNameField, emailField;
	JButton signUpBtn, backBtn;
	JRadioButton adminRbtn, receRbtn, branchOneRB, branchTwoRB, branchThreeRB;
	JPasswordField passwordField;
	JCheckBox showPasswordCH;
	String branch, role;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
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
		userEmailAndPasswordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// first name panel
		firstNamePanel = new JPanel();
		
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		
		firstNameField = new JTextField(20);
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		// last name panel
		lastNamePanel = new JPanel();		
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Lato", Font.BOLD, 18));
		
		lastNameField = new JTextField(20);
	
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// email panel
		emailPanel = new JPanel();		
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lato", Font.BOLD, 18));
		
		emailField = new JTextField(20);
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		
		
		// role panel
		rolePanel = new JPanel();
		
		adminRbtn = new JRadioButton("Admin");
		receRbtn = new JRadioButton("Receptionist", true);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(adminRbtn);
		bg.add(receRbtn);
		
		rolePanel.add(adminRbtn);
		rolePanel.add(receRbtn);
		
		checkBoxesPanel = new JPanel();
		
		branchOneRB = new JRadioButton("Branch 1");
		branchTwoRB = new JRadioButton("Branch 2");
		branchThreeRB = new JRadioButton("Branch 3");
		
		ButtonGroup bgBranch = new ButtonGroup();
		bgBranch.add(branchOneRB);
		bgBranch.add(branchTwoRB);
		bgBranch.add(branchThreeRB);
		
		checkBoxesPanel.add(branchOneRB);
		checkBoxesPanel.add(branchTwoRB);
		checkBoxesPanel.add(branchThreeRB);
		
		// branch and role panel
		branchAndRolePanel = new JPanel();
		branchAndRolePanel.setLayout(new BoxLayout(branchAndRolePanel, BoxLayout.Y_AXIS));
		
		branchAndRolePanel.add(checkBoxesPanel);
		branchAndRolePanel.add(rolePanel);
		
		// USERNAME ENTRY PANEL
		createUsernamePanel = new JPanel();		
//		createUsernamePanel.setBorder(BorderFactory.createEmptyBorder(39, 0, 0, 0));
		
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
		passwordField = new JPasswordField(20);
		showPasswordCH = new JCheckBox("Show Password");
		
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
		userEmailAndPasswordPanel.add(branchAndRolePanel);
		
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
				new SignIn().setVisible(true);
				
			}
		});	
		
		showPasswordCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showHide();
			}
		});
		
		signUpBtn.addActionListener(new ActionListener() {

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
					System.out.println("Error: "+se.getMessage());
				}
				
			}
			
		});
		

		
		setSize(480, 410);
		setLocationRelativeTo(null);
		setTitle("Create account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setResizable(false);
		//setBackground(Color.black);
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
					dispose();
					hpc.setVisible(true);
				}
			}
		} catch(SQLException se) {
			System.out.println("Error: "+se.getMessage());
		}
		
		 
	}
	
//	public static void main(String[] args) {
//		new signUp();
//	}
}
