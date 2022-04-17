package gui;

import businesslogic.ProductBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class InsertProductView extends JFrame {
    /**
     * Field for the id of the inserted product
     */
    private JTextField textField; //id
    /**
     * Field for the name of the inserted product
     */
    private JTextField textField_1; //name
    /**
     * Field for the price of the inserted product
     */
    private JTextField textField_2; //price
    /**
     * Field for the quantity of the inserted product
     */
    private JTextField textField_3; //quantity
    /**
     * Field for the unit of the inserted product
     */
    private JTextField textField_4; //unit

    public InsertProductView() {
        setTitle("Insert New Product");
        setBounds(100, 100, 375, 319);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Insert New Product");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(72, 11, 224, 23);
        getContentPane().add(lblNewLabel);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductMenu productMenu = new ProductMenu();

                setVisible(false);
            }
        });
        btnBack.setBounds(260, 248, 89, 23);
        getContentPane().add(btnBack);

        JLabel lblNewLabel_1 = new JLabel("Product ID: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(55, 65, 97, 14);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(162, 62, 35, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Product Name: ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_1.setBounds(55, 96, 97, 14);
        getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(162, 93, 134, 20);
        getContentPane().add(textField_1);

        JLabel lblNewLabel_1_2 = new JLabel("Product Price: ");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_2.setBounds(55, 124, 97, 14);
        getContentPane().add(lblNewLabel_1_2);

        textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(162, 121, 134, 20);
        getContentPane().add(textField_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("Quantity: ");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_2_1.setBounds(55, 152, 97, 14);
        getContentPane().add(lblNewLabel_1_2_1);

        textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setColumns(10);
        textField_3.setBounds(162, 149, 134, 20);
        getContentPane().add(textField_3);

        JLabel lblNewLabel_3 = new JLabel("Unit: ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(55, 183, 97, 14);
        getContentPane().add(lblNewLabel_3);

        textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setColumns(10);
        textField_4.setBounds(162, 180, 134, 20);
        getContentPane().add(textField_4);

        JButton btnNewButton = new JButton("INSERT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Validam datele de intrare
                if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("") && !textField_3.getText().equals("") && !textField_4.getText().equals("")){
                    String textID = textField.getText();
                    int id = Integer.parseInt(textID);
                    ProductBLL productBLL = new ProductBLL();
                    productBLL.insertProduct(id, textField_1.getText(), Double.parseDouble(textField_2.getText()), Integer.parseInt(textField_3.getText()), textField_4.getText());

                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                    textField_4.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty Fields!");
                }
            }
        });
        btnNewButton.setBounds(128, 210, 103, 30);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }
}
