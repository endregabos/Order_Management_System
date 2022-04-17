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
public class DeleteProductView extends JFrame{
    /**
     * The id for the deleted product
     */
    private JTextField textField_1;

    public DeleteProductView() {
        setTitle("Delete Product");
        setBounds(100, 100, 375, 319);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Delete Product");
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

        JLabel lblNewLabel_1_1 = new JLabel("Product Name: ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1_1.setBounds(55, 96, 97, 14);
        getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(162, 93, 134, 20);
        getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("DELETE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!textField_1.getText().equals("")){
                    ProductBLL productBLL = new ProductBLL();
                    productBLL.deleteProduct(textField_1.getText());

                    textField_1.setText("");
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
