package homePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class UpdateAndDeleteClass extends JFrame {
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	JPanel updateAndDeletePanel, enterUsernamePanel, insertDataPanel, btnsPanel;
	JLabel enterUsernameLabel, FnameLabel, LnameLabel, EmailLabel, usernameLabel, passwordLabel;
	JTextField enterUsernameField, FnameField, LnameField, EmailField, usernameField;
	JPasswordField passwordField;
	JButton updateBtn, deleteBtn;
	public UpdateAndDeleteClass() {		
//		updateAndDeletePanel = new JPanel();
//		updateAndDeletePanel.setLayout(new BorderLayout());
		enterUsernamePanel = new JPanel();
		enterUsernameLabel = new JLabel("Enter username");
		enterUsernameField = new JTextField(20);
		enterUsernamePanel.add(enterUsernameLabel);
		enterUsernamePanel.add(enterUsernameField);
		
		insertDataPanel = new JPanel();
		insertDataPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel fnamePanel = new JPanel();
		FnameLabel = new JLabel("First name");
		FnameField = new JTextField(20);
		fnamePanel.add(FnameLabel);
		fnamePanel.add(FnameField);
		JPanel lnamePanel = new JPanel();
		LnameLabel = new JLabel("Last name");
		LnameField = new JTextField(20);
		lnamePanel.add(LnameLabel);
		lnamePanel.add(LnameField);
		JPanel emailPanel = new JPanel();
		EmailLabel = new JLabel("Email");
		EmailField = new JTextField(20);
		emailPanel.add(EmailLabel);
		emailPanel.add(EmailField);
		JPanel usernamePanel = new JPanel();
		usernameLabel = new JLabel("Username");
		usernameField = new JTextField(20);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		JPanel passwordPanel = new JPanel();		
		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField(20);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		insertDataPanel.add(fnamePanel);
		insertDataPanel.add(lnamePanel);
		insertDataPanel.add(emailPanel);
		insertDataPanel.add(usernamePanel);
		insertDataPanel.add(passwordPanel);
		
		
		btnsPanel = new JPanel();
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		
		btnsPanel.add(updateBtn);
		btnsPanel.add(deleteBtn);
		
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String firstEnteredUser = enterUsernameField.getText();
				String firstN = FnameField.getText();
				String lastN = LnameField.getText();
				String emailA = EmailField.getText();
				String userField = usernameField.getText();
				String passField = String.valueOf(passwordField.getPassword());
				try(Connection conn = DriverManager.getConnection(connectingString)){
										
					String updateData = "UPDATE Receptionist SET rc_Fname=?, rc_Lname=?, rc_email=?, rc_username=?, rc_password=? WHERE rc_username=?";
					try(PreparedStatement pstmtDataUpdate = conn.prepareStatement(updateData)){
						pstmtDataUpdate.setString(1, firstN);
						pstmtDataUpdate.setString(2, lastN);
						pstmtDataUpdate.setString(3, emailA);
						pstmtDataUpdate.setString(4, userField);
						pstmtDataUpdate.setString(5, passField);
						pstmtDataUpdate.setString(6,firstEnteredUser);
						
						pstmtDataUpdate.executeUpdate();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		setSize(320, 330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(enterUsernamePanel, BorderLayout.NORTH);
		add(insertDataPanel, BorderLayout.CENTER);
		add(btnsPanel, BorderLayout.SOUTH);
	}
	public void updateAndDeleteFun() throws SQLException {
			try(Connection conn = DriverManager.getConnection(connectingString)){
    		
    		String updatedOrDeleteSql = "SELECT * FROM Receptionist WHERE rc_username=?";
    		try(PreparedStatement pstmtUpdate = conn.prepareStatement(updatedOrDeleteSql)){
    			
    			
    			String valueUsername = enterUsernameField.getText();
    			
    			pstmtUpdate.setString(1, valueUsername);
    			try(ResultSet updateValue = pstmtUpdate.executeQuery()){
    				if(updateValue.next()) {
    					String fiName = updateValue.getString("rc_Fname");
    					String laName = updateValue.getString("rc_Lname");
    					String email = updateValue.getString("rc_email");
    					String user = updateValue.getString("rc_username");
    					String password = updateValue.getString("rc_password");
    					
    					FnameField.setText(fiName);
    					LnameField.setText(laName);
    					EmailField.setText(email);
    					usernameField.setText(user);
    					passwordField.setText(password);
    					passwordField.setEchoChar('*');
    				}
    			}
    			
    		}
    	}
	}
	
	public static void main(String[] args) {
		new UpdateAndDeleteClass().setVisible(true);
	}
}
