package actitvities;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import homePage.HomePageClass;
//import actitvities.Activities.ListenerClass;
//import homePage.HomePageClass;
import logIn.SignIn;
import signUp.signUp;

public class CheckInClass extends Activities {
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	JRadioButton paidRbtn1, paidRbtn2, notPaidRbtn1, notPaidRbtn2;
	String payVerify;
	JPanel currentPanel, errorPanel;
	JLabel errorLabel;
	public String date1, date2;
	public int differenceInDays;
	
	public CheckInClass() {
		
		// Check In clicked panel
		checkInSelectedPanel = new JPanel();
		checkInSelectedPanel.setOpaque(false);
		checkInSelectedPanel.setLayout(new BoxLayout(checkInSelectedPanel, BoxLayout.Y_AXIS));
		checkInSelectedPanel.setBorder(new EmptyBorder(35, 20, 0, 0));
		
		// first name panel
		firstNamePanel = new JPanel();
		firstNamePanel.setOpaque(false);
		
		firstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setForeground(Color.white);
	
		firstNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		firstNameField = new JTextField(30);
		firstNameField.setPreferredSize(new Dimension(20, 26));
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		//last name panel
		middleNamePanel = new JPanel();
		middleNamePanel.setOpaque(false);
		middleNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setForeground(Color.white);
		middleNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		middleNameField = new JTextField(30);
		middleNameField.setPreferredSize(new Dimension(20, 26));
		
		middleNamePanel.add(middleNameLabel);
		middleNamePanel.add(middleNameField);
		
		//grand father name panel
		lastNamePanel = new JPanel();
		lastNamePanel.setOpaque(false);
		lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(Color.white);		
		lastNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		lastNameField = new JTextField(30);
		lastNameField.setPreferredSize(new Dimension(20, 26));
		
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// Phone panel
		phoneNumPanel = new JPanel();
		phoneNumPanel.setOpaque(false);
		phoneNumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		phoneNumLabel = new JLabel("Phone Num");
		phoneNumLabel.setForeground(Color.white);
		phoneNumLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		phoneNumField = new JTextField(30);
		phoneNumField.setPreferredSize(new Dimension(20, 26));
		
		phoneNumPanel.add(phoneNumLabel);
		phoneNumPanel.add(phoneNumField);
		
		
		// address panel
		addressPanel = new JPanel();
		addressPanel.setOpaque(false);
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.white);
		addressLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		addressField = new JTextField(30);
		addressField.setPreferredSize(new Dimension(20, 26));
		
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		
		// email panel
		emailPanel = new JPanel();
		emailPanel.setOpaque(false);
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		emailLabel = new JLabel("Email");
		emailLabel.setForeground(Color.white);
		emailLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		emailField = new JTextField(30);
		emailField.setPreferredSize(new Dimension(20, 26));
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		
		
		// email panel
		nationalityPanel = new JPanel();
		nationalityPanel.setOpaque(false);
		nationalityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		nationalityLabel = new JLabel("Nationality");
		nationalityLabel.setForeground(Color.white);
		nationalityLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		nationalityField = new JTextField("Ethiopia" ,30);
		nationalityField.setPreferredSize(new Dimension(20, 26));
		
		nationalityPanel.add(nationalityLabel);
		nationalityPanel.add(nationalityField);

		
		//DoB label and date panel
		DOBPanel = new JPanel();
		DOBPanel.setOpaque(false);
		DOBPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		DoBLabel = new JLabel("Date of Birth:");
		DoBLabel.setForeground(Color.white);
		DoBLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		Calendar calendarDoB = Calendar.getInstance();
		dateSpinnerDoB= new JSpinner(new SpinnerDateModel(calendarDoB.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinnerDoB.setPreferredSize(new Dimension(110, 35));
		dateSpinnerDoB.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditorDoB = new JSpinner.DateEditor(dateSpinnerDoB, "dd-MM-yyyy");		
		dateSpinnerDoB.setEditor(dateEditorDoB);
		
	
		
		DOBPanel.add(DoBLabel);
		DOBPanel.add(dateSpinnerDoB);
		
		
		// Gender radio button panel
		genderPanel = new JPanel();
		genderPanel.setOpaque(false);
		
		maleRB = new JRadioButton("Male");
		maleRB.setOpaque(false);
		maleRB.setForeground(Color.white);
		maleRB.setFont(new Font("Roboto", Font.PLAIN, 17));
		femaleRB = new JRadioButton("Female");
		femaleRB.setOpaque(false);
		femaleRB.setForeground(Color.white);
		femaleRB.setFont(new Font("Sans", Font.PLAIN, 17));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		genderPanel.add(maleRB);
		genderPanel.add(femaleRB);
		
		errorPanel = new JPanel();
		errorPanel.setOpaque(false);
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.red);
		errorPanel.add(errorLabel);
		
		checkInSelectedPanel.add(firstNamePanel);
		checkInSelectedPanel.add(middleNamePanel);
		checkInSelectedPanel.add(lastNamePanel);
		checkInSelectedPanel.add(phoneNumPanel);
		checkInSelectedPanel.add(addressPanel);
		checkInSelectedPanel.add(emailPanel);
		checkInSelectedPanel.add(nationalityPanel);
		checkInSelectedPanel.add(DOBPanel);
		checkInSelectedPanel.add(genderPanel);
		checkInSelectedPanel.add(errorPanel);
		
		// reservation Details and payments panel
		resDetailAndPaymentPanel = new JPanel();
		resDetailAndPaymentPanel.setBackground(new Color(36, 51, 51));		
		resDetailAndPaymentPanel.setLayout(new BoxLayout(resDetailAndPaymentPanel, BoxLayout.Y_AXIS));
		
		// reservation detail panel
		reserveDetailPanel = new JPanel();
		reserveDetailPanel.setBackground(new Color(36, 51, 51));
		reserveDetailPanel.setLayout(new BoxLayout(reserveDetailPanel, BoxLayout.Y_AXIS));
		
		// check in label and date panel
		checkInLabelAndDatePanel = new JPanel();
		checkInLabelAndDatePanel.setOpaque(false);
		
		JLabel checkInDateLabel = new JLabel("Check In:");
		checkInDateLabel.setForeground(Color.white);
		checkInDateLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		Calendar calendar = Calendar.getInstance();
		dateSpinner = new JSpinner(new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinner.setPreferredSize(new Dimension(110, 35));
		dateSpinner.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
		dateSpinner.setEditor(dateEditor);
		
		checkInLabelAndDatePanel.add(checkInDateLabel);
		checkInLabelAndDatePanel.add(dateSpinner);
		
		// Check out label and date panel
		checkOutLabelAndDatePanel = new JPanel();
		checkOutLabelAndDatePanel.setOpaque(false);
		
		checkOutDateLabel = new JLabel("Check Out:");
		checkOutDateLabel.setForeground(Color.white);
		checkOutDateLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		Calendar calendar2 = Calendar.getInstance();
		dateSpinner2 = new JSpinner(new SpinnerDateModel(calendar2.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinner2.setPreferredSize(new Dimension(110, 35));
		dateSpinner2.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(dateSpinner2, "dd-MM-yyyy");
		dateSpinner2.setEditor(dateEditor2);
		
//		Date date1 = (Date) dateSpinner.getValue();
//		Date date2 = (Date) dateSpinner2.getValue();
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		checkOutLabelAndDatePanel.add(checkOutDateLabel);
		checkOutLabelAndDatePanel.add(dateSpinner2);
				
		
		JPanel ciAndcoPanel = new JPanel();
		ciAndcoPanel.setOpaque(false);
		ciAndcoPanel.setLayout(new BoxLayout(ciAndcoPanel, BoxLayout.Y_AXIS));
		
		
		ciAndcoPanel.add(checkInLabelAndDatePanel);
		ciAndcoPanel.add(checkOutLabelAndDatePanel);
		
		
		// Reservation Detail panel for the JTabbedPane
		JPanel reservationPanePanel = new JPanel();
		reservationPanePanel.setOpaque(false);
		
		// reservation tabbed pane
		JTabbedPane reservationPane = new JTabbedPane();
		reservationPane.setOpaque(false);
		
		
		
		// single room check box and number of rooms
		singleRoomCHAndRA = new JPanel();
		singleRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		singleRoomCHAndRA.setOpaque(false);
		
		singleRoomCH = new JCheckBox("Single Room");
		singleRoomCH.setForeground(Color.white);
		singleRoomCH.setBackground(new Color(36, 51, 51));
		singleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		singleRoomSearch = new JButton("Search");
		singleRoomSearchResult = new JTextField(15); 
		singleRoomSearchResult.setEditable(false);
//				singleRoomNumOfBeds = new JLabel("Number of Beds ");
//				singleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		singleRoomCHAndRA.add(singleRoomCH);
		singleRoomCHAndRA.add(singleRoomAmount);
//		singleRoomCHAndRA.add(singleRoomSearch);
		singleRoomCHAndRA.add(singleRoomSearchResult);
//				singleRoomCHAndRA.add(singleRoomNumOfBeds);
//				singleRoomCHAndRA.add(singleRoomNumOfBedAmount);
		
		
		// Double room check box and number of rooms
		doubleRoomCHAndRA = new JPanel();
		doubleRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		doubleRoomCHAndRA.setOpaque(false);
		
		doubleRoomCH = new JCheckBox("Double Room");
		doubleRoomCH.setBackground(new Color(36, 51, 51));
		doubleRoomCH.setForeground(Color.white);
		doubleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		doubleRoomSearch = new JButton("Search");
		doubleRoomSearchResult = new JTextField(15);
		doubleRoomSearchResult.setEditable(false);
//				doubleRoomNumOfBeds = new JLabel("Number of Beds ");
//				doubleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		doubleRoomCHAndRA.add(doubleRoomCH);
		doubleRoomCHAndRA.add(doubleRoomAmount);
//		doubleRoomCHAndRA.add(doubleRoomSearch);
		doubleRoomCHAndRA.add(doubleRoomSearchResult);
//				doubleRoomCHAndRA.add(doubleRoomNumOfBeds);
//				doubleRoomCHAndRA.add(doubleRoomNumOfBedAmount);
		
		// Suite room check box and number of rooms
		suiteRoomCHAndRA = new JPanel();
		suiteRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		suiteRoomCHAndRA.setOpaque(false);
		
		suiteRoomCH = new JCheckBox("Suite Room");
		suiteRoomCH.setForeground(Color.white);
		suiteRoomCH.setBackground(new Color(36, 51, 51));
		suiteRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		suiteRoomSearch = new JButton("Search");
		suiteRoomSearchResult = new JTextField(15);
		suiteRoomSearchResult.setEditable(false);
//				suiteRoomNumOfBeds = new JLabel("Number of Beds ");
//				suiteRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		suiteRoomCHAndRA.add(suiteRoomCH);
		suiteRoomCHAndRA.add(suiteRoomAmount);
//		suiteRoomCHAndRA.add(suiteRoomSearch);
		suiteRoomCHAndRA.add(suiteRoomSearchResult);
//				suiteRoomCHAndRA.add(suiteRoomNumOfBeds);
//				suiteRoomCHAndRA.add(suiteRoomNumOfBedAmount);
		
		
		// triple room check box and number of rooms
		tripleRoomCHAndRA = new JPanel();
		tripleRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		tripleRoomCHAndRA.setOpaque(false);
		
		tripleRoomCH = new JCheckBox("Triple Room");
		tripleRoomCH.setBackground(new Color(36, 51, 51));
		tripleRoomCH.setForeground(Color.white);
		tripleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		tripleRoomSearch = new JButton("Search");
		tripleRoomSearchResult = new JTextField(15);
		tripleRoomSearchResult.setEditable(false);
//				tripleRoomNumOfBeds = new JLabel("Number of Beds ");
//				tripleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		tripleRoomCHAndRA.add(tripleRoomCH);
		tripleRoomCHAndRA.add(tripleRoomAmount);
//		tripleRoomCHAndRA.add(tripleRoomSearch);
		tripleRoomCHAndRA.add(tripleRoomSearchResult);
//				tripleRoomCHAndRA.add(tripleRoomNumOfBeds);
//				tripleRoomCHAndRA.add(tripleRoomNumOfBedAmount);
		
		// deluxe room check box and number of rooms
		deluxeRoomCHAndRA = new JPanel();
		deluxeRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		deluxeRoomCHAndRA.setOpaque(false);
		
		deluxeRoomCH = new JCheckBox("Deluxe Room");
		deluxeRoomCH.setBackground(new Color(36, 51, 51));
		deluxeRoomCH.setForeground(Color.white);
		deluxeRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		deluxeRoomSearch = new JButton("Search");
		deluxeRoomSearchResult = new JTextField(15);
		deluxeRoomSearchResult.setEditable(false);
//				deluxeRoomNumOfBeds = new JLabel("Number of Beds ");
//				deluxeRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		deluxeRoomCHAndRA.add(deluxeRoomCH);
		deluxeRoomCHAndRA.add(deluxeRoomAmount);
//		deluxeRoomCHAndRA.add(deluxeRoomSearch);
		deluxeRoomCHAndRA.add(deluxeRoomSearchResult);
//				deluxeRoomCHAndRA.add(deluxeRoomNumOfBeds);
//				deluxeRoomCHAndRA.add(deluxeRoomNumOfBedAmount);
		
		
		// deluxe room check box and number of rooms
		connectingRoomCHAndRA = new JPanel();
		connectingRoomCHAndRA.setLayout(new FlowLayout(FlowLayout.LEFT));
		connectingRoomCHAndRA.setOpaque(false);
		
		connectingRoomCH = new JCheckBox("Connecting Room");
		connectingRoomCH.setBackground(new Color(36, 51, 51));
		connectingRoomCH.setForeground(Color.white);
		connectingRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
//		connectingRoomSearch = new JButton("Search");
		connectingRoomSearchResult = new JTextField(15);
		connectingRoomSearchResult.setEditable(false);
//				connectingRoomNumOfBeds = new JLabel("Number of Beds ");
//				connectingRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		connectingRoomCHAndRA.add(connectingRoomCH);
		connectingRoomCHAndRA.add(connectingRoomAmount);
//		connectingRoomCHAndRA.add(connectingRoomSearch);
		connectingRoomCHAndRA.add(connectingRoomSearchResult);
//				connectingRoomCHAndRA.add(connectingRoomNumOfBeds);
//				connectingRoomCHAndRA.add(connectingRoomNumOfBedAmount);
		JPanel searchPanel = new JPanel();
		searchPanel.setOpaque(false);
		JButton searchBtn = new JButton("Search");
		searchPanel.add(searchBtn);
		
		reserveDetailPanel.add(singleRoomCHAndRA);
		reserveDetailPanel.add(doubleRoomCHAndRA);
		reserveDetailPanel.add(suiteRoomCHAndRA);
		reserveDetailPanel.add(tripleRoomCHAndRA);
		reserveDetailPanel.add(deluxeRoomCHAndRA);
		reserveDetailPanel.add(connectingRoomCHAndRA);
		reserveDetailPanel.add(searchPanel);
//				reserveDetailPanel.add(checkInLabelAndDatePanel);
//				reserveDetailPanel.add(checkOutLabelAndDatePanel);
		
		reservationPane.addTab("Rooms", reserveDetailPanel);
		
		reservationPanePanel.add(reservationPane);
	
		// payment panel
		paymentPanel = new JPanel();
		paymentPanel.setOpaque(false);
		
		// payment area tabbed pane
		paymentTab = new JTabbedPane();
		
		// Card payment panel
		cardPaymentPanel = new JPanel();
		cardPaymentPanel.setBackground(new Color(36, 51, 51));
		cardPaymentPanel.setLayout(new BoxLayout(cardPaymentPanel, BoxLayout.Y_AXIS));
		
		// card holder name and field panel
		cardHolderPanel = new JPanel();
		cardHolderPanel.setOpaque(false);
		cardHolderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardHolderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cardHolderLabel = new JLabel("Card Holder Name");
		cardHolderLabel.setForeground(Color.white);
		cardHolderField = new JTextField(15);
		
		cardHolderPanel.add(cardHolderLabel);
		cardHolderPanel.add(cardHolderField);
		
		// card number and field panel
		cardNumberPanel = new JPanel();
		cardNumberPanel.setOpaque(false);
		cardNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setForeground(Color.white);
		cardNumberField = new JTextField(15);
		
		cardNumberPanel.add(cardNumberLabel);
		cardNumberPanel.add(cardNumberField);
		
//				// card expire date panel
//				cardExpireDatePanel = new JPanel();
//				
//				cardExpireDateLabel = new JLabel("Expiration Date");
//				cardExpireDateField  = new JTextField(10);
//				
//				cardExpireDatePanel.add(cardExpireDateLabel);
//				cardExpireDatePanel.add(cardExpireDateField);
		
		// Total payment amount panel
		totalCardPaymentAmountPanel = new JPanel();
		totalCardPaymentAmountPanel.setOpaque(false);
		
		totalCardPaymentAmountLabel = new JLabel("Total");
		totalCardPaymentAmountLabel.setForeground(Color.white);
		totalCardPaymentAmountField = new JTextField(15);
		totalCardPaymentAmountField.setEditable(false);
		amountCardCalculateBtn = new JButton("Calculate");
		
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountLabel);
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountField);
		totalCardPaymentAmountPanel.add(amountCardCalculateBtn);
		
		JPanel verifyCardPayment = new JPanel();
		verifyCardPayment.setOpaque(false);
		
		JLabel verifyCardLabel = new JLabel("Verify");
		verifyCardLabel.setForeground(Color.white);
		
		paidRbtn1 = new JRadioButton("Paid");
		paidRbtn1.setForeground(Color.white);
		paidRbtn1.setOpaque(false);
		notPaidRbtn1 = new JRadioButton("Not Paid", true);
		notPaidRbtn1.setForeground(Color.white);
		notPaidRbtn1.setOpaque(false);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(paidRbtn1);
		bg1.add(notPaidRbtn1);
		
		verifyCardPayment.add(verifyCardLabel);
		verifyCardPayment.add(paidRbtn1);
		verifyCardPayment.add(notPaidRbtn1);			
		
		
		
		// payment completed radio button panel
		
		cardPaymentPanel.add(cardHolderPanel);
		cardPaymentPanel.setBackground(new Color(36, 51, 51));
		cardPaymentPanel.add(cardNumberPanel);
//				cardPaymentPanel.add(cardExpireDatePanel);
		cardPaymentPanel.add(totalCardPaymentAmountPanel);
		cardPaymentPanel.add(verifyCardPayment);
		
		// Add to the specific payment panel to the payment tab		
		paymentTab.addTab("Card Payment", cardPaymentPanel);
		
		
		// Cash payment panel
		cashPaymentPanel = new JPanel();
		cashPaymentPanel.setOpaque(false);
		cashPaymentPanel.setLayout(new BoxLayout(cashPaymentPanel, BoxLayout.Y_AXIS));
		
		// payer name panel
		cashPayerPanel = new JPanel();
		cashPayerPanel.setBackground(new Color(36, 51, 51));
		cashPayerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cashPayerLabel = new JLabel("Payer Name");
		cashPayerLabel.setForeground(Color.white);
		cashPayerField = new JTextField(15);
		
		cashPayerPanel.add(cashPayerLabel);
		cashPayerPanel.add(cashPayerField);
		
		// paid amount panel
		amountPanel = new JPanel();
		amountPanel.setBackground(new Color(36, 51, 51));
		
		totalAmountLabel = new JLabel("Amount");
		totalAmountLabel.setForeground(Color.white);
		amountField = new JTextField(15);
		amountField.setEditable(false);
		amountCashCalculateBtn = new JButton("Calculate");
		
		amountPanel.add(totalAmountLabel);
		amountPanel.add(amountField);
		amountPanel.add(amountCashCalculateBtn);
		
		JPanel verifyCashPayment = new JPanel();
		verifyCashPayment.setBackground(new Color(36, 51, 51));
		
		JLabel verifyCashLabel = new JLabel("Verify");
		verifyCashLabel.setForeground(Color.white);
		paidRbtn2 = new JRadioButton("Paid");
		paidRbtn2.setForeground(Color.white);
		paidRbtn2.setBackground(new Color(36, 51, 51));
		notPaidRbtn2 = new JRadioButton("Not Paid", true);
		notPaidRbtn2.setForeground(Color.white);
		notPaidRbtn2.setBackground(new Color(36, 51, 51));
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(paidRbtn2);
		bg2.add(notPaidRbtn2);
		
		verifyCashPayment.add(verifyCashLabel);
		verifyCashPayment.add(paidRbtn2);
		verifyCashPayment.add(notPaidRbtn2);
		
		cashPaymentPanel.add(cashPayerPanel);
		cashPaymentPanel.add(amountPanel);
		cashPaymentPanel.add(verifyCashPayment);
		
		// add to specific tab
		paymentTab.addTab("Cash Payment", cashPaymentPanel);
		
		
		// Add the specific tab to the whole payment panel
		paymentPanel.add(paymentTab);
		
		
		// SUBMIT AND CLEAR BUTTONS
		submitAndClearPanel = new JPanel();
		submitAndClearPanel.setOpaque(false);
		
		submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(130, 40));
		clearBtn = new JButton("Clear");
		clearBtn.setPreferredSize(new Dimension(130, 40));
		
		submitAndClearPanel.add(submitBtn);
		submitAndClearPanel.add(clearBtn);
		
		
		
		
		resDetailAndPaymentPanel.add(ciAndcoPanel, BorderLayout.NORTH);
		resDetailAndPaymentPanel.add(reservationPanePanel, BorderLayout.CENTER);
		resDetailAndPaymentPanel.add(paymentPanel, BorderLayout.SOUTH);
		
		
		
		
		
		amountCardCalculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				totalCardPaymentAmountField.setText(String.valueOf(totalAmount));
			}
		});
		
		amountCashCalculateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				amountField.setText(String.valueOf(totalAmount));
			}
		});
		
		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new HomePageClass().setVisible(true);
			}
			
		});
		
		submitBtn.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {							
//						Operations op = new Operations(new Activities());
//				try {
//					
//				}catch(SQLException se) {
//					
//				}
					
				
				try(Connection conn = DriverManager.getConnection(connectingString)) {
					if(maleRB.isSelected()) {
						gender="M";
					} else if(femaleRB.isSelected()) {
						gender="F";
					}		
					if(paidRbtn1.isSelected() || paidRbtn2.isSelected()) {
						payVerify="Paid";
					} else if(notPaidRbtn2.isSelected() || notPaidRbtn2.isSelected()) {
						payVerify="Not paid";
					}
					checkField();
					addUser();	
					reservationConfirmation();
					paymentConfirmationData();
					updateAvaiablility();
					reservedRoomsId.clear();
					if(!reservedSingleRoomNumbers.isEmpty()) { 
						String updateSingleRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateSingleRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedSingleRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					if(!reservedDoubleRoomNumbers.isEmpty()) { 
						String updateDoubleRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateDoubleRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedDoubleRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					if(!reservedSuiteRoomNumbers.isEmpty()) { 
						String updateSuiteRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateSuiteRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedSuiteRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					if(!reservedTripleRoomNumbers.isEmpty()) { 
						String updateTripleRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateTripleRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedTripleRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					if(!reservedDeluxeRoomNumbers.isEmpty()) { 
						String updateDeluxeRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateDeluxeRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedDeluxeRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					if(!reservedConnectingRoomNumbers.isEmpty()) { 
						String updateConnectingRoom = "UPDATE Rom SET rom_status=? WHERE rom_num = ?";
						try(PreparedStatement pstmtUpdate = conn.prepareStatement(updateConnectingRoom)) {
							pstmtUpdate.setString(1, "Not Available");
							
							for(int roomNum : reservedConnectingRoomNumbers) {
								pstmtUpdate.setInt(2, roomNum);
								pstmtUpdate.executeUpdate();
							}
						
						}
					}
					ReceiptClass rc = new ReceiptClass(new CheckInClass());		
					rc.receiptData();
					rc.setVisible(true);			
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(CheckInClass.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			}
		});   
		
		
		
		ListenerClass lc = new ListenerClass();
//		singleRoomSearch.addActionListener(lc);
//		doubleRoomSearch.addActionListener(lc);
//		suiteRoomSearch.addActionListener(lc);
//		tripleRoomSearch.addActionListener(lc);
//		deluxeRoomSearch.addActionListener(lc);
//		connectingRoomSearch.addActionListener(lc);
		searchBtn.addActionListener(lc);
		

		
		
		
		
//		setTitle("Activities");
//		setSize(1200, 650);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
		add(hotelNamePanel, BorderLayout.NORTH);
		add(activitiesPanel, BorderLayout.WEST);
		add(checkInSelectedPanel, BorderLayout.CENTER);
		add(resDetailAndPaymentPanel, BorderLayout.EAST);
		add(submitAndClearPanel, BorderLayout.SOUTH);
		
		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstNameField.setText("");
				middleNameField.setText("");
				lastNameField.setText("");
				phoneNumField.setText("");
				emailField.setText("");				
				addressField.setText("");
				
				singleRoomAmount.setValue(0);
				doubleRoomAmount.setValue(0);
				tripleRoomAmount.setValue(0);
				suiteRoomAmount.setValue(0);
				deluxeRoomAmount.setValue(0);
				connectingRoomAmount.setValue(0);
				
				totalAmount=0.0;
				
				
				singleRoomSearchResult.setText("");
				doubleRoomSearchResult.setText("");
				tripleRoomSearchResult.setText("");
				suiteRoomSearchResult.setText("");
				deluxeRoomSearchResult.setText("");
				connectingRoomSearchResult.setText("");
				singleRoomCH.setSelected(false);
				doubleRoomCH.setSelected(false);
				tripleRoomCH.setSelected(false);
				suiteRoomCH.setSelected(false);
				deluxeRoomCH.setSelected(false);
				connectingRoomCH.setSelected(false);
				totalCardPaymentAmountField.setText("");
				amountField.setText("");
				cardHolderField.setText("");
				cardNumberField.setText("");
				cashPayerField.setText("");
			}
			
		});
		
		reserveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentPanel != null) {
					new Customer();
					getContentPane().remove(currentPanel);
				}
				
				currentPanel = checkInSelectedPanel;
				
				add(currentPanel, BorderLayout.CENTER);
				add(resDetailAndPaymentPanel, BorderLayout.EAST);
				add(submitAndClearPanel, BorderLayout.SOUTH);
				
				revalidate();
				repaint();
			}
			
		});	
		
		roomsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentPanel != null) {
					getContentPane().remove(currentPanel);
				}
				getContentPane().remove(checkInSelectedPanel);
				getContentPane().remove(resDetailAndPaymentPanel);
				getContentPane().remove(submitAndClearPanel);
				Rooms r = new Rooms();
				currentPanel = r.roomPanel;
				
				
				
				add(currentPanel);
				
				revalidate();
				repaint();
			}
			
		});
		
		postponeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentPanel != null) {
					getContentPane().remove(currentPanel);
				}
				getContentPane().remove(checkInSelectedPanel);
				getContentPane().remove(resDetailAndPaymentPanel);
				getContentPane().remove(submitAndClearPanel);
				PostponeClass p = new PostponeClass();
				currentPanel = p.postponePanel;
				
				
				
				add(currentPanel);
				
				revalidate();
				repaint();
			}
			
		});
						
		
		guestsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(currentPanel != null) {
					getContentPane().remove(currentPanel);
				}
				getContentPane().remove(checkInSelectedPanel);
				getContentPane().remove(resDetailAndPaymentPanel);
				getContentPane().remove(submitAndClearPanel);
				
				Customer coc = new Customer();
				currentPanel = coc.guestTablePanel;
				
				
				add(currentPanel, BorderLayout.CENTER);
				
				revalidate();
				repaint();
			}
			
		});
		
	}
	
	JLabel warningLabel;
	public int cusID;
	public int resID;
	public static String fname;
	public static String lname;
	public static int singleAmount, doubleAmount, tripleAmount, suiteAmount, deluxeAmount, connectingAmount;
	public static String singleType, doubleType, tripleType, suiteType, deluxeType, connectingType;
	public static double total;
	public static Date cinDate, coutDate;
	
	
	private void checkField() throws SQLException {
		String fName = firstNameField.getText();
		fname = fName;
	    String lName = middleNameField.getText();
	    lname = lName;
	    String gfName = lastNameField.getText();
	    String phone = phoneNumField.getText();
	    String address = addressField.getText();
	    String email = emailField.getText();
	    String nationality = nationalityField.getText();
	    
	    int singleRoomCount = (Integer) singleRoomAmount.getValue();
	    singleAmount = singleRoomCount;	    
		int doubleRoomCount = (Integer) doubleRoomAmount.getValue();
		doubleAmount = doubleRoomCount;
		int suiteRoomCount = (Integer) suiteRoomAmount.getValue();
		suiteAmount = suiteRoomCount;
		int deluxeRoomCount = (Integer) deluxeRoomAmount.getValue();
		deluxeAmount = suiteRoomCount;
		int tripleRoomCount = (Integer) tripleRoomAmount.getValue();
		tripleAmount = tripleRoomCount;
		int connectingRoomCount = (Integer) connectingRoomAmount.getValue();	
		connectingAmount = connectingRoomCount;
		if((fName.isEmpty() || lName.isEmpty() || gfName.isEmpty() || phone.isEmpty() || address.isEmpty() || email.isEmpty() || nationality.isEmpty()) || 
				singleRoomCount == 0 && doubleRoomCount == 0 && suiteRoomCount == 0 && deluxeRoomCount == 0 && tripleRoomCount==0 && connectingRoomCount == 0) {
			throw new SQLException("error");
		}
		
	}
	
	
	private void reservationConfirmation() throws SQLException {
		
		java.util.Date chInDate = (java.util.Date) dateSpinner.getValue();
		cinDate = (Date) dateSpinner.getValue();
		java.sql.Date sqlChInDate = new java.sql.Date(chInDate.getTime());
		java.util.Date chOutDate = (java.util.Date) dateSpinner2.getValue();
		coutDate = (Date) dateSpinner2.getValue();
		java.sql.Date sqlChOutDate = new java.sql.Date(chOutDate.getTime());
		String recepValue="";
		if(SignIn.receptionId != null) {
			recepValue = SignIn.receptionId;
		}
		if(signUp.receptionId != null) {
			recepValue = signUp.receptionId;
		}
		int recepId = Integer.parseInt(recepValue);
		
		
		try(Connection conn = DriverManager.getConnection(connectingString)){
			for(int i : reservedRoomsId) {
				String cusChoiceSql = "INSERT INTO CustomerChoices(cust_id, rom_id) VALUES (?, ?)";
				String reserData = "INSERT INTO Reservation(cust_id, rom_id, rc_id, cin_date, cout_date, rs_status) VALUES (?, ?, ?, ?, ?, ?)";
				try(PreparedStatement pstmtCusChoice = conn.prepareStatement(cusChoiceSql);
						PreparedStatement pstmtResData = conn.prepareStatement(reserData, Statement.RETURN_GENERATED_KEYS)){
					
					pstmtCusChoice.setInt(1, cusID);
					pstmtCusChoice.setInt(2, i);					
					pstmtCusChoice.executeUpdate();
					
					pstmtResData.setInt(1, cusID);
					pstmtResData.setInt(2, i);
					pstmtResData.setInt(3, recepId);
					pstmtResData.setDate(4, sqlChInDate);
					pstmtResData.setDate(5, sqlChOutDate);
					pstmtResData.setString(6, "Reserved");
					pstmtResData.executeUpdate();
					
					try(ResultSet resIdGenerated = pstmtResData.getGeneratedKeys()){
						if(resIdGenerated.next()) {
							int rsID = resIdGenerated.getInt(1);
							resID = rsID;
						}
					}
										
				}				
			}
			System.out.println("reservation confirmed");
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	private void paymentConfirmationData() throws SQLException {			
		String recepV="";
		if(SignIn.receptionId != null) {
			recepV = SignIn.receptionId;
		}
		if(signUp.receptionId != null) {
			recepV = signUp.receptionId;
		}
		int RecepId = Integer.parseInt(recepV);
		
		
		int selectedTab = paymentTab.getSelectedIndex();
		String selectedName = paymentTab.getTitleAt(selectedTab);
		String paymentSql = "INSERT INTO PaymentRes(rs_id, cust_id, rom_id, rc_id, py_method, py_status, py_totalAmount) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(connectingString)){			
			for(int i : reservedRoomsId) {
				try(PreparedStatement pstmtPayment = conn.prepareStatement(paymentSql)){
					if(selectedName.equals("Card Payment")) {
						pstmtPayment.setInt(1, resID);
						System.out.println(resID);
						pstmtPayment.setInt(2, cusID);
						System.out.println(cusID);
						pstmtPayment.setInt(3, i);
						System.out.println(i);
						pstmtPayment.setInt(4, RecepId);
						System.out.println(RecepId);
						pstmtPayment.setString(5, "Card");
						System.out.println("Card");
						pstmtPayment.setString(6, payVerify);
						System.out.println(payVerify);
						pstmtPayment.setDouble(7, totalAmount);
						System.out.println("Total: "+totalAmount);
					} else if(selectedName.equals("Cash Payment")) {
						pstmtPayment.setInt(1, resID);
						System.out.println(resID);
						pstmtPayment.setInt(2, cusID);
						System.out.println(cusID);
						pstmtPayment.setInt(3, i);
						System.out.println(i);
						pstmtPayment.setInt(4, RecepId);
						System.out.println(RecepId);
						pstmtPayment.setString(5, "Cash");
						System.out.println("Cash");
						pstmtPayment.setString(6, payVerify);
						System.out.println(payVerify);
						pstmtPayment.setDouble(7, totalAmount);
						System.out.println("Total: "+totalAmount);
					}
					pstmtPayment.executeUpdate();
				}
				
			}
			System.out.println("Payment confirmed");
		} catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		
	}
	
	private void updateAvaiablility() throws SQLException {
		String updateSql = "UPDATE Reservation SET rs_status=? WHERE DATEDIFF(DAY, GETDATE(), cout_date) <= 0";
		String updateRoom = "UPDATE Rom SET rom_status=? WHERE rom_id IN (SELECT rom_id FROM Reservation WHERE rs_status=?)";
		try(Connection conn = DriverManager.getConnection(connectingString)){
			
			PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql);
            pstmtUpdate.setString(1, "Completed");
            pstmtUpdate.executeUpdate();
            
            PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoom);
            pstmtUpdateRoom.setString(1, "Available");
            pstmtUpdateRoom.setString(2, "Completed");
            pstmtUpdateRoom.executeUpdate();
                
            System.out.println("Update availability confirmed");		
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	private void addUser() throws SQLException {
	    String fName = firstNameField.getText();
	    String lName = middleNameField.getText();
	    String gfName = lastNameField.getText();
	    String phone = phoneNumField.getText();
	    String address = addressField.getText();
	    String email = emailField.getText();
	    String nationality = nationalityField.getText();
	    java.util.Date date = (java.util.Date) dateSpinnerDoB.getValue();
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//	    String gender = getGender(); // Ensure this method is implemented and returns valid data
//	    ReceiptPage rp = new ReceiptPage();
//        rp.nameLabel.setText("Name: "+ fName+" "+lName+" "+gfName);
//        rp.phoneLabel.setText("Phone Num: "+phone);
//        rp.nationalityLabel.setText("Nationaliry: "+nationality);
	    

	    String sql = "INSERT INTO Custo(cust_Fname, cust_Lname, cust_Gname, cust_email, cust_DOB, cust_gender, "
	    		+ "cust_address, cust_Nationality) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DriverManager.getConnection(connectingString);
	         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        
	        pstmt.setString(1, fName);
	        pstmt.setString(2, lName);
	        pstmt.setString(3, gfName);
	        pstmt.setString(4, email);    
	        pstmt.setDate(5, sqlDate);
	        pstmt.setString(6, gender);
	        pstmt.setString(7, address);
	        pstmt.setString(8, nationality);  
	        
	        
	        
	        // Execute the insert
	        int affectedRows = pstmt.executeUpdate(); // Execute the statement

	        // Check if the insert was successful
	        if (affectedRows == 0) {
	            throw new SQLException("Inserting user failed, no rows affected.");
	        }

	        // Retrieve the generated customer ID
	        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                int custId = generatedKeys.getInt(1); 
	                cusID = custId;
	            	 

	                // Now insert into the CustomerPhoneNum table
	                String custPhone = "INSERT INTO CustomerPhoneNum(cust_id, cust_phone) VALUES(?, ?)";	                
	                try (PreparedStatement pstmtPhone = conn.prepareStatement(custPhone)) {
	                    pstmtPhone.setLong(1, cusID); // Use the retrieved cust_id
	                    pstmtPhone.setString(2, phone);
	                    pstmtPhone.executeUpdate();
	                }
	                
	                
	            } else {
	                System.out.println("Failed to retrieve customer ID.");
	            }
	        }
	        	     	        
	        System.out.println("Affected rows: "+affectedRows);
	        System.out.println("Customer added successfully");
	    } catch (SQLException se) {
//	        System.out.println("Error: " + se.getMessage());
//	        se.printStackTrace();   
	    	JOptionPane.showMessageDialog(CheckInClass.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	ArrayList<Integer> reservedSingleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedDoubleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedSuiteRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedTripleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedConnectingRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedDeluxeRoomNumbers = new ArrayList<>();
	
	ArrayList<Integer> reservedRoomsId = new ArrayList<>();
	
	
	private void makeReservation() throws SQLException {
		
		reservedSingleRoomNumbers.clear();
		reservedDoubleRoomNumbers.clear();
		reservedSuiteRoomNumbers.clear();
		reservedTripleRoomNumbers.clear();
		reservedConnectingRoomNumbers.clear();
		reservedDeluxeRoomNumbers.clear();
		
		
		int singleRoomCount = (Integer) singleRoomAmount.getValue();
		int doubleRoomCount = (Integer) doubleRoomAmount.getValue();
		int suiteRoomCount = (Integer) suiteRoomAmount.getValue();
		int deluxeRoomCount = (Integer) deluxeRoomAmount.getValue();
		int tripleRoomCount = (Integer) tripleRoomAmount.getValue();
		int connectingRoomCount = (Integer) connectingRoomAmount.getValue();			
		
		java.util.Date chInDate = (java.util.Date)dateSpinner.getValue();
		java.util.Date chOutDate = (java.util.Date)dateSpinner2.getValue();
		
		long differenceInMillis = chOutDate.getTime() - chInDate.getTime();
		
		differenceInDays = (int)differenceInMillis / (1000 * 60 * 60 * 24);
		differenceInDays += 1;
		
		System.out.println("Duration: "+differenceInDays);
		
		
		try (Connection conn = DriverManager.getConnection(connectingString)){					
			if(singleRoomCH.isSelected()) {
				if(singleRoomCount > 0) {
					singleType = "Single";
//					String singleRoomSql = "SELECT TOP " + singleRoomCount + " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Single'";
////					String cusChoiceSql = "INSERT INTO CustomerChoice(cus_id, rom_id) VALUES (?, ?)";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(singleRoomSql)){//						
//						ArrayList<String> singleRooms = new ArrayList<>();
						roomTypeActivity(conn, singleRoomCount, "Single", reservedSingleRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedSingleRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						singleRoomSearchResult.setText(rooms);
//					}
				}
			} 
			if(doubleRoomCH.isSelected()) {
				if(doubleRoomCount > 0) {
					doubleType = "Double";
//					String doubleRoomSql = "SELECT TOP " +doubleRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Double'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(doubleRoomSql)){//						
//						ArrayList<String> doubleRooms = new ArrayList<>();
						roomTypeActivity(conn, doubleRoomCount, "Double", reservedDoubleRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedDoubleRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						doubleRoomSearchResult.setText(rooms);
						
//					}
				}				
				
			} 
			if(suiteRoomCH.isSelected()) {
				if(suiteRoomCount > 0) {
					suiteType = "Suite";
//					String suiteRoomSql = "SELECT TOP " +suiteRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Suite'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(suiteRoomSql)){				
//						ArrayList<String> suiteRooms = new ArrayList<>();
						roomTypeActivity(conn, suiteRoomCount, "Suite", reservedSuiteRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedSuiteRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						suiteRoomSearchResult.setText(rooms);
//					}
				}
			}
			if(tripleRoomCH.isSelected()) {
				if(tripleRoomCount > 0) {
					tripleType = "Triple";
//					String tripleRoomSql = "SELECT TOP " +tripleRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Triple'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(tripleRoomSql)){					
//						ArrayList<String> tripleRooms = new ArrayList<>();
						roomTypeActivity(conn, tripleRoomCount, "Triple", reservedTripleRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedTripleRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						tripleRoomSearchResult.setText(rooms);
//					}
				}
			} 
			if(deluxeRoomCH.isSelected()) {
				if(deluxeRoomCount > 0) {
					deluxeType = "Deluxe";
//					String deluxeRoomSql = "SELECT TOP " +deluxeRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Deluxe'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(deluxeRoomSql)){						
//						ArrayList<String> deluxeRooms = new ArrayList<>();
						roomTypeActivity(conn, deluxeRoomCount, "Deluxe", reservedDeluxeRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedDeluxeRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						deluxeRoomSearchResult.setText(rooms);
//					}
				}
			} 
			if(connectingRoomCH.isSelected()) {
				if(connectingRoomCount > 0) {
					connectingType = "Connecting";
//					String connectingRoomSql = "SELECT TOP " +connectingRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Connecting'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(connectingRoomSql)){							
//						ArrayList<String> connectingRooms = new ArrayList<>();
						roomTypeActivity(conn, connectingRoomCount, "Connecting", reservedConnectingRoomNumbers, reservedRoomsId);
						String rooms="";
						for(int i: reservedConnectingRoomNumbers) {
							rooms += i+", ";
							System.out.println(i);
						}
						connectingRoomSearchResult.setText(rooms);
//					}
				}
			} 
			if(!connectingRoomCH.isSelected() && !deluxeRoomCH.isSelected() && !suiteRoomCH.isSelected() && !singleRoomCH.isSelected() && !doubleRoomCH.isSelected() && !tripleRoomCH.isSelected()){
//				warningLabel = new JLabel();
//				warningLabel.setText("You should select the room type");
//				checkInSelectedPanel.add(warningLabel);
				JOptionPane.showMessageDialog(CheckInClass.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			
			total = totalAmount;
			
						
		} catch(SQLException se) {
			JOptionPane.showMessageDialog(CheckInClass.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
//			se.printStackTrace();
		}
	}
	
	
	
	void roomTypeActivity(Connection conn, int roomCount, String roomType, ArrayList<Integer> roomNums, ArrayList<Integer> listId) throws SQLException {
		
		String roomTypeSql = "SELECT TOP "+ roomCount + " * From VRoom WHERE rom_status='Available' AND ro_typeName=?";
		try(PreparedStatement  pstmtReserv = conn.prepareStatement(roomTypeSql)){
			pstmtReserv.setString(1, roomType);
			try(ResultSet rooms = pstmtReserv.executeQuery()){
				while(rooms.next()) {
					int room_num= rooms.getInt("rom_num");
					int roomId = rooms.getInt("rom_id");
					totalAmount += rooms.getDouble("ro_price_per_day") * differenceInDays;
//										
					listId.add(roomId);
					roomNums.add(room_num);					
					
				}
			}
		}
	}
	

	class ListenerClass implements ActionListener {
	
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				makeReservation();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
		new CheckInClass().setVisible(true);
		
	}

	
}

	
