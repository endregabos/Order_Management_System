package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class Menu extends JFrame {
    public Menu(){
        setTitle("Menu");
        setBounds(100, 100, 375, 302);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnClients = new JButton("Clients");
        btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientMenu clientMenu = new ClientMenu();

                setVisible(false);
            }
        });
        btnClients.setBounds(128, 62, 107, 42);
        getContentPane().add(btnClients);

        JButton btnProducts = new JButton("Products");
        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductMenu productMenu = new ProductMenu();

                setVisible(false);
            }
        });
        btnProducts.setBounds(128, 115, 107, 42);
        getContentPane().add(btnProducts);

        JLabel lblNewLabel = new JLabel("Order Management");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(101, 11, 160, 23);
        getContentPane().add(lblNewLabel);

        JButton btnOrders = new JButton("Orders");
        btnOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderMenu orderMenu = new OrderMenu();

                setVisible(false);
            }
        });
        btnOrders.setBounds(128, 168, 107, 42);
        getContentPane().add(btnOrders);

       setVisible(true);
    }

}
