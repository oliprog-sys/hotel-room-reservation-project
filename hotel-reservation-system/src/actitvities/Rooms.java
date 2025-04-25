package actitvities;

import java.awt.*;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Rooms extends Activities {
    JPanel roomPanel;
    DefaultTableModel roomModel;
    JTable roomTable;

    private static final String connectingString = "jdbc:sqlserver://DESKTOP-D5PCH38\\"
            + "SQLEXPRESS;Database=roomReservationJava;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public Rooms() {
        roomPanel = new JPanel();
        roomPanel.setBackground(new Color(36, 51, 51));
        
        roomModel = new DefaultTableModel();
        try {
            roomShow(roomModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        roomTable = new JTable(roomModel);
        
       
        roomTable.setPreferredScrollableViewportSize(new Dimension(1000, 490)); 
        
       
        setColumnWidths();

        JScrollPane sp = new JScrollPane(roomTable);
        roomPanel.add(sp);
    }

    void roomShow(DefaultTableModel dtm) throws SQLException {
        String roomsSql = "SELECT * FROM VRoom";
        try (Connection conn = DriverManager.getConnection(connectingString)) {
            try (Statement stmtCheckout = conn.createStatement();
                 ResultSet roomsRs = stmtCheckout.executeQuery(roomsSql)) {
                ResultSetMetaData metaData = roomsRs.getMetaData();
                int columnNum = metaData.getColumnCount();

                for (int i = 1; i <= columnNum; i++) {
                    dtm.addColumn(metaData.getColumnName(i));
                }

                while (roomsRs.next()) {
                    Object[] records = new Object[columnNum];
                    for (int i = 1; i <= columnNum; i++) {
                        records[i - 1] = roomsRs.getObject(i);
                    }
                    dtm.addRow(records);
                }
            }
        }
    }

    private void setColumnWidths() {
        // Example of setting specific column widths
        roomTable.getColumnModel().getColumn(0).setPreferredWidth(20); // First column width
        roomTable.getColumnModel().getColumn(1).setPreferredWidth(20); // Second column width
        // Continue for other columns as necessary
    }
}