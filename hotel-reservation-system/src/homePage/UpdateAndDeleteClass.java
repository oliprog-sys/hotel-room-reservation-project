package homePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import lab6GUI.BasicForm;


public class UpdateAndDeleteClass extends JFrame {
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	JPanel updateAndDeletePanel, enterUsernamePanel, insertDataPanel, btnsPanel;
	JLabel enterUsernameLabel, FnameLabel, LnameLabel, EmailLabel, usernameLabel, passwordLabel, errorLabel;
	JTextField enterUsernameField, FnameField, LnameField, EmailField, usernameField;
	JPasswordField passwordField;
	JButton updateBtn, deleteBtn, searchBtn, closeBtn;
	public UpdateAndDeleteClass() {		
//		updateAndDeletePanel = new JPanel();
//		updateAndDeletePanel.setLayout(new BorderLayout());
		enterUsernamePanel = new JPanel();
		enterUsernamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		enterUsernameLabel = new JLabel("Enter username");
		enterUsernameField = new JTextField(20);
		searchBtn = new JButton("Search");
		enterUsernamePanel.add(enterUsernameLabel);
		enterUsernamePanel.add(enterUsernameField);
		enterUsernamePanel.add(searchBtn);		
		
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
		JPanel errorPanel = new JPanel();
		errorLabel = new JLabel();
		errorPanel.add(errorLabel);
		
		insertDataPanel.add(fnamePanel);
		insertDataPanel.add(lnamePanel);
		insertDataPanel.add(emailPanel);
		insertDataPanel.add(usernamePanel);
		insertDataPanel.add(passwordPanel);
		insertDataPanel.add(errorPanel);
		
		
		btnsPanel = new JPanel();
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		closeBtn = new JButton("Close");
		
		btnsPanel.add(updateBtn);
		btnsPanel.add(deleteBtn);
		btnsPanel.add(closeBtn);
		
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		HomePageClass hpc = new HomePageClass();
		
		
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
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
					errorLabel.setText("Updated Successfully");
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
			    String firstEnteredUser = enterUsernameField.getText();

			    // Show confirmation dialog before deleting
			    int result = JOptionPane.showConfirmDialog(
			        UpdateAndDeleteClass.this,
			        "Are you sure you want to delete this account?",
			        "Confirm Deletion",
			        JOptionPane.YES_NO_OPTION,
			        JOptionPane.QUESTION_MESSAGE
			    );

			    if (result == JOptionPane.YES_OPTION) {
			        try (Connection conn = DriverManager.getConnection(connectingString)) {
			            String deleteSql = "DELETE FROM Receptionist WHERE rc_username=?";
			            try (PreparedStatement pstmtDelete = conn.prepareStatement(deleteSql)) {
			                pstmtDelete.setString(1, firstEnteredUser);

			                // Execute the delete operation
			                int rowsAffected = pstmtDelete.executeUpdate();
			                
			                // Check if the deletion was successful
			                if (rowsAffected > 0) {
			                    errorLabel.setText("Account Deleted Successfully");
			                } else {
			                    errorLabel.setText("No account found with that username");
			                }
			            }
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			            errorLabel.setText("Database error occurred: " + e1.getMessage());
			        }
			    }
			}
			
		});
		
		searchListener sl = new searchListener();
		searchBtn.addActionListener(sl);
		
		
		setSize(400, 330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(enterUsernamePanel, BorderLayout.NORTH);
		add(insertDataPanel, BorderLayout.CENTER);
		add(btnsPanel, BorderLayout.SOUTH);
	}
//	public void updateAndDeleteFun() throws SQLException {
//			
//	}
//	
	class searchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try(Connection conn = DriverManager.getConnection(connectingString)){
	    		
	    		String updatedOrDeleteSql = "SELECT * FROM Receptionist WHERE rc_username=?";
	    		try(PreparedStatement pstmtUpdate = conn.prepareStatement(updatedOrDeleteSql)){
	    			
	    			
	    			String valueUsername = enterUsernameField.getText();
	    			pstmtUpdate.setString(1, valueUsername);    			    		
	    			
	    			
	    			try(ResultSet updateValue = pstmtUpdate.executeQuery()){
	    				if(updateValue.next()) {
	    					errorLabel.setText("");
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
	    				else {
	    					errorLabel.setText("Incorrect username");
	    				}
	    			}
	    			
	    		}
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new UpdateAndDeleteClass().setVisible(true);
	}
}
