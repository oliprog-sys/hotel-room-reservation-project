package actitvities;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReceiptClass extends JFrame {
	
	CheckInClass cic;	
	JPanel mainReceiptPanel, namePanel, checkInDatePanel, checkOutDatePanel, paymentMethodPanel, singlePanel, doublePanel,
	triplePanel, suitePanel, deluxePanel, connectingPanel, totalPanel;
	JLabel nameLabel, cusNameLabel, checkInLabel, checkInRes, checkoutLabel, checkOutRes, payMethodLabel,
	payLabelRes, singleLabel, singleRes, doubleLabel, doubleRes, tripleLabel, tripleRes,suiteLabel, suiteRes,
	deluxeLabel, deluxeRes, connectingLabel, connectingRes, totalLabel, totalRes;
	JButton closeBtn;
	public ReceiptClass(CheckInClass cic) {
		this.cic = cic;				
		
		mainReceiptPanel = new JPanel();
		mainReceiptPanel.setLayout(new BoxLayout(mainReceiptPanel, BoxLayout.Y_AXIS));
		
		namePanel = new JPanel();
		nameLabel = new JLabel("Name: ");
		cusNameLabel = new JLabel();
		namePanel.add(nameLabel);
		namePanel.add(cusNameLabel);
		
		checkInDatePanel = new JPanel();
		checkInLabel = new JLabel("Check In Date");
		checkInRes = new JLabel();
		checkInDatePanel.add(checkInLabel);
		checkInDatePanel.add(checkInRes);
		
		checkOutDatePanel = new JPanel();
		checkoutLabel = new JLabel("Check Out Date");
		checkOutRes = new JLabel();
		checkOutDatePanel.add(checkoutLabel);
		checkOutDatePanel.add(checkOutRes);
		
		paymentMethodPanel = new JPanel();
		payMethodLabel = new  JLabel("Payment Method");
		payLabelRes = new JLabel();
		paymentMethodPanel.add(payMethodLabel);
		paymentMethodPanel.add(payLabelRes);
		
		singlePanel = new JPanel();		
		singleRes = new JLabel();		
		singlePanel.add(singleRes);
		
		doublePanel = new JPanel();		
		doubleRes = new JLabel();	
		doublePanel.add(doubleRes);
		
		triplePanel = new JPanel();
		tripleRes = new JLabel();
		triplePanel.add(tripleRes);
		
		suitePanel = new JPanel();
		suiteRes = new JLabel();
		suitePanel.add(suiteRes);
		
		deluxePanel = new JPanel();
		deluxeRes = new JLabel();
		deluxePanel.add(deluxeRes);
		
		connectingPanel = new JPanel();
		connectingRes = new JLabel();
		connectingPanel.add(connectingRes);
		
		totalPanel = new JPanel();
		totalLabel = new JLabel("Total");
		totalRes = new JLabel();
		totalPanel.add(totalLabel);
		totalPanel.add(totalRes);
		
		JPanel closePanel = new JPanel();
		closeBtn  = new JButton("Close");
		closePanel.add(closeBtn);
		
				
		receiptData();
		
		mainReceiptPanel.add(namePanel);
		mainReceiptPanel.add(checkInDatePanel);
		mainReceiptPanel.add(checkOutDatePanel);
		mainReceiptPanel.add(paymentMethodPanel);
		mainReceiptPanel.add(singlePanel);
		mainReceiptPanel.add(doublePanel);
		mainReceiptPanel.add(triplePanel);
		mainReceiptPanel.add(suitePanel);
		mainReceiptPanel.add(deluxePanel);
		mainReceiptPanel.add(connectingPanel);
		mainReceiptPanel.add(totalPanel);
		mainReceiptPanel.add(closePanel);
		
		JLabel hotelNameLabel = new JLabel();
		hotelNameLabel.setText("PLATINUM HOTEL");
		
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
		
		setSize(310, 410);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(hotelNameLabel, BorderLayout.NORTH);
		add(mainReceiptPanel);
	}
	
	public void receiptData() {					
		cusNameLabel.setText(CheckInClass.fname+" "+CheckInClass.lname);
//		System.out.println(cic.firstNameField);
//		Date date = (Date) cic.dateSpinner.getValue();
	    SimpleDateFormat cinString = new SimpleDateFormat("yyyy-MM-dd");	    
		checkInRes.setText(cinString.format(CheckInClass.cinDate));
//		Date date2 = (Date) cic.dateSpinner2.getValue();
	    SimpleDateFormat coutString = new SimpleDateFormat("yyyy-MM-dd");	  
		checkOutRes.setText(coutString.format(CheckInClass.coutDate));
		
		int selectedTab = cic.paymentTab.getSelectedIndex();
		String selectedName = cic.paymentTab.getTitleAt(selectedTab);
		if(selectedName.equals("Card Payment")) {
			payLabelRes.setText("Card");		
		} else if(selectedName.equals("Cash Payment")) {
			payLabelRes.setText("Cash");
		}
		if(String.valueOf(CheckInClass.singleAmount) == null || CheckInClass.singleType == null) {
			singleRes.setText("Single Room: none");
		} else {
			singleRes.setText(String.valueOf(CheckInClass.singleAmount)+" "+CheckInClass.singleType);
		}
		
		if(String.valueOf(CheckInClass.doubleAmount) == null || CheckInClass.doubleType == null) {
			doubleRes.setText("Double Room: none");
		} else {
			doubleRes.setText(String.valueOf(CheckInClass.doubleAmount)+" "+CheckInClass.doubleType);
		}
		
		if(String.valueOf(CheckInClass.tripleAmount) == null || CheckInClass.tripleType == null) {
			tripleRes.setText("Triple Room: none");
		} else {
			tripleRes.setText(String.valueOf(CheckInClass.tripleAmount)+" "+CheckInClass.tripleType);
		}
		
		if(String.valueOf(CheckInClass.suiteAmount) == null || CheckInClass.suiteType == null) {
			suiteRes.setText("Suite Room: none");
		} else {
			suiteRes.setText(String.valueOf(CheckInClass.suiteAmount)+" "+CheckInClass.suiteType);
		}
		
		if(String.valueOf(CheckInClass.deluxeAmount) == null || CheckInClass.deluxeType == null) {
			deluxeRes.setText("Deluxe Room: none");
		} else {
			deluxeRes.setText(String.valueOf(CheckInClass.singleAmount)+" "+CheckInClass.singleType);
		}
		
		if(String.valueOf(CheckInClass.connectingAmount) == null || CheckInClass.connectingType == null) {
			connectingRes.setText("Single Room: none");
		} else {
			connectingRes.setText(String.valueOf(CheckInClass.connectingAmount)+" "+CheckInClass.connectingType);
		}
		
		
		if(selectedName.equals("Card Payment")) {
			totalRes.setText(String.valueOf(CheckInClass.total));		
		} else if(selectedName.equals("Cash Payment")) {
			totalRes.setText(String.valueOf(CheckInClass.total));		
		}
	}
	
}
