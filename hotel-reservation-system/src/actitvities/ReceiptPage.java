package actitvities;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReceiptPage extends JFrame {
	JPanel mainPanel, btnPanel;
	JLabel nameLabel, phoneLabel, nationalityLabel;
	JButton closeBtn;
	
	Activities ac;
	
	public ReceiptPage() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		nameLabel = new JLabel();
		phoneLabel = new JLabel();
		nationalityLabel = new JLabel();
		
		String fname = ac.firstNameField.getText();
		String lname = ac.middleNameField.getText();
		String gfname = ac.lastNameField.getText();
		String phone = ac.phoneNumField.getText();
		String nationality = ac.nationalityField.getText();
		
		nameLabel.setText("Name: "+fname+" "+lname+" "+gfname);
		phoneLabel.setText("Phone: "+phone);
		nationalityLabel.setText("Nationality: "+nationality);
		
		mainPanel.add(nameLabel);
		mainPanel.add(phoneLabel);
		mainPanel.add(nationalityLabel);
		
		btnPanel = new JPanel();
		
		closeBtn = new JButton("Close");
		
		btnPanel.add(closeBtn);
		
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		
		setSize(280, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(mainPanel);
		
	}
	
	public static void main(String[] args) {
		new ReceiptPage().setVisible(true);
	}
}
