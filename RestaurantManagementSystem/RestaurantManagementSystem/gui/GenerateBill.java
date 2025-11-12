package gui;

import db.DBConnection;
import javax.swing.*;
import java.sql.*;

public class GenerateBill extends JFrame {
    private JTextField orderIdField;

    public GenerateBill() {
        setTitle("Generate Bill");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Order ID:");
        orderIdField = new JTextField();
        JButton generateBtn = new JButton("Generate");

        l1.setBounds(30, 50, 100, 25);
        orderIdField.setBounds(120, 50, 180, 25);
        generateBtn.setBounds(120, 100, 120, 30);

        add(l1); add(orderIdField); add(generateBtn);

        generateBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection();
                 CallableStatement stmt = conn.prepareCall("{call GENERATE_BILL(?)}")) {

                stmt.setInt(1, Integer.parseInt(orderIdField.getText()));
                stmt.execute();

                JOptionPane.showMessageDialog(this, "Bill generated. Check console/output.");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}