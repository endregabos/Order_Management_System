package gui;

import businesslogic.OrderBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class OrderMenu extends JFrame {
    /**
     * Field for the id of the order, to generate the bill
     */
    private JTextField textField;

    public OrderMenu(){
        setTitle("Menu - Orders");
        setBounds(100, 100, 375, 358);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnOrdersInsert = new JButton("New Order");
        btnOrdersInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewOrderView newOrder = new NewOrderView();

                setVisible(false);
            }
        });
        btnOrdersInsert.setBounds(128, 75, 107, 42);
        getContentPane().add(btnOrdersInsert);

        JLabel lblNewLabel = new JLabel("Orders - Operations");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(91, 11, 183, 23);
        getContentPane().add(lblNewLabel);

        JButton btnOrdersView = new JButton("View Orders");
        btnOrdersView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllOrdersView allOrders = new AllOrdersView();

                setVisible(false);
            }
        });
        btnOrdersView.setBounds(128, 139, 107, 42);
        getContentPane().add(btnOrdersView);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();

                setVisible(false);
            }
        });
        btnBack.setBounds(260, 282, 89, 23);
        getContentPane().add(btnBack);

        JButton btnGenerateBill = new JButton("Generate Bill");
        btnGenerateBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().equals("")){
                    OrderBLL orderBLL = new OrderBLL();
                    orderBLL.orderBill(Integer.parseInt(textField.getText()));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty Fields!");
                }

                textField.setText("");
            }
        });
        btnGenerateBill.setBounds(208, 216, 107, 23);
        getContentPane().add(btnGenerateBill);

        JLabel lblNewLabel_1 = new JLabel("Insert Order ID: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(41, 220, 97, 14);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(148, 217, 35, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        setVisible(true);
    }
}
