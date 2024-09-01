package homePage;

import java.awt.*;
import javax.swing.*;

import guiPrac.MainImagePanel;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePageClass extends JFrame{
	
	JPanel mainPanel, checkInPanel, checkOutPanel, roomsPanel, guestsPanel, menubarPanel, 
	logOutPanel, hotelNamePanel, menuBarAndLogOutPanel;
	JButton checkInBtn, checkOutBtn, roomsBtn, guestsBtn, logoutBtn, menuBarBtn, 
	cancelReservationBtn, closeBtn;
	JLabel hotelName;
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	public HomePageClass() {
		
		// MAIN IMAGE PANEL WHERE ALL THE CONTAINERS AND THE COMPONENTS ADDED
		BufferedImage img = null;
        try {
            img = ImageIO.read(new File("hotelBuilding1.jpg")); // Load your image here
        } catch (IOException e) {
            e.printStackTrace();
        }

	     MainImagePanel panel = new MainImagePanel(img);
		
		x
		// MAIN PANEL
		mainPanel = new JPanel(new GridLayout(3, 2, 20, 17));	
		mainPanel.setBorder(BorderFactory.createEmptyBorder(80, 20, 20, 20));
		mainPanel.setBackground(new Color(255, 255, 255, 0));
		mainPanel.setBackground(Color.green);
		mainPanel.setPreferredSize(new Dimension(910, 400));
		
		// HOTEL NAME PANEL
		hotelNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 2));
		hotelNamePanel.setBackground(new Color(255, 255, 255, 0));
		hotelNamePanel.setBackground(Color.red);		
		
		
//		// Close button
//		closeBtn = new JButton("X");
//		closeBtn.setFocusable(false);
//		closeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		// hotel name label
		hotelName = new JLabel("PLATINUM HOTEL");
		hotelName.setBorder(BorderFactory.createEmptyBorder(8, 300, 2, 0));
		hotelName.setFont(new Font("Helvetica", Font.BOLD, 43));
		
		
		// Menu bar icon		
		ImageIcon image = new ImageIcon("menuIcon.png");
		// Menu bar button
		menuBarBtn = new JButton("Menu");
		menuBarBtn.setBorder(null);
		menuBarBtn.setFocusable(false);
		menuBarBtn.setFont(new Font("Sans serif", Font.PLAIN, 25));		
		menuBarBtn.setIcon(image);
		menuBarBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		hotelNamePanel.add(hotelName);
		
		hotelNamePanel.add(menuBarBtn);
//		hotelNamePanel.add(closeBtn, BorderLayout.EAST);
		
//		closeBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
		
		// CHECK IN PANEL
		//checkInPanel = new JPanel();
		// check int button
		checkInBtn = new JButton("Check In");
		checkInBtn.setFocusable(false);
		checkInBtn.setFont(new Font("Roboto", Font.BOLD, 45));
		checkInBtn.setBorder(null);		
//		checkInBtn.setBackground(Color.white);
		// Add the check in button on the panel
	//	checkInPanel.add(checkInBtn);
		
		// CHECK OUT PANEL
	//	checkOutPanel = new JPanel();
		// check out button
		checkOutBtn = new JButton("Check Out");
		checkOutBtn.setFocusable(false);
		checkOutBtn.setFont(new Font("Roboto", Font.BOLD, 45));
		checkOutBtn.setBorder(null);
		// Add the check out button on the panel
	//	checkOutPanel.add(checkOutBtn);
		
		// ROOMS PANEL
	//	roomsPanel = new JPanel();
		// rooms button
		roomsBtn = new JButton("Rooms");
		roomsBtn.setFocusable(false);
		roomsBtn.setFont(new Font("Roboto", Font.BOLD, 45));
		roomsBtn.setBorder(null);
		// Add the rooms button on the panel
	//	roomsPanel.add(roomsBtn);
				
		// GUESTS PANEL
	//	guestsPanel = new JPanel();
		// guests button
		guestsBtn = new JButton("Guests");
		guestsBtn.setFocusable(false);
		guestsBtn.setFont(new Font("Roboto", Font.BOLD, 45));
		guestsBtn.setBorder(null);
		// Add the check out button on the panel
	//	guestsPanel.add(guestsBtn);
		
		// cancel the reservation button
		cancelReservationBtn = new JButton("Cancel Reservation");
		cancelReservationBtn.setFocusable(false);
		cancelReservationBtn.setFont(new Font("Roboto", Font.BOLD, 45));
		cancelReservationBtn.setBorder(null);
		
//		// MENU BAR AND LOG OUT CONTAINER
//		menuBarAndLogOutPanel = new JPanel(new BorderLayout());
//		menuBarAndLogOutPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		menuBarAndLogOutPanel.setBackground(Color.blue);

		// MENU BAR PANEL
		menubarPanel = new JPanel();
		menubarPanel.setLayout(new BorderLayout());
		menubarPanel.setBackground(Color.CYAN);

//		// Menu bar icon		
//		ImageIcon image = new ImageIcon("menuIcon.png");
//		// Menu bar button
//		menuBarBtn = new JButton("Menu");
//		menuBarBtn.setBorder(null);
//		menuBarBtn.setFocusable(false);
//		menuBarBtn.setFont(new Font("Sans serif", Font.PLAIN, 25));
//		menuBarBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Adjust padding if needed
//		menuBarBtn.setIcon(image);
		
//		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		buttonPanel.add(menuBarBtn);

//		// Log out icon
//		ImageIcon image2 = new ImageIcon("logOutIcon.png");
//		// Log out button
//		logoutBtn = new JButton("Log Out");
//		logoutBtn.setBorder(null);
//		logoutBtn.setFocusable(false);
//		logoutBtn.setIcon(image2);
//		logoutBtn.setFont(new Font("Sans serif", Font.PLAIN, 25));
//
//		// Create a panel for the top button and set alignment
//		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		topPanel.add(menuBarBtn);
//
//		// Create a panel for the bottom button and set alignment
//		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		bottomPanel.add(logoutBtn);

		// Add panels to the menubarPanel
//		menubarPanel.add(topPanel, BorderLayout.NORTH);
//		menubarPanel.add(bottomPanel, BorderLayout.SOUTH);
		
//		menubarPanel.add(buttonPanel, BorderLayout.NORTH);

		// ADD ALL PANELS TO THE MAIN PANEL		
		mainPanel.add(checkInBtn);
		mainPanel.add(checkOutBtn);
		mainPanel.add(roomsBtn);
		mainPanel.add(guestsBtn);
		mainPanel.add(cancelReservationBtn);

		// ADD TO THE MENU AND LOG OUT PANEL
//		menuBarAndLogOutPanel.add(menubarPanel);
		
		panel.add(hotelNamePanel, BorderLayout.NORTH);
		panel.add(mainPanel, BorderLayout.CENTER);		
		panel.add(menubarPanel, BorderLayout.EAST);
		
		
		setTitle("Home");
		setSize(1200, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true);
		setLocationRelativeTo(null);
//		add(hotelNamePanel, BorderLayout.NORTH);
//		add(mainPanel, BorderLayout.CENTER);
//		add(menubarPanel, BorderLayout.EAST);
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new HomePageClass();
	}
	
}

class MainImagePanel extends JPanel {
	private BufferedImage backgroundImage;

	public MainImagePanel(BufferedImage image) {
        this.backgroundImage = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}