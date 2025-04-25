package actitvities;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.*;


public class Customer extends Activities {
	
	JPanel searchPanel, guestTablePanel;
	JLabel searchLabel, errorLabel;
	JTextField searchField;
	JTable guestTable;
	DefaultTableModel guestTableModel;
	JButton checkBtn;
	
	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";

	public Customer() {
									
		
		guestTablePanel = new JPanel();
		guestTablePanel.setBackground(new Color(36, 51, 51));
		
		guestTableModel = new DefaultTableModel();
		
		try {
			addCustomer(guestTableModel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		guestTable = new JTable(guestTableModel);
		
		  
		guestTable.setPreferredScrollableViewportSize(new Dimension(900, 470)); 
        
       
        setColumnWidths();

	
				
		guestTablePanel.add(new JScrollPane(guestTable));
				
				
		
				
		
//		add(checkoutMainPanel, BorderLayout.CENTER);
		
		
	}	
	
	private void addCustomer(DefaultTableModel dtm) throws SQLException {
		try(Connection conn = DriverManager.getConnection(connectingString)){
			String Sql = "SELECT * FROM ViewGuests";
			try(Statement stmtguests = conn.createStatement();
					ResultSet checkRs = stmtguests.executeQuery(Sql)){
				ResultSetMetaData metaData = checkRs.getMetaData();
				int columnNum = metaData.getColumnCount();
				
				for(int i = 1; i <= columnNum; i++) {
					dtm.addColumn(metaData.getColumnName(i));					
				}
				
				while(checkRs.next()) {
					Object[] records = new Object[columnNum];
					for(int i = 1; i <= columnNum; i++) {
						records[i-1] = checkRs.getObject(i);
					}
					dtm.addRow(records);
				}
			}
		} catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	private void setColumnWidths() {
		guestTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		guestTable.getColumnModel().getColumn(8).setPreferredWidth(200); 
        
    }
}
