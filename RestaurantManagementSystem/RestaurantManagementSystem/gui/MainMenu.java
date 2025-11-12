package gui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Restaurant Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton btnPlaceOrder = new JButton("Place Order");
        JButton btnGenerateBill = new JButton("Generate Bill");

        btnPlaceOrder.setBounds(100, 80, 200, 40);
        btnGenerateBill.setBounds(100, 140, 200, 40);

        add(btnPlaceOrder);
        add(btnGenerateBill);

        btnPlaceOrder.addActionListener(e -> new PlaceOrder().setVisible(true));
        btnGenerateBill.addActionListener(e -> new GenerateBill().setVisible(true));
    }
}