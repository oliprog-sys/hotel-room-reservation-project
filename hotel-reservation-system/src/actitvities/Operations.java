//package actitvities;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//import java.sql.*;
//
//
//
//public class Operations {
//	
//	private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
//			+ "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";
//	String genderRe;
//	Activities ac;
//	
//	public Operations(Activities a) {
//		ac = a;
//	}
//	
////	String genderSelected() {
////		if(ac.maleRB.isSelected()) {
////			gender = "M";
////		} else if(ac.femaleRB.isSelected()) {
////			gender = "F";
////		}
////		return gender;
////	}
////	
//	
//	
//	void addUser() throws SQLException {
//	    String fName = ac.firstNameField.getText();
//	    String lName = ac.middleNameField.getText();
//	    String gfName = ac.lastNameField.getText();
//	    String phone = ac.phoneNumField.getText();
//	    String address = ac.addressField.getText();
//	    String email = ac.emailField.getText();
//	    String nationality = ac.nationalityField.getText();
////	    String genderRe;
////	    if(ac.maleRB.isSelected()) {
////	    	genderRe = "M";
////	    } else if(ac.femaleRB.isSelected()) {
////	    	genderRe = "F";
////	    }
//	    java.util.Date date = (java.util.Date) ac.dateSpinnerDoB.getValue();
//	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
////	    String gender = getGender(); // Ensure this method is implemented and returns valid data
////	    ReceiptPage rp = new ReceiptPage();
////        rp.nameLabel.setText("Name: "+ fName+" "+lName+" "+gfName);
////        rp.phoneLabel.setText("Phone Num: "+phone);
////        rp.nationalityLabel.setText("Nationaliry: "+nationality);
//	    
//
//	    String sql = "INSERT INTO Custo(cust_Fname, cust_Lname, cust_Gname, cust_email, cust_DOB, cust_gender, cust_address, cust_Nationality) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//	    try (Connection conn = DriverManager.getConnection(connectingString);
//	         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//	        
//	        pstmt.setString(1, fName);
//	        pstmt.setString(2, lName);
//	        pstmt.setString(3, gfName);
//	        pstmt.setString(4, email);    
//	        pstmt.setDate(5, sqlDate);
//	        pstmt.setString(6, genderRe);
//	        pstmt.setString(7, address);
//	        pstmt.setString(8, nationality);  
//	        
//	        
//	        
//	        // Execute the insert
//	        int affectedRows = pstmt.executeUpdate(); // Execute the statement
//
//	        // Check if the insert was successful
//	        if (affectedRows == 0) {
//	            throw new SQLException("Inserting user failed, no rows affected.");
//	        }
//
//	        // Retrieve the generated customer ID
//	        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
//	            if (generatedKeys.next()) {
//	                int custId = generatedKeys.getInt(1); 
//
//	                // Now insert into the CustomerPhoneNum table
//	                String custPhone = "INSERT INTO CustomerPhoneNum(cust_id, cust_phone) VALUES(?, ?)";
//	                try (PreparedStatement pstmtPhone = conn.prepareStatement(custPhone)) {
//	                    pstmtPhone.setLong(1, custId); // Use the retrieved cust_id
//	                    pstmtPhone.setString(2, phone);
//	                    pstmtPhone.executeUpdate();
//	                }
//	            } else {
//	                System.out.println("Failed to retrieve customer ID.");
//	            }
//	        }
//	        	     
//
//	        System.out.println("Customer added successfully");
//	    } catch (SQLException se) {
//	        System.out.println("Error: " + se.getMessage());
//	        se.printStackTrace();                    
//	    }
//	}
//	
//	
//	
//	// make reservation method
//	public void makeReservation() throws SQLException {
//		
//		java.util.Date chInDate = (java.util.Date)ac.dateSpinner.getValue();
//		java.sql.Date sqlChInDate = new java.sql.Date(chInDate.getTime());
//		java.util.Date chOutDate = (java.util.Date) ac.dateSpinner2.getValue();
//		java.sql.Date sqlChOutDate = new java.sql.Date(chOutDate.getTime());
//		int singleRoomCount = (Integer) ac.singleRoomAmount.getValue();
//		int doubleRoomCount = (Integer) ac.doubleRoomAmount.getValue();
//		int suiteRoomCount = (Integer) ac.suiteRoomAmount.getValue();
//		int deluxeRoomCount = (Integer) ac.deluxeRoomAmount.getValue();
//		int tripleRoomCount = (Integer) ac.tripleRoomAmount.getValue();
//		int connectingRoomCount = (Integer) ac.connectingRoomAmount.getValue();			
//		
//		
//		
//		try (Connection conn = DriverManager.getConnection(connectingString)){			
//			if(ac.singleRoomCH.isSelected()) {
//				if(singleRoomCount > 0) {
//					String singleRoomSql = "SELECT TOP " + singleRoomCount + " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Single'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(singleRoomSql)){
////						pstmtReserv.setInt(1, singleRoomCount);
//						
////						String updateSingleRoom = "UPDATE Rom SET rom_status= ?"
//						try (ResultSet sRoom = pstmtReserv.executeQuery()){
//							while(sRoom.next()) {
//								int roomNum = sRoom.getInt("rom_num");
//								
//								System.out.println("Available room: "+roomNum);
//								
//								
//							}
//						}
//					}
//				}
//			}else if(ac.doubleRoomCH.isSelected()) {
//				if(doubleRoomCount > 0) {
//					String doubleRoomSql = "SELECT TOP " +doubleRoomCount+ " * FROM VRooms WHERE rom_status='Available' AND ro_typename='Double'";
//					try(PreparedStatement pstmtReserv = conn.prepareStatement(doubleRoomSql)){
////						pstmtReserv.setInt(1, doubleRoomCount);
//						
//						try (ResultSet dRoom = pstmtReserv.executeQuery()){
//							while(dRoom.next()) {
//								int roomNum = dRoom.getInt("rom_num");
//								
//								// add the to the receipt
//								System.out.println("Available room: "+roomNum);
//							}
//						
//						}
//					}
//				}				
//				
//			} 
//			
//		} catch(SQLException se) {
//			System.out.println("Error: "+se.getMessage());
//			se.printStackTrace();
//		}
//	}
//	
////	public static void main(String[] args) {
////		new Operations()
////		
////	}
//
//}
