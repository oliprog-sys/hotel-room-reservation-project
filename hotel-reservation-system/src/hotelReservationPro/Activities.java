package hotelReservationPro;
import java.awt.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Activities extends JFrame {
	JPanel hotelNamePanel, activitiesPanel, checkInSelectedPanel;
	JLabel hotelNameLabel;
	JButton checkInBtn, checkOutBtn, roomsBtn, cancelReservBtn, guestsBtn, paymentsBtn;
	
	public Activities() {
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
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField firstNameField = new JTextField(30);
		firstNameField.setPreferredSize(new Dimension(20, 26));
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		//last name panel
		JPanel middleNamePanel = new JPanel();
		middleNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField middleNameField = new JTextField(30);
		middleNameField.setPreferredSize(new Dimension(20, 26));
		
		middleNamePanel.add(middleNameLabel);
		middleNamePanel.add(middleNameField);
		
		//grand father name panel
		JPanel lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField lastNameField = new JTextField(30);
		lastNameField.setPreferredSize(new Dimension(20, 26));
		
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// Phone panel
		JPanel phoneNumPanel = new JPanel();
		phoneNumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel phoneNumLabel = new JLabel("Phone Num");
		phoneNumLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField phoneNumField = new JTextField(30);
		phoneNumField.setPreferredSize(new Dimension(20, 26));
		
		phoneNumPanel.add(phoneNumLabel);
		phoneNumPanel.add(phoneNumField);
		
		
		// address panel
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField addressFeild = new JTextField(30);
		addressFeild.setPreferredSize(new Dimension(20, 26));
		
		addressPanel.add(addressLabel);
		addressPanel.add(addressFeild);
		
		// email panel
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		JTextField emailField = new JTextField(30);
		emailField.setPreferredSize(new Dimension(20, 26));
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);	
		
		//DoB label and date panel
		JPanel DOBPanel = new JPanel();
		DOBPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel DoBLabel = new JLabel("Date of Birth:");
		DoBLabel.setFont(new Font("ROBOTO", Font.PLAIN, 23));
		Calendar calendarDoB = Calendar.getInstance();
		JSpinner dateSpinnerDoB= new JSpinner(new SpinnerDateModel(calendarDoB.getTime(), null, null, Calendar.DAY_OF_MONTH));
		dateSpinnerDoB.setPreferredSize(new Dimension(110, 35));
		dateSpinnerDoB.setFont(new Font("Sans serif", Font.BOLD, 15));
		JSpinner.DateEditor dateEditorDoB = new JSpinner.DateEditor(dateSpinnerDoB, "dd-MM-yyyy");		
		dateSpinnerDoB.setEditor(dateEditorDoB);
		
		DOBPanel.add(DoBLabel);
		DOBPanel.add(dateSpinnerDoB);
		
		
		// Gender radio button panel
		JPanel genderPanel = new JPanel();
		
		JRadioButton maleRB = new JRadioButton("Male");
		maleRB.setFont(new Font("Roboto", Font.PLAIN, 17));
		JRadioButton femaleRB = new JRadioButton("Female");
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
		checkInSelectedPanel.add(DOBPanel);
		checkInSelectedPanel.add(genderPanel);
		
		// reservation Details and payments panel
		JPanel resDetailAndPaymentPanel = new JPanel();
		resDetailAndPaymentPanel.setLayout(new BoxLayout(resDetailAndPaymentPanel, BoxLayout.Y_AXIS));
		
		// reservation detail panel
		JPanel reserveDetailPanel = new JPanel();
		reserveDetailPanel.setLayout(new BoxLayout(reserveDetailPanel, BoxLayout.Y_AXIS));
		
		// check in label and date panel
		JPanel checkInLabelAndDatePanel = new JPanel();
		
		JLabel checkInDateLabel = new JLabel("Check In:");
		Calendar calendar = Calendar.getInstance();
		JSpinner dateSpinner = new JSpinner(new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
		dateSpinner.setEditor(dateEditor);
		
		checkInLabelAndDatePanel.add(checkInDateLabel);
		checkInLabelAndDatePanel.add(dateSpinner);
		
		// Check out label and date panel
		JPanel checkOutLabelAndDatePanel = new JPanel();
		
		JLabel checkOutDateLabel = new JLabel("Check Out:");
		Calendar calendar2 = Calendar.getInstance();
		JSpinner dateSpinner2 = new JSpinner(new SpinnerDateModel(calendar2.getTime(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(dateSpinner2, "dd-MM-yyyy");
		dateSpinner2.setEditor(dateEditor2);
		
		checkOutLabelAndDatePanel.add(checkOutDateLabel);
		checkOutLabelAndDatePanel.add(dateSpinner2);
		
		
		
		
		// single room check box and number of rooms
		JPanel singleRoomCHAndRA = new JPanel();
		
		JCheckBox singleRoomCH = new JCheckBox("Single Room");
		JSpinner singleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel singleRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner singleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		singleRoomCHAndRA.add(singleRoomCH);
		singleRoomCHAndRA.add(singleRoomAmount);
		singleRoomCHAndRA.add(singleRoomNumOfBeds);
		singleRoomCHAndRA.add(singleRoomNumOfBedAmount);
		
		
		// Double room check box and number of rooms
		JPanel doubleRoomCHAndRA = new JPanel();
		
		JCheckBox doubleRoomCH = new JCheckBox("Double Room");
		JSpinner doubleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel doubleRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner doubleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		
		doubleRoomCHAndRA.add(doubleRoomCH);
		doubleRoomCHAndRA.add(doubleRoomAmount);
		doubleRoomCHAndRA.add(doubleRoomNumOfBeds);
		doubleRoomCHAndRA.add(doubleRoomNumOfBedAmount);
		
		// Suite room check box and number of rooms
		JPanel suiteRoomCHAndRA = new JPanel();
		
		JCheckBox SuiteRoomCH = new JCheckBox("Suite Room");
		JSpinner SuiteRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel suiteRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner suiteRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		suiteRoomCHAndRA.add(SuiteRoomCH);
		suiteRoomCHAndRA.add(SuiteRoomAmount);
		suiteRoomCHAndRA.add(suiteRoomNumOfBeds);
		suiteRoomCHAndRA.add(suiteRoomNumOfBedAmount);
		
		
		// triple room check box and number of rooms
		JPanel tripleRoomCHAndRA = new JPanel();
		
		JCheckBox tripleRoomCH = new JCheckBox("Suite Room");
		JSpinner tripleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel tripleRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner tripleRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		tripleRoomCHAndRA.add(tripleRoomCH);
		tripleRoomCHAndRA.add(tripleRoomAmount);
		tripleRoomCHAndRA.add(tripleRoomNumOfBeds);
		tripleRoomCHAndRA.add(tripleRoomNumOfBedAmount);
		
		// deluxe room check box and number of rooms
		JPanel deluxeRoomCHAndRA = new JPanel();
		
		JCheckBox deluxeRoomCH = new JCheckBox("Suite Room");
		JSpinner deluxeRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel deluxeRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner deluxeRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		deluxeRoomCHAndRA.add(deluxeRoomCH);
		deluxeRoomCHAndRA.add(deluxeRoomAmount);
		deluxeRoomCHAndRA.add(deluxeRoomNumOfBeds);
		deluxeRoomCHAndRA.add(deluxeRoomNumOfBedAmount);
		
		
		// deluxe room check box and number of rooms
		JPanel connectingRoomCHAndRA = new JPanel();
		
		JCheckBox connectingRoomCH = new JCheckBox("Suite Room");
		JSpinner connectingRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		JLabel connectingRoomNumOfBeds = new JLabel("Number of Beds ");
		JSpinner connectingRoomNumOfBedAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		connectingRoomCHAndRA.add(connectingRoomCH);
		connectingRoomCHAndRA.add(connectingRoomAmount);
		connectingRoomCHAndRA.add(connectingRoomNumOfBeds);
		connectingRoomCHAndRA.add(connectingRoomNumOfBedAmount);

		
		reserveDetailPanel.add(singleRoomCHAndRA);
		reserveDetailPanel.add(doubleRoomCHAndRA);
		reserveDetailPanel.add(suiteRoomCHAndRA);
		reserveDetailPanel.add(tripleRoomCHAndRA);
		reserveDetailPanel.add(deluxeRoomCHAndRA);
		reserveDetailPanel.add(connectingRoomCHAndRA);
		reserveDetailPanel.add(checkInLabelAndDatePanel);
		reserveDetailPanel.add(checkOutLabelAndDatePanel);
	
		// payment panel
		JPanel paymentPanel = new JPanel();
		
		// payment area tabbed pane
		JTabbedPane paymentTab = new JTabbedPane();
		
		// Card payment panel
		JPanel cardPaymentPanel = new JPanel();
		cardPaymentPanel.setLayout(new BoxLayout(cardPaymentPanel, BoxLayout.Y_AXIS));
		
		// card holder name and field panel
		JPanel cardHolderPanel = new JPanel();
		
		JLabel cardHolderLabel = new JLabel("Card Holder Name");
		JTextField cardHolderField = new JTextField(10);
		
		cardHolderPanel.add(cardHolderLabel);
		cardHolderPanel.add(cardHolderField);
		
		// card number and field panel
		JPanel cardNumberPanel = new JPanel();
		
		JLabel cardNumberLabel = new JLabel("Card Number");
		JTextField cardNumberField = new JTextField(10);
		
		cardNumberPanel.add(cardNumberLabel);
		cardNumberPanel.add(cardNumberField);
		
		// card expire date panel
		JPanel cardExpireDatePanel = new JPanel();
		
		JLabel cardExpireDateLabel = new JLabel("Expiration Date");
		JTextField cardExpireDateField  = new JTextField(10);
		
		cardExpireDatePanel.add(cardExpireDateLabel);
		cardExpireDatePanel.add(cardExpireDateField);
		
		// Total payment amount panel
		JPanel totalCardPaymentAmountPanel = new JPanel();
		
		JLabel totalCardPaymentAmountLabel = new JLabel("Total Amount");
		JTextField totalCardPaymentAmountField = new JTextField(10);
		
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountLabel);
		totalCardPaymentAmountPanel.add(totalCardPaymentAmountField);
		
		// payment completed radio button panel
		
		cardPaymentPanel.add(cardHolderPanel);
		cardPaymentPanel.add(cardNumberPanel);
		cardPaymentPanel.add(cardExpireDatePanel);
		cardPaymentPanel.add(totalCardPaymentAmountPanel);
		
		// Add to the specific payment panel to the payment tab		
		paymentTab.addTab("Card Payment", cardPaymentPanel);
		
		
		// Cash payment panel
		JPanel cashPaymentPanel = new JPanel();
		cashPaymentPanel.setLayout(new BoxLayout(cashPaymentPanel, BoxLayout.Y_AXIS));
		
		// payer name panel
		JPanel cashPayerPanel = new JPanel();
		
		JLabel cashPayerLabel = new JLabel("Payer Name");
		JTextField cashPayerField = new JTextField(10);
		
		cashPayerPanel.add(cashPayerLabel);
		cashPayerPanel.add(cashPayerField);
		
		// paid amount panel
		JPanel amountPanel = new JPanel();
		
		JLabel totalAmountLabel = new JLabel("Amount");
		JTextField amountField = new JTextField(10);
		
		amountPanel.add(totalAmountLabel);
		amountPanel.add(amountField);
		
		cashPaymentPanel.add(cashPayerPanel);
		cashPaymentPanel.add(amountPanel);
		
		// add to specific tab
		paymentTab.addTab("Cash Payment", cashPaymentPanel);
		
		
		// Add the specific tab to the whole payment panel
		paymentPanel.add(paymentTab);
		
		
		// SUBMIT AND CLEAR BUTTONS
		JPanel submitAndClearPanel = new JPanel();
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(130, 40));
		JButton clearBtn = new JButton("Clear");
		clearBtn.setPreferredSize(new Dimension(130, 40));
		
		submitAndClearPanel.add(submitBtn);
		submitAndClearPanel.add(clearBtn);
		
		
		
		
		
		resDetailAndPaymentPanel.add(reserveDetailPanel, BorderLayout.NORTH);
		resDetailAndPaymentPanel.add(paymentPanel, BorderLayout.CENTER);
		
		setTitle("Activities");
		setSize(1200, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(hotelNamePanel, BorderLayout.NORTH);
		add(activitiesPanel, BorderLayout.WEST);
		add(checkInSelectedPanel, BorderLayout.CENTER);
		add(resDetailAndPaymentPanel, BorderLayout.EAST);
		add(submitAndClearPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Activities();
	}
}
