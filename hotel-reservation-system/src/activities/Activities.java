package activities;
import java.awt.*;
import java.util.Calendar;

import javax.swing.*;
public class Activities extends JFrame {
	JPanel hotelNamePanel, activitiesPanel, checkInSelectedPanel;
	JLabel hotelNameLabel;
	JButton checkInBtn, checkOutBtn, roomsBtn, cancelReservBtn, guestsBtn, paymentsBtn;
	
	public Activities() {
		// hotel name panel
		hotelNamePanel = new JPanel();		
		
		hotelNameLabel = new JLabel("PLATINUM HOTEL");
		hotelNameLabel.setFont(new Font("Heveltica", Font.BOLD, 34));
		
		hotelNamePanel.add(hotelNameLabel);
		
		// activities panel
		activitiesPanel = new JPanel(new GridLayout(6, 1, 12, 15));		
		
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
		
		// first name panel
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel firstNameLabel = new JLabel("First Name");
		JTextField firstNameField = new JTextField(10);
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameField);
		
		//last name panel
		JPanel lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lastNameLabel = new JLabel("Last Name");
		JTextField lastNameField = new JTextField(10);
		
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameField);
		
		// Phone panel
		JPanel phoneNumPanel = new JPanel();
		phoneNumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel phoneNumLabel = new JLabel("Phone");
		JTextField phoneNumField = new JTextField(10);
		
		phoneNumPanel.add(phoneNumLabel);
		phoneNumPanel.add(phoneNumField);
		
		
		// address panel
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel addressLabel = new JLabel("Address");
		JTextField addressFeild = new JTextField(10);
		
		addressPanel.add(addressLabel);
		addressPanel.add(addressFeild);
		
		// email panel
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel emailLabel = new JLabel("Email");
		JTextField emailField = new JTextField(10);
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);		
		
		checkInSelectedPanel.add(firstNamePanel);
		checkInSelectedPanel.add(lastNamePanel);
		checkInSelectedPanel.add(phoneNumPanel);
		checkInSelectedPanel.add(addressPanel);
		checkInSelectedPanel.add(emailPanel);
		
		
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
		
		
		singleRoomCHAndRA.add(singleRoomCH);
		singleRoomCHAndRA.add(singleRoomAmount);
		
		// Double room check box and number of rooms
		JPanel doubleRoomCHAndRA = new JPanel();
		
		JCheckBox doubleRoomCH = new JCheckBox("Double Room");
		JSpinner doubleRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		doubleRoomCHAndRA.add(doubleRoomCH);
		doubleRoomCHAndRA.add(doubleRoomAmount);
		
		// Suite room check box and number of rooms
		JPanel suiteRoomCHAndRA = new JPanel();
		
		JCheckBox SuiteRoomCH = new JCheckBox("Suite Room");
		JSpinner SuiteRoomAmount = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		
		suiteRoomCHAndRA.add(SuiteRoomCH);
		suiteRoomCHAndRA.add(SuiteRoomAmount);
		
		
		
		reserveDetailPanel.add(singleRoomCHAndRA);
		reserveDetailPanel.add(doubleRoomCHAndRA);
		reserveDetailPanel.add(suiteRoomCHAndRA);
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
		
		cardPaymentPanel.add(cardHolderPanel);
		cardPaymentPanel.add(cardNumberPanel);
		cardPaymentPanel.add(cardExpireDatePanel);
		cardPaymentPanel.add(totalCardPaymentAmountPanel);
		
		// Add to the specific payment panel to the payment tab		
		paymentTab.addTab("Card Payment", cardPaymentPanel);
		
		// Add the specific tab to the whole payment panel
		paymentPanel.add(paymentTab);
		
		
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
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Activities();
	}
}
