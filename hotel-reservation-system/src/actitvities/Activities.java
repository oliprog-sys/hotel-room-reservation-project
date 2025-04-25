package actitvities;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public abstract class Activities extends JFrame {
	Activities act;
	protected String gender;
	protected Double totalAmount=0.0;
	protected JPanel hotelNamePanel, activitiesPanel, checkInSelectedPanel, firstNamePanel,middleNamePanel, lastNamePanel,phoneNumPanel, 
	addressPanel,emailPanel, DOBPanel, genderPanel, resDetailAndPaymentPanel, reserveDetailPanel, checkInLabelAndDatePanel, 
	checkOutLabelAndDatePanel,singleRoomCHAndRA, doubleRoomCHAndRA, suiteRoomCHAndRA, tripleRoomCHAndRA, connectingRoomCHAndRA,
	deluxeRoomCHAndRA, paymentPanel, cardPaymentPanel, cashPaymentPanel, cardHolderPanel, cardNumberPanel, cardExpireDatePanel, 
	totalCardPaymentAmountPanel, cashPayerPanel, amountPanel, submitAndClearPanel, nationalityPanel, roomPanel;
	protected JLabel hotelNameLabel, firstNameLabel, middleNameLabel, lastNameLabel, phoneNumLabel, addressLabel, emailLabel, DoBLabel,
	checkOutDateLabel, singleRoomNumOfBeds, doubleRoomNumOfBeds, suiteRoomNumOfBeds, tripleRoomNumOfBeds, connectingRoomNumOfBeds,
	deluxeRoomNumOfBeds, cardHolderLabel, cardNumberLabel, cardExpireDateLabel, totalCardPaymentAmountLabel,
	cashPayerLabel, totalAmountLabel, nationalityLabel;
	protected JTextField firstNameField,middleNameField, lastNameField, phoneNumField, addressField, emailField, cardHolderField,
	cardNumberField, cardExpireDateField, totalCardPaymentAmountField, cashPayerField, amountField, nationalityField
	,singleRoomSearchResult, doubleRoomSearchResult, tripleRoomSearchResult, deluxeRoomSearchResult,
	connectingRoomSearchResult, suiteRoomSearchResult;
	protected JButton reserveBtn, guestsBtn, roomsBtn, submitBtn, clearBtn, postponeBtn, homeBtn,
	singleRoomSearch, doubleRoomSearch, suiteRoomSearch, tripleRoomSearch, connectingRoomSearch, deluxeRoomSearch,
	amountCardCalculateBtn, amountCashCalculateBtn;
	protected JRadioButton maleRB, femaleRB;
	protected JSpinner dateSpinner2,dateSpinner,dateSpinnerDoB , singleRoomAmount, doubleRoomAmount, suiteRoomAmount, tripleRoomAmount, connectingRoomAmount,
	deluxeRoomAmount, singleRoomNumOfBedAmount, doubleRoomNumOfBedAmount, suiteRoomNumOfBedAmount, tripleRoomNumOfBedAmount, 
	connectingRoomNumOfBedAmount, deluxeRoomNumOfBedAmount;
	protected JCheckBox singleRoomCH, doubleRoomCH, suiteRoomCH, tripleRoomCH, connectingRoomCH, deluxeRoomCH;
	protected JTabbedPane paymentTab, checkInPane, roomPane, guestsPane;
	
	
	
	
	public Activities() {
		
		
		// hotel name panel
		hotelNamePanel = new JPanel();
		hotelNamePanel.setBackground(null);
		hotelNamePanel.setLayout(new BoxLayout(hotelNamePanel, BoxLayout.Y_AXIS));
		
		hotelNameLabel = new JLabel("PLATINUM HOTEL");
		hotelNameLabel.setForeground(Color.white);
		hotelNameLabel.setFont(new Font("Heveltica", Font.BOLD, 34));
		hotelNameLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		// separator
		JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        		
		hotelNamePanel.add(hotelNameLabel);
		hotelNamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        hotelNamePanel.add(separator);
        hotelNamePanel.add(Box.createRigidArea(new Dimension(0, 10)));

		
		// activities panel
		activitiesPanel = new JPanel(new GridLayout(5, 1, 2, 0));	
		activitiesPanel.setBackground(new Color(36, 51, 51));
		
		reserveBtn = new JButton("Reserve");
		reserveBtn.setBackground(Color.LIGHT_GRAY);
		reserveBtn.setFocusable(false);
		reserveBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		roomsBtn = new JButton("Rooms");
		roomsBtn.setBackground(Color.LIGHT_GRAY);
		roomsBtn.setFocusable(false);
		roomsBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		guestsBtn = new JButton("Guests");
		guestsBtn.setBackground(Color.LIGHT_GRAY);
		guestsBtn.setFocusable(false);
		guestsBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		postponeBtn = new JButton("Postpone");
		postponeBtn.setFocusable(false);
		postponeBtn.setFont(new Font("Roboto", Font.BOLD, 23));
		postponeBtn.setBackground(Color.LIGHT_GRAY);
		ImageIcon homeicon = new ImageIcon("homeBtn.png");
		homeBtn = new JButton();
		homeBtn.setIcon(homeicon);
		homeBtn.setBorder(null);
		homeBtn.setBackground(Color.LIGHT_GRAY);
		homeBtn.setForeground(Color.white);
		homeBtn.setFocusable(false);
		
		
//		paymentsBtn = new JButton("Payments");
		activitiesPanel.add(homeBtn);
		activitiesPanel.add(reserveBtn);
		activitiesPanel.add(roomsBtn);
		activitiesPanel.add(guestsBtn);
		activitiesPanel.add(postponeBtn);

		
		setTitle("Activities");
		setSize(1200, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(36, 51, 51));
		setLocationRelativeTo(null);
		add(hotelNamePanel, BorderLayout.NORTH);
		add(activitiesPanel, BorderLayout.WEST);
	
	}

}
