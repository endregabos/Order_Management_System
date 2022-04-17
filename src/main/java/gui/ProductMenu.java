package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ProductMenu extends JFrame {
    public ProductMenu(){
        setTitle("Menu - Products");
        setBounds(100, 100, 375, 384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnProductsInsert = new JButton("Insert");
        btnProductsInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertProductView newProduct = new InsertProductView();

                setVisible(false);
            }
        });
        btnProductsInsert.setBounds(128, 62, 107, 42);
        getContentPane().add(btnProductsInsert);

        JButton btnProductsDelete = new JButton("Delete");
        btnProductsDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteProductView deleteProduct = new DeleteProductView();

                setVisible(false);
            }
        });
        btnProductsDelete.setBounds(128, 115, 107, 42);
        getContentPane().add(btnProductsDelete);

        JLabel lblNewLabel = new JLabel("Products - Operations");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(91, 11, 183, 23);
        getContentPane().add(lblNewLabel);

        JButton btnProductsEdit = new JButton("Edit");
        btnProductsEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateProductView updateProduct = new UpdateProductView();

                setVisible(false);
            }
        });
        btnProductsEdit.setBounds(128, 168, 107, 42);
        getContentPane().add(btnProductsEdit);

        JButton btnProductsView = new JButton("View Products");
        btnProductsView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllProductsView allProductsView = new AllProductsView();

                setVisible(false);
            }
        });
        btnProductsView.setBounds(121, 221, 120, 42);
        getContentPane().add(btnProductsView);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();

                setVisible(false);
            }
        });
        btnBack.setBounds(260, 311, 89, 23);
        getContentPane().add(btnBack);

        setVisible(true);
    }
}
