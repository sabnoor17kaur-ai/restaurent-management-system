package gui;

import db.DBConnection;
import javax.swing.*;
import java.sql.*;

public class PlaceOrder extends JFrame {
    private JTextField orderIdField, tableIdField, itemIdField, qtyField;

    public PlaceOrder() {
        setTitle("Place Order");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Order ID:");
        JLabel l2 = new JLabel("Table ID:");
        JLabel l3 = new JLabel("Item ID:");
        JLabel l4 = new JLabel("Quantity:");

        orderIdField = new JTextField();
        tableIdField = new JTextField();
        itemIdField = new JTextField();
        qtyField = new JTextField();

        JButton placeOrderBtn = new JButton("Place Order");

        l1.setBounds(30, 30, 100, 25);
        orderIdField.setBounds(140, 30, 200, 25);

        l2.setBounds(30, 70, 100, 25);
        tableIdField.setBounds(140, 70, 200, 25);

        l3.setBounds(30, 110, 100, 25);
        itemIdField.setBounds(140, 110, 200, 25);

        l4.setBounds(30, 150, 100, 25);
        qtyField.setBounds(140, 150, 200, 25);

        placeOrderBtn.setBounds(140, 200, 120, 30);

        add(l1); add(orderIdField);
        add(l2); add(tableIdField);
        add(l3); add(itemIdField);
        add(l4); add(qtyField);
        add(placeOrderBtn);

        placeOrderBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection();
                 CallableStatement stmt = conn.prepareCall("{call PLACE_ORDER(?, ?, ?, ?)}")) {

                stmt.setInt(1, Integer.parseInt(orderIdField.getText()));
                stmt.setInt(2, Integer.parseInt(tableIdField.getText()));
                stmt.setInt(3, Integer.parseInt(itemIdField.getText()));
                stmt.setInt(4, Integer.parseInt(qtyField.getText()));
                stmt.execute();

                JOptionPane.showMessageDialog(this, "Order placed successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}