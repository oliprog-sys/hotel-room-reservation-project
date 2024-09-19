package homePage;

import java.awt.*;
import javax.swing.*;

import logIn.SignIn;
import signUp.signUp;

//import guiPrac.MainImagePanel;

import javax.imageio.ImageIO;
//import javax.imageio.stream.ImageOutputStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

//public class HomePageClass extends JFrame{
//	
//	JPanel mainPanel, hotelNamePanel, bookNowPanel;//, checkInPanel, checkOutPanel, roomsPanel, guestsPanel, menubarPanel, 
//	//logOutPanel, , menuBarAndLogOutPanel;
//	JButton bookNowBtn; // checkInBtn, checkOutBtn, roomsBtn, guestsBtn, logoutBtn, menuBarBtn, 
//	// cancelReservationBtn, closeBtn;
//	JLabel hotelName;	
//	public HomePageClass() {
//		
//		// MAIN IMAGE PANEL WHERE ALL THE CONTAINERS AND THE COMPONENTS ADDED
//		BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("hotelBuilding1.jpg")); // Load your image here
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//	     MainImagePanel panel = new MainImagePanel(img);
//		
////		
//
//		// MAIN PANEL
//		mainPanel = new JPanel();
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
////		mainPanel.setBorder(BorderFactory.createEmptyBorder(80, 20, 20, 20));
////		mainPanel.setBackground(new Color(255, 255, 255, 0));
////		mainPanel.setBackground(Color.green);
//		mainPanel.setPreferredSize(new Dimension(910, 400));
//		
//		// HOTEL NAME PANEL
//		hotelNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 2));
//		hotelNamePanel.setBackground(new Color(255, 255, 255, 0));
////		hotelNamePanel.setBackground(Color.red);		
//		
//		
////		// Close button
////		closeBtn = new JButton("X");
////		closeBtn.setFocusable(false);
////		closeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
//		
//		
//		// hotel name label
//		hotelName = new JLabel("PLATINUM HOTEL");
////		hotelName.setBorder(BorderFactory.createEmptyBorder(8, 300, 2, 0));
//		hotelName.setFont(new Font("Helvetica", Font.BOLD, 43));
//		
//		hotelNamePanel.add(hotelName);
//		
//		JPanel welcomePanel = new JPanel();
//		welcomePanel.setBackground(new Color(255, 255, 255, 0));
//		
//		
//		// welcome label
//		JLabel welcomeLabel = new JLabel("WELCOME TO THE PLATINUM HOTEL'S");
//		welcomeLabel.setForeground(Color.WHITE);
//		welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
//		
//		JLabel welcomeLabel2 = new JLabel("BOOKING APP");
//		welcomeLabel2.setForeground(Color.WHITE);
//		welcomeLabel2.setFont(new Font("Helvetica", Font.BOLD, 40));
//		
//		welcomePanel.add(welcomeLabel);
//		welcomePanel.add(welcomeLabel2);
//		
//		mainPanel.add(welcomePanel);		
//		
//		// Book now button panel
//		bookNowPanel = new JPanel();
//		bookNowPanel.setBackground(new Color(255, 255, 255, 0));
//		// book now button
//		bookNowBtn = new JButton("Book Now >");
//		bookNowBtn.setFont(new Font("Roboto", Font.BOLD, 43));		
////		bookNowBtn.setBackground(new Color(255, 255, 255, 0));
//		bookNowBtn.setFocusable(false);
//		bookNowBtn.setBorder(null);
//		
//		bookNowPanel.add(bookNowBtn);
//		
//		mainPanel.add(bookNowPanel);
//		
//		
//		
//		panel.add(hotelNamePanel, BorderLayout.NORTH);
//		panel.add(mainPanel, BorderLayout.CENTER);		
////		panel.add(menubarPanel, BorderLayout.EAST);
//		
//		
//		setTitle("Home");
//		setSize(1200, 650);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		setUndecorated(true);
//		setLocationRelativeTo(null);
////		add(hotelNamePanel, BorderLayout.NORTH);
////		add(mainPanel, BorderLayout.CENTER);
////		add(menubarPanel, BorderLayout.EAST);
//		add(panel);
//		setVisible(true);
//		
//		
//
//		
//	}
//	
//	public static void main(String[] args) {
//		new HomePageClass();
//	}
//	
//}
//
//class MainImagePanel extends JPanel {
//	private BufferedImage backgroundImage;
//
//	public MainImagePanel(BufferedImage image) {
//        this.backgroundImage = image;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (backgroundImage != null) {
//            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//        }
//    }
//}



//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class HomePageClass extends JFrame {
    
    JPanel mainPanel, hotelNamePanel, bookNowPanel, receptionistIdPanel;
    JButton bookNowBtn; 
    JLabel hotelName, receptionistIdLabel;    
    JMenuBar menuBar;
    JTextField receptionistIdField;
    
    private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public HomePageClass() {
        
        // MAIN IMAGE PANEL WHERE ALL THE CONTAINERS AND THE COMPONENTS ADDED
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("hotelBuilding1.jpg")); // Load your image here
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainImagePanel panel = new MainImagePanel(img);

        // MAIN PANEL
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(910, 400));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(80, 20, 20, 20));
        mainPanel.setBackground(new Color(255, 255, 255, 0));

        
        // HOTEL NAME PANEL
        hotelNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 2));
        hotelNamePanel.setBackground(new Color(255, 255, 255, 0));
        
        // hotel name label
        hotelName = new JLabel("PLATINUM HOTEL");
        hotelName.setFont(new Font("Helvetica", Font.BOLD, 43));
        hotelNamePanel.add(hotelName);
        
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(255, 255, 255, 0));
        
        // welcome labels
        JLabel welcomeLabel = new JLabel("WELCOME TO THE PLATINUM HOTEL'S");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
        
        JLabel welcomeLabel2 = new JLabel("BOOKING APP");
        welcomeLabel2.setForeground(Color.WHITE);
        welcomeLabel2.setFont(new Font("Helvetica", Font.BOLD, 40));
        
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(welcomeLabel2);
        
        mainPanel.add(welcomePanel);  
        
        // receptionist panel
        receptionistIdPanel = new JPanel();
        receptionistIdPanel.setBackground(new Color(255, 255, 255, 0));
        
        receptionistIdLabel = new JLabel("Rec ID");
        receptionistIdLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        receptionistIdLabel.setForeground(Color.WHITE);
        
        receptionistIdField = new JTextField(8);
        
        receptionistIdPanel.add(receptionistIdLabel);
        receptionistIdPanel.add(receptionistIdField);
        
        
        // Book now button panel
        bookNowPanel = new JPanel();
        bookNowPanel.setBackground(new Color(255, 255, 255, 0));
        bookNowBtn = new JButton("Book Now >");
        bookNowBtn.setFont(new Font("Roboto", Font.BOLD, 43));		
        bookNowBtn.setFocusable(false);
        bookNowBtn.setBorder(null);
        
        bookNowPanel.add(bookNowBtn);
        mainPanel.add(bookNowPanel);
        
        // Create the menu bar
        menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        JMenuItem addUser = new JMenuItem("Add User");
        JMenuItem updateUser = new JMenuItem("Update User");
        JMenuItem deleteUser = new JMenuItem("Delete User");
        JMenuItem logOut = new JMenuItem("Log out");
        
        userMenu.add(addUser);
        userMenu.add(updateUser);
        userMenu.add(deleteUser);
        userMenu.add(logOut);
        menuBar.add(userMenu);
        
        // Add menu bar to the top right
        setJMenuBar(menuBar);
        
        ListenerClass lc = new ListenerClass();
        addUser.addActionListener(lc);
        updateUser.addActionListener(lc);
     
        
        panel.add(hotelNamePanel, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);   
        panel.add(receptionistIdPanel, BorderLayout.SOUTH);
        
        setTitle("Home");
        setSize(1200, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
//        setVisible(true);
    }
    
   
    
    class ListenerClass implements ActionListener{    	

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "Add User") {
				new signUp().setVisible(true);
			} else if(e.getActionCommand() == "Update User") {
				UpdateAndDeleteClass udc = new UpdateAndDeleteClass();
				try {
					udc.updateAndDeleteFun();
					udc.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
    	
    }
        
    
    public void recIdValueInLogin() throws SQLException {
    	String usernameValue = SignIn.recUsername;
    	try(Connection conn = DriverManager.getConnection(connectingString)){
    		String specificRec = "SELECT * FROM Receptionist WHERE rc_username=?";
    		try(PreparedStatement pstmtRecValue = conn.prepareStatement(specificRec)){    
    			pstmtRecValue.setString(1, usernameValue);
    			String recId="";
    			try(ResultSet recValue = pstmtRecValue.executeQuery()){
    				if(recValue.next()) {
    					int Id = recValue.getInt("rc_id");
    					recId += String.valueOf(Id);
    					receptionistIdField.setText(recId);
    				}
    			}
    		}
    	}
    }
    
    void updateAndDelete() throws SQLException {    	    	
		
    }
    
    public void recIdValueInSignUp(String Id) throws SQLException {
    	receptionistIdField.setText(Id);
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


