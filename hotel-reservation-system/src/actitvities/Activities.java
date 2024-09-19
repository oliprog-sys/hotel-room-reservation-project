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
public class Activities extends JFrame {
	Activities act;
	String gender;
	Double totalAmount=0.0;
	JPanel hotelNamePanel, activitiesPanel, checkInSelectedPanel, firstNamePanel,middleNamePanel, lastNamePanel,phoneNumPanel, 
	addressPanel,emailPanel, DOBPanel, genderPanel, resDetailAndPaymentPanel, reserveDetailPanel, checkInLabelAndDatePanel, 
	checkOutLabelAndDatePanel,singleRoomCHAndRA, doubleRoomCHAndRA, suiteRoomCHAndRA, tripleRoomCHAndRA, connectingRoomCHAndRA,
	deluxeRoomCHAndRA, paymentPanel, cardPaymentPanel, cashPaymentPanel, cardHolderPanel, cardNumberPanel, cardExpireDatePanel, 
	totalCardPaymentAmountPanel, cashPayerPanel, amountPanel, submitAndClearPanel, nationalityPanel;
	JLabel hotelNameLabel, firstNameLabel, middleNameLabel, lastNameLabel, phoneNumLabel, addressLabel, emailLabel, DoBLabel,
	checkOutDateLabel, singleRoomNumOfBeds, doubleRoomNumOfBeds, suiteRoomNumOfBeds, tripleRoomNumOfBeds, connectingRoomNumOfBeds,
	deluxeRoomNumOfBeds, cardHolderLabel, cardNumberLabel, cardExpireDateLabel, totalCardPaymentAmountLabel,
	cashPayerLabel, totalAmountLabel, nationalityLabel;
	public JTextField firstNameField,middleNameField, lastNameField, phoneNumField, addressField, emailField, cardHolderField,
	cardNumberField, cardExpireDateField, totalCardPaymentAmountField, cashPayerField, amountField, nationalityField
	,singleRoomSearchResult, doubleRoomSearchResult, tripleRoomSearchResult, deluxeRoomSearchResult,
	connectingRoomSearchResult, suiteRoomSearchResult;
	JButton checkInBtn, checkOutBtn, roomsBtn, cancelReservBtn, guestsBtn, paymentsBtn, submitBtn, clearBtn,
	singleRoomSearch, doubleRoomSearch, suiteRoomSearch, tripleRoomSearch, connectingRoomSearch, deluxeRoomSearch;
	JRadioButton maleRB, femaleRB;
	JSpinner dateSpinner2,dateSpinner,dateSpinnerDoB , singleRoomAmount, doubleRoomAmount, suiteRoomAmount, tripleRoomAmount, connectingRoomAmount,
	deluxeRoomAmount, singleRoomNumOfBedAmount, doubleRoomNumOfBedAmount, suiteRoomNumOfBedAmount, tripleRoomNumOfBedAmount, 
	connectingRoomNumOfBedAmount, deluxeRoomNumOfBedAmount;
	JCheckBox singleRoomCH, doubleRoomCH, suiteRoomCH, tripleRoomCH, connectingRoomCH, deluxeRoomCH;
	JTabbedPane paymentTab;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	
	public Activities() {
		
		
		
//		try {
//			try(Connection conn = DriverManager.getConnection(connectingString)) {
//				System.out.println("Connection Estabilished");
//			}
//		} catch(SQLException e) {
//			System.out.println("Error connection to the database");
//			e.printStackTrace();
//		}
		
		// hotel name panel
		hotelNamePanel = new JPanel();
		hotelNamePanel.setLayout(new BoxLayout(hotelNamePanel, BoxLayout.Y_AXIS));
		
		hotelNameLabel = new JLabel("PLATINUM HOTEL");
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
		activitiesPanel = new JPanel(new GridLayout(6, 1, 2, 2));		
		
		checkInBtn = new JButton("Check In");
		checkOutBtn = new JButton("Check Out");
		roomsBtn = new JButton("Rooms");
		cancelReservBtn = new JButton("Cancel reservation");
		guestsBtn = new JButton("Guests");
		paymentsBtn = new JButton("Payments");
		
		activitiesPanel.add(checkInBtn);
		activitiesPanel.add(checkOutBtn);
		activitiesPanel.add(cancelReservBtn);
		activitiesPanel.add(roomsBtn);
		activitiesPanel.add(guestsBtn);
		activitiesPanel.add(paymentsBtn);
		
		// Check In clicked panel
		checkInSelectedPanel = new JPanel();
		checkInSelectedPanel.setLayout(new BoxLayout(checkInSelectedPanel, BoxLayout.Y_AXIS));
		checkInSelectedPanel.setBorder(new EmptyBorder(35, 20, 0, 0));
		
		// first name panel
		firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		firstNameField = new JTextField(30);
		firstNameField.setPreferredSize(new Dimension(20, 26));
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		//last name panel
		middleNamePanel = new JPanel();
		middleNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		middleNameField = new JTextField(30);
		middleNameField.setPreferredSize(new Dimension(20, 26));
		
		middleNamePanel.add(middleNameLabel);
		middleNamePanel.add(middleNameField);
		
		//grand father name panel
		lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		lastNameField = new JTextField(30);
		lastNameField.setPreferredSize(new Dimension(20, 26));
		
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// Phone panel
		phoneNumPanel = new JPanel();
		phoneNumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		phoneNumLabel = new JLabel("Phone Num");
		phoneNumLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		phoneNumField = new JTextField(30);
		phoneNumField.setPreferredSize(new Dimension(20, 26));
		
		phoneNumPanel.add(phoneNumLabel);
		phoneNumPanel.add(phoneNumField);
		
		
		// address panel
		addressPanel = new JPanel();
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		addressField = new JTextField(30);
		addressField.setPreferredSize(new Dimension(20, 26));
		
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		
		// email panel
		emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		emailField = new JTextField(30);
		emailField.setPreferredSize(new Dimension(20, 26));
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		
		
		// email panel
		nationalityPanel = new JPanel();
		nationalityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		nationalityLabel = new JLabel("Nationality");
		nationalityLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		nationalityField = new JTextField("Ethiopia" ,30);
		nationalityField.setPreferredSize(new Dimension(20, 26));
		
		nationalityPanel.add(nationalityLabel);
		nationalityPanel.add(nationalityField);

		
		//DoB label and date panel
		DOBPanel = new JPanel();
		DOBPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		DoBLabel = new JLabel("Date of Birth:");
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
		
		maleRB = new JRadioButton("Male");
		maleRB.setFont(new Font("Roboto", Font.PLAIN, 17));
		femaleRB = new JRadioButton("Female");
		femaleRB.setFont(new Font("Sans", Font.PLAIN, 17));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		genderPanel.add(maleRB);
		genderPanel.add(femaleRB);

		
		checkInSelectedPanel.add(firstNamePanel);
		checkInSelectedPanel.add(middleNamePanel);
		checkInSelectedPanel.add(lastNamePanel);
		checkInSelectedPanel.add(phoneNumPanel);
		checkInSelectedPanel.add(addressPanel);
		checkInSelectedPanel.add(emailPanel);
		checkInSelectedPanel.add(nationalityPanel);
		checkInSelectedPanel.add(DOBPanel);
		checkInSelectedPanel.add(genderPanel);
		
		
		// reservation Details and payments panel
		resDetailAndPaymentPanel = new JPanel();
		resDetailAndPaymentPanel.setLayout(new BoxLayout(resDetailAndPaymentPanel, BoxLayout.Y_AXIS));
		
		// reservation detail panel
		reserveDetailPanel = new JPanel();
		reserveDetailPanel.setLayout(new BoxLayout(reserveDetailPanel, BoxLayout.Y_AXIS));
		
		// check in label and date panel
		checkInLabelAndDatePanel = new JPanel();
		
		JLabel checkInDateLabel = new JLabel("Check In:");
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
		
		checkOutDateLabel = new JLabel("Check Out:");
		checkOutDateLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		Calendar calendar2 = Calendar.getInstance();
		dateSpinner2 = new JSpinner(new SpinnerDateModel(calendar2.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinner2.setPreferredSize(new Dimension(110, 35));
		dateSpinner2.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(dateSpinner2, "dd-MM-yyyy");
		dateSpinner2.setEditor(dateEditor2);
		
		checkOutLabelAndDatePanel.add(checkOutDateLabel);
		checkOutLabelAndDatePanel.add(dateSpinner2);
		
		JPanel ciAndcoPanel = new JPanel();
		ciAndcoPanel.setLayout(new BoxLayout(ciAndcoPanel, BoxLayout.Y_AXIS));
		
		
		ciAndcoPanel.add(checkInLabelAndDatePanel);
		ciAndcoPanel.add(checkOutLabelAndDatePanel);
		
		
		// Reservation Detail panel for the JTabbedPane
		JPanel reservationPanePanel = new JPanel();
		
		// reservation tabbed pane
		JTabbedPane reservationPane = new JTabbedPane();
		
		
		// single room check box and number of rooms
		singleRoomCHAndRA = new JPanel();
		
		singleRoomCH = new JCheckBox("Single Room");
		singleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		singleRoomSearch = new JButton("Search");
		singleRoomSearchResult = new JTextField(15); 
//		singleRoomNumOfBeds = new JLabel("Number of Beds ");
//		singleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		singleRoomCHAndRA.add(singleRoomCH);
		singleRoomCHAndRA.add(singleRoomAmount);
		singleRoomCHAndRA.add(singleRoomSearch);
		singleRoomCHAndRA.add(singleRoomSearchResult);
//		singleRoomCHAndRA.add(singleRoomNumOfBeds);
//		singleRoomCHAndRA.add(singleRoomNumOfBedAmount);
		
		
		// Double room check box and number of rooms
		doubleRoomCHAndRA = new JPanel();
		
		doubleRoomCH = new JCheckBox("Double Room");
		doubleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		doubleRoomSearch = new JButton("Search");
		doubleRoomSearchResult = new JTextField(15);
//		doubleRoomNumOfBeds = new JLabel("Number of Beds ");
//		doubleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		doubleRoomCHAndRA.add(doubleRoomCH);
		doubleRoomCHAndRA.add(doubleRoomAmount);
		doubleRoomCHAndRA.add(doubleRoomSearch);
		doubleRoomCHAndRA.add(doubleRoomSearchResult);
//		doubleRoomCHAndRA.add(doubleRoomNumOfBeds);
//		doubleRoomCHAndRA.add(doubleRoomNumOfBedAmount);
		
		// Suite room check box and number of rooms
		suiteRoomCHAndRA = new JPanel();
		
		suiteRoomCH = new JCheckBox("Suite Room");
		suiteRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		suiteRoomSearch = new JButton("Search");
		suiteRoomSearchResult = new JTextField(15);
//		suiteRoomNumOfBeds = new JLabel("Number of Beds ");
//		suiteRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		suiteRoomCHAndRA.add(suiteRoomCH);
		suiteRoomCHAndRA.add(suiteRoomAmount);
		suiteRoomCHAndRA.add(suiteRoomSearch);
		suiteRoomCHAndRA.add(suiteRoomSearchResult);
//		suiteRoomCHAndRA.add(suiteRoomNumOfBeds);
//		suiteRoomCHAndRA.add(suiteRoomNumOfBedAmount);
		
		
		// triple room check box and number of rooms
		tripleRoomCHAndRA = new JPanel();
		
		tripleRoomCH = new JCheckBox("Triple Room");
		tripleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		tripleRoomSearch = new JButton("Search");
		tripleRoomSearchResult = new JTextField(15);
//		tripleRoomNumOfBeds = new JLabel("Number of Beds ");
//		tripleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		tripleRoomCHAndRA.add(tripleRoomCH);
		tripleRoomCHAndRA.add(tripleRoomAmount);
		tripleRoomCHAndRA.add(tripleRoomSearch);
		tripleRoomCHAndRA.add(tripleRoomSearchResult);
//		tripleRoomCHAndRA.add(tripleRoomNumOfBeds);
//		tripleRoomCHAndRA.add(tripleRoomNumOfBedAmount);
		
		// deluxe room check box and number of rooms
		deluxeRoomCHAndRA = new JPanel();
		
		deluxeRoomCH = new JCheckBox("Deluxe Room");
		deluxeRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		deluxeRoomSearch = new JButton("Search");
		deluxeRoomSearchResult = new JTextField(15);
//		deluxeRoomNumOfBeds = new JLabel("Number of Beds ");
//		deluxeRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		deluxeRoomCHAndRA.add(deluxeRoomCH);
		deluxeRoomCHAndRA.add(deluxeRoomAmount);
		deluxeRoomCHAndRA.add(deluxeRoomSearch);
		deluxeRoomCHAndRA.add(deluxeRoomSearchResult);
//		deluxeRoomCHAndRA.add(deluxeRoomNumOfBeds);
//		deluxeRoomCHAndRA.add(deluxeRoomNumOfBedAmount);
		
		
		// deluxe room check box and number of rooms
		connectingRoomCHAndRA = new JPanel();
		
		connectingRoomCH = new JCheckBox("Connecting Room");
		connectingRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		connectingRoomSearch = new JButton("Search");
		connectingRoomSearchResult = new JTextField(15);
//		connectingRoomNumOfBeds = new JLabel("Number of Beds ");
//		connectingRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		connectingRoomCHAndRA.add(connectingRoomCH);
		connectingRoomCHAndRA.add(connectingRoomAmount);
		connectingRoomCHAndRA.add(connectingRoomSearch);
		connectingRoomCHAndRA.add(connectingRoomSearchResult);
//		connectingRoomCHAndRA.add(connectingRoomNumOfBeds);
//		connectingRoomCHAndRA.add(connectingRoomNumOfBedAmount);

		
		reserveDetailPanel.add(singleRoomCHAndRA);
		reserveDetailPanel.add(doubleRoomCHAndRA);
		reserveDetailPanel.add(suiteRoomCHAndRA);
		reserveDetailPanel.add(tripleRoomCHAndRA);
		reserveDetailPanel.add(deluxeRoomCHAndRA);
		reserveDetailPanel.add(connectingRoomCHAndRA);
//		reserveDetailPanel.add(checkInLabelAndDatePanel);
//		reserveDetailPanel.add(checkOutLabelAndDatePanel);
		
		reservationPane.addTab("Rooms", reserveDetailPanel);
		
		reservationPanePanel.add(reservationPane);
	
		// payment panel
		paymentPanel = new JPanel();
		
		// payment area tabbed pane
		paymentTab = new JTabbedPane();
		
		// Card payment panel
		cardPaymentPanel = new JPanel();
		cardPaymentPanel.setLayout(new BoxLayout(cardPaymentPanel, BoxLayout.Y_AXIS));
		
		// card holder name and field panel
		cardHolderPanel = new JPanel();
		
		cardHolderLabel = new JLabel("Card Holder Name");
		cardHolderField = new JTextField(10);
		
		cardHolderPanel.add(cardHolderLabel);
		cardHolderPanel.add(cardHolderField);
		
		// card number and field panel
		cardNumberPanel = new JPanel();
		
		cardNumberLabel = new JLabel("Card Number");
		cardNumberField = new JTextField(10);
		
		cardNumberPanel.add(cardNumberLabel);
		cardNumberPanel.add(cardNumberField);
		
//		// card expire date panel
//		cardExpireDatePanel = new JPanel();
//		
//		cardExpireDateLabel = new JLabel("Expiration Date");
//		cardExpireDateField  = new JTextField(10);
//		
//		cardExpireDatePanel.add(cardExpireDateLabel);
//		cardExpireDatePanel.add(cardExpireDateField);
		
		// Total payment amount panel
		totalCardPaymentAmountPanel = new JPanel();
		
		totalCardPaymentAmountLabel = new JLabel("Total Amount");
		totalCardPaymentAmountField = new JTextField(10);
		
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountLabel);
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountField);
		
		// payment completed radio button panel
		
		cardPaymentPanel.add(cardHolderPanel);
		cardPaymentPanel.add(cardNumberPanel);
//		cardPaymentPanel.add(cardExpireDatePanel);
		cardPaymentPanel.add(totalCardPaymentAmountPanel);
		
		// Add to the specific payment panel to the payment tab		
		paymentTab.addTab("Card Payment", cardPaymentPanel);
		
		
		// Cash payment panel
		cashPaymentPanel = new JPanel();
		cashPaymentPanel.setLayout(new BoxLayout(cashPaymentPanel, BoxLayout.Y_AXIS));
		
		// payer name panel
		cashPayerPanel = new JPanel();
		
		cashPayerLabel = new JLabel("Payer Name");
		cashPayerField = new JTextField(10);
		
		cashPayerPanel.add(cashPayerLabel);
		cashPayerPanel.add(cashPayerField);
		
		// paid amount panel
		amountPanel = new JPanel();
		
		totalAmountLabel = new JLabel("Amount");
		amountField = new JTextField(10);
		
		amountPanel.add(totalAmountLabel);
		amountPanel.add(amountField);
		
		cashPaymentPanel.add(cashPayerPanel);
		cashPaymentPanel.add(amountPanel);
		
		// add to specific tab
		paymentTab.addTab("Cash Payment", cashPaymentPanel);
		
		
		// Add the specific tab to the whole payment panel
		paymentPanel.add(paymentTab);
		
		
		// SUBMIT AND CLEAR BUTTONS
		submitAndClearPanel = new JPanel();
		
		submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(130, 40));
		clearBtn = new JButton("Clear");
		clearBtn.setPreferredSize(new Dimension(130, 40));
		
		submitAndClearPanel.add(submitBtn);
		submitAndClearPanel.add(clearBtn);
		
		
		
		
		resDetailAndPaymentPanel.add(ciAndcoPanel, BorderLayout.NORTH);
		resDetailAndPaymentPanel.add(reservationPanePanel, BorderLayout.CENTER);
		resDetailAndPaymentPanel.add(paymentPanel, BorderLayout.SOUTH);
		
		submitBtn.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {							
//				Operations op = new Operations(new Activities());
				try(Connection conn = DriverManager.getConnection(connectingString)) {
					if(maleRB.isSelected()) {
						gender="M";
					} else if(femaleRB.isSelected()) {
						gender="F";
					}					
					addUser();
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		ListenerClass lc = new ListenerClass();
		singleRoomSearch.addActionListener(lc);
		doubleRoomSearch.addActionListener(lc);
		suiteRoomSearch.addActionListener(lc);
		tripleRoomSearch.addActionListener(lc);
		deluxeRoomSearch.addActionListener(lc);
		connectingRoomSearch.addActionListener(lc);
		

		
		
		
		
		setTitle("Activities");
		setSize(1200, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(hotelNamePanel, BorderLayout.NORTH);
		add(activitiesPanel, BorderLayout.WEST);
		add(checkInSelectedPanel, BorderLayout.CENTER);
		add(resDetailAndPaymentPanel, BorderLayout.EAST);
		add(submitAndClearPanel, BorderLayout.SOUTH);
//		setVisible(true);
	}
	
	JLabel warningLabel;
	
	
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

	                // Now insert into the CustomerPhoneNum table
	                String custPhone = "INSERT INTO CustomerPhoneNum(cust_id, cust_phone) VALUES(?, ?)";
	                try (PreparedStatement pstmtPhone = conn.prepareStatement(custPhone)) {
	                    pstmtPhone.setLong(1, custId); // Use the retrieved cust_id
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
	        System.out.println("Error: " + se.getMessage());
	        se.printStackTrace();                    
	    }
	}
	
	ArrayList<Integer> reservedSingleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedDoubleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedSuiteRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedTripleRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedConnectingRoomNumbers = new ArrayList<>();
	ArrayList<Integer> reservedDeluxeRoomNumbers = new ArrayList<>();
	
	
	
	private void makeReservation() throws SQLException {
		
		java.util.Date chInDate = (java.util.Date) dateSpinner.getValue();
		java.sql.Date sqlChInDate = new java.sql.Date(chInDate.getTime());
		java.util.Date chOutDate = (java.util.Date) dateSpinner2.getValue();
		java.sql.Date sqlChOutDate = new java.sql.Date(chOutDate.getTime());
		int singleRoomCount = (Integer) singleRoomAmount.getValue();
		int doubleRoomCount = (Integer) doubleRoomAmount.getValue();
		int suiteRoomCount = (Integer) suiteRoomAmount.getValue();
		int deluxeRoomCount = (Integer) deluxeRoomAmount.getValue();
		int tripleRoomCount = (Integer) tripleRoomAmount.getValue();
		int connectingRoomCount = (Integer) connectingRoomAmount.getValue();			
		
		
		
		try (Connection conn = DriverManager.getConnection(connectingString)){			
			if(singleRoomCH.isSelected()) {
				if(singleRoomCount > 0) {
					String singleRoomSql = "SELECT TOP " + singleRoomCount + " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Single'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(singleRoomSql)){
//						pstmtReserv.setInt(1, singleRoomCount);
						String roomAvailable="";
//						String updateSingleRoom = "UPDATE Rom SET rom_status= ?"
						try (ResultSet sRoom = pstmtReserv.executeQuery()){
							if(sRoom.next()) {
								do {
									int roomNum = sRoom.getInt("rom_num");
									totalAmount += sRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									roomAvailable += roomNum+", ";
									reservedSingleRoomNumbers.add(roomNum);	
								} while(sRoom.next());
								singleRoomSearchResult.setText(roomAvailable);
							} else {
								// show an error message
							}						
//							totalAmount += singleRoomCount * sRoom.getInt("ro_price_per_day");
						}
					}
				}
			} 
			else if(doubleRoomCH.isSelected()) {
				if(doubleRoomCount > 0) {
					String doubleRoomSql = "SELECT TOP " +doubleRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Double'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(doubleRoomSql)){
//						pstmtReserv.setInt(1, doubleRoomCount);
						
						String availableRoom="";
						try (ResultSet dRoom = pstmtReserv.executeQuery()){
							if(dRoom.next()) {
								do {
									int roomNum = dRoom.getInt("rom_num");
									totalAmount += dRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									availableRoom += roomNum+", ";
									reservedDoubleRoomNumbers.add(roomNum);	
								} while(dRoom.next());
								doubleRoomSearchResult.setText(availableRoom);
							} else {
								// show an error message
							}
//							doubleRoomSearchResult.setText(availableRoom);
//							totalAmount += doubleRoomCount * dRoom.getInt("ro_price_per_day");
						}
						
					}
				}				
				
			} else if(suiteRoomCH.isSelected()) {
				if(suiteRoomCount > 0) {
					String suiteRoomSql = "SELECT TOP " +suiteRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Suite'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(suiteRoomSql)){
//						pstmtReserv.setInt(1, doubleRoomCount);
						
						String availableRoom="";
						try (ResultSet suRoom = pstmtReserv.executeQuery()){
							if(suRoom.next()) {
								do {
									int roomNum = suRoom.getInt("rom_num");
									totalAmount += suRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									availableRoom += roomNum+", ";
									reservedSuiteRoomNumbers.add(roomNum);	
								} while(suRoom.next());
								suiteRoomSearchResult.setText(availableRoom);
							} else {
								// show an error message
							}
//							suiteRoomSearchResult.setText(availableRoom);
//							totalAmount += suiteRoomCount * suRoom.getInt("ro_price_per_day");
						}						
					}
				}
			} else if(tripleRoomCH.isSelected()) {
				if(tripleRoomCount > 0) {
					String tripleRoomSql = "SELECT TOP " +tripleRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Triple'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(tripleRoomSql)){
//						pstmtReserv.setInt(1, doubleRoomCount);
						
						String availableRoom="";
						try (ResultSet tRoom = pstmtReserv.executeQuery()){
							if(tRoom.next()) {
								do {
									int roomNum = tRoom.getInt("rom_num");
									totalAmount += tRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									availableRoom += roomNum+", ";
									reservedTripleRoomNumbers.add(roomNum);	
								} while(tRoom.next());
								tripleRoomSearchResult.setText(availableRoom);
							} else {
								// show an error message
							}
//							tripleRoomSearchResult.setText(availableRoom);
//							totalAmount += tripleRoomCount * tRoom.getInt("ro_price_per_day");
						}						
					}
				}
			} else if(deluxeRoomCH.isSelected()) {
				if(deluxeRoomCount > 0) {
					String deluxeRoomSql = "SELECT TOP " +deluxeRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Deluxe'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(deluxeRoomSql)){
//						pstmtReserv.setInt(1, doubleRoomCount);
						
						String availableRoom="";
						try (ResultSet deRoom = pstmtReserv.executeQuery()){
							if(deRoom.next()) {
								do {
									int roomNum = deRoom.getInt("rom_num");
									totalAmount += deRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									availableRoom += roomNum+", ";
									reservedDeluxeRoomNumbers.add(roomNum);	
								} while(deRoom.next());
								deluxeRoomSearchResult.setText(availableRoom);
							} else {
								// show an error message
							}
//							deluxeRoomSearchResult.setText(availableRoom);
//							totalAmount += deluxeRoomCount * deRoom.getInt("ro_price_per_day");
						}						
					}
				}
			} else if(connectingRoomCH.isSelected()) {
				if(connectingRoomCount > 0) {
					String connectingRoomSql = "SELECT TOP " +connectingRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Connecting'";
					try(PreparedStatement pstmtReserv = conn.prepareStatement(connectingRoomSql)){
//						pstmtReserv.setInt(1, doubleRoomCount);
						
						String availableRoom="";
						try (ResultSet cRoom = pstmtReserv.executeQuery()){
							if(cRoom.next()) {
								do {
									int roomNum = cRoom.getInt("rom_num");
									totalAmount += cRoom.getInt("ro_price_per_day");
//									sRooms = new JLabel();
									availableRoom += roomNum+", ";
									reservedConnectingRoomNumbers.add(roomNum);	
								} while(cRoom.next());
								connectingRoomSearchResult.setText(availableRoom);
							} else {
								// show an error message
							}
//							connectingRoomSearchResult.setText(availableRoom);
//							totalAmount += connectingRoomCount * cRoom.getInt("ro_price_per_day");
						}						
					}
				}
			} else {
				warningLabel = new JLabel();
				warningLabel.setText("You should select the room type");
				checkInSelectedPanel.add(warningLabel);
			}
			
		} catch(SQLException se) {
			System.out.println("Error: "+se.getMessage());
			se.printStackTrace();
		}
	}
	
	private void payment() throws SQLException {
		String cardOwnerName = cardHolderField.getText();
		String cardNumber = cardNumberField.getText();
		String totalPrice = totalCardPaymentAmountField.getText();		
		
		String payerName = cashPayerField.getText();
		
		String cashAmount = amountField.getText();
		
		int selectedIndex = paymentTab.getSelectedIndex();
		String selectedTab = paymentTab.getTitleAt(selectedIndex);
		
		try(Connection conn = DriverManager.getConnection(connectingString)){
			if(selectedTab == "Card Payment") {
				
			}
		}
		
		
		
	}
	
	class ListenerClass implements ActionListener {

//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			// TODO Auto-generated method stub
//			if(e.getStateChange() == ItemEvent.SELECTED) {
//				try {
//					makeReservation();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}

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
	
//	private void choosenCheckBox() {
//		
//		
//		
//	}
//	
//	private String getGender() {
//		if(maleRB.isSelected()) {
//			return "M";
//		} else if(femaleRB.isSelected()) {
//			return "F";
//		}
//		return " ";
//	}
	
	public static void main(String[] args) {
		new Activities().setVisible(true);
	}
}
