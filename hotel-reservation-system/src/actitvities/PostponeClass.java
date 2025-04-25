package actitvities;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;

public class PostponeClass extends Activities {
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
            + "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	JPanel postponePanel, firstPanel, lastPanel, checkInPanel, checkOutPanel, updateAndClearPanel;
	JLabel firstName, lastName, checkInLabel, checkOutLabel;
	JTextField firstField, lastField;
	JButton updateBtn, clearBtn;
	
	public PostponeClass() {
		
		postponePanel = new JPanel();
		postponePanel.setLayout(new BoxLayout(postponePanel, BoxLayout.Y_AXIS));
		postponePanel.setBackground(new Color(36, 51, 51));
		
		JPanel firstAndSecondPanel = new JPanel();
		firstAndSecondPanel.setBackground(null);
		
		firstPanel = new JPanel();
		firstPanel.setBackground(null);
		
		firstName = new JLabel("First Name");
		firstName.setForeground(Color.white);
		firstName.setFont(new Font("Roboto", Font.BOLD, 28));
		firstField = new JTextField(30);
		firstField.setPreferredSize(new Dimension(40, 30));
		firstField.setFont(new Font("Sans", Font.PLAIN, 17));
		firstPanel.add(firstName);
		firstPanel.add(firstField);
		
		
		lastPanel = new JPanel();
		lastPanel.setBackground(null);
		
		lastName = new JLabel("Last Name");
		lastName.setForeground(Color.white);
		lastName.setFont(new Font("Roboto", Font.BOLD, 28));
		lastField = new JTextField(30);
		lastField.setPreferredSize(new Dimension(40, 30));
		lastField.setFont(new Font("Sans", Font.PLAIN, 17));
		lastPanel.add(lastName);
		lastPanel.add(lastField);
		
		firstAndSecondPanel.add(firstPanel);
		firstAndSecondPanel.add(lastPanel);
		
		JPanel checkInAndCheckOutPanel = new JPanel();
		checkInAndCheckOutPanel.setBackground(null);
		
		checkInPanel = new JPanel();
		checkInPanel.setBackground(null);
		
		checkInLabel = new JLabel("Check In:");
		checkInLabel.setForeground(Color.white);
		checkInLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		Calendar calendar = Calendar.getInstance();
		dateSpinner = new JSpinner(new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinner.setPreferredSize(new Dimension(110, 35));
		dateSpinner.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
		dateSpinner.setEditor(dateEditor);
		
		checkInPanel.add(checkInLabel);
		checkInPanel.add(dateSpinner);

		
		// Check out label and date panel
		checkOutPanel = new JPanel();
		checkOutPanel.setBackground(null);
		
		checkOutLabel = new JLabel("Check Out:");
		checkOutLabel.setForeground(Color.white);
		checkOutLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		Calendar calendar2 = Calendar.getInstance();
		dateSpinner2 = new JSpinner(new SpinnerDateModel(calendar2.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinner2.setPreferredSize(new Dimension(110, 35));
		dateSpinner2.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(dateSpinner2, "dd-MM-yyyy");
		dateSpinner2.setEditor(dateEditor2);
		
		checkOutPanel.add(checkOutLabel);
		checkOutPanel.add(dateSpinner2);
		
		checkInAndCheckOutPanel.add(checkInPanel);
		checkInAndCheckOutPanel.add(checkOutPanel);
		
		updateAndClearPanel = new JPanel();
		updateAndClearPanel.setBackground(null);
		updateBtn = new JButton("Update");
		updateBtn.setFocusable(false);
		updateBtn.setBackground(Color.GREEN);
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		updateBtn.setPreferredSize(new Dimension(130, 40));
		updateBtn.setBorder(null);
				
		clearBtn = new JButton("Clear");		
		clearBtn.setFocusable(false);
		clearBtn.setBackground(Color.RED);
		clearBtn.setForeground(Color.WHITE);
		clearBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		clearBtn.setPreferredSize(new Dimension(130, 40));
		clearBtn.setBorder(null);
		
		
		updateAndClearPanel.add(updateBtn);
		updateAndClearPanel.add(clearBtn);

		
//		postponePanel.add(firstPanel);
		postponePanel.add(firstAndSecondPanel);
//		postponePanel.add(checkInPanel);
		postponePanel.add(checkInAndCheckOutPanel);
		postponePanel.add(updateAndClearPanel, BorderLayout.SOUTH);
		
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
								
				try {					
					postpone();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(PostponeClass.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstField.setText("");
				lastField.setText("");
			}
			
		});
	}
	
	
	
	void postpone() throws SQLException {
		
		String fname = firstField.getText();
		String lname = lastField.getText();
		
		if(fname.isEmpty() || lname.isEmpty()) {
			throw new SQLException("Error");
		}
		
		java.util.Date chInDate = (java.util.Date) dateSpinner.getValue();
		java.sql.Date sqlChInDate = new java.sql.Date(chInDate.getTime());
		java.util.Date chOutDate = (java.util.Date) dateSpinner2.getValue();
		java.sql.Date sqlChOutDate = new java.sql.Date(chOutDate.getTime());
		
		try(Connection conn = DriverManager.getConnection(connectingString)){
			String postponeSql = "UPDATE ViewGuests SET [Check In]=?, [Check Out]=? WHERE [First Name]=? AND [Last Name]=?";
			try(PreparedStatement pstmtPost = conn.prepareStatement(postponeSql)){
				pstmtPost.setDate(1, sqlChInDate);
				pstmtPost.setDate(2, sqlChOutDate);
				pstmtPost.setString(3, fname);
				pstmtPost.setString(4, lname);
				pstmtPost.executeUpdate();	
				JOptionPane.showMessageDialog(PostponeClass.this,"Updated successfully");
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
