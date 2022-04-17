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
public class NewOrderView extends JFrame {
    /**
     * Field for the id of the new order
     */
    private JTextField textField; //idOrder
    /**
     * Field for the id of the client
     */
    private JTextField textField_1; //idClient
    /**
     * Field for the id of the product
     */
    private JTextField textField_2; //idProduct
    /**
     * Field for the ordered quantity
     */
    private JTextField textField_3; //orderQuantity

    public NewOrderView() {
        setTitle("Insert New Order");
        setBounds(100, 100, 375, 319);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Insert New Order");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(72, 11, 224, 23);
        getContentPane().add(lblNewLabel);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderMenu orderMenu = new OrderMenu();

                setVisible(false);
            }
        });
        btnBack.setBounds(260, 248, 89, 23);
        getContentPane().add(btnBack);

        JLabel lblNewLabel_1 = new JLabel("Order ID: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(55, 65, 97, 14);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(162, 62, 35, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Client ID: ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_1.setBounds(55, 96, 97, 14);
        getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(162, 93, 35, 20);
        getContentPane().add(textField_1);

        JLabel lblNewLabel_1_2 = new JLabel("Product ID: ");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_2.setBounds(55, 124, 97, 14);
        getContentPane().add(lblNewLabel_1_2);

        textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(162, 121, 35, 20);
        getContentPane().add(textField_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("Order Quantity: ");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_2_1.setBounds(55, 152, 97, 14);
        getContentPane().add(lblNewLabel_1_2_1);

        textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setColumns(10);
        textField_3.setBounds(162, 149, 60, 20);
        getContentPane().add(textField_3);

        JButton btnNewButton = new JButton("CREATE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Validam datele de intrare
                if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("") && !textField_3.getText().equals("")){
                    String textID = textField.getText();
                    int id = Integer.parseInt(textID);
                    OrderBLL orderBLL = new OrderBLL();
                    orderBLL.insertNewOrder(id, Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));

                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty Fields!");
                }
            }
        });
        btnNewButton.setBounds(128, 198, 103, 30);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }
}
