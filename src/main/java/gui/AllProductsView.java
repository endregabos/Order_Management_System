package gui;

import businesslogic.ProductBLL;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class AllProductsView extends JFrame {
    /**
     * An instance of a JTable to show the data from the database
     */
    private JTable table;

    public AllProductsView() {
        setTitle("All Products");
        setBounds(100, 100, 617, 407);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("=  Products  =");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(198, 11, 224, 23);
        getContentPane().add(lblNewLabel);

        table = new JTable();

        //Folosim reflexion technique pt a genera capul tabelului
        Class reflectClass = Product.class;
        Field[] classFields = reflectClass.getDeclaredFields();

        Object[] columns = new Object[5];
        for(int i=0;i<classFields.length;i++){
            columns[i] = classFields[i].getName();
        }

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setBounds(10, 47, 581, 268);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 47, 581, 268);
        getContentPane().add(pane);

        //populam tabela
        Object[] row = new Object[5];
        List<Product> allProducts = new ArrayList<>();
        ProductBLL productBLL = new ProductBLL();

        allProducts = productBLL.findAllProducts();
        for(int i=0;i<allProducts.size();i++){
            row[0] = allProducts.get(i).getIdProduct();
            row[1] = allProducts.get(i).getProductName();
            row[2] = allProducts.get(i).getProductPrice();
            row[3] = allProducts.get(i).getProductQuantity();
            row[4] = allProducts.get(i).getProductUnit();
            model.addRow(row);
        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductMenu productMenu = new ProductMenu();

                setVisible(false);
            }
        });
        btnNewButton.setBounds(253, 334, 89, 23);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }
}
