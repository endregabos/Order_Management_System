package gui;

import businesslogic.OrderBLL;
import model.Order;

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
public class AllOrdersView extends JFrame {
    /**
     * An instance of a JTable to show the data from the database
     */
    private JTable table;

    public AllOrdersView() {
        setTitle("All Orders");
        setBounds(100, 100, 617, 407);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("=  Orders  =");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(198, 11, 224, 23);
        getContentPane().add(lblNewLabel);

        table = new JTable();

        //Folosim reflexion technique pt a genera capul tabelului
        Class reflectClass = Order.class;
        Field[] classFields = reflectClass.getDeclaredFields();

        Object[] columns = new Object[6];
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
        Object[] row = new Object[6];
        List<Order> allOrders = new ArrayList<>();
        OrderBLL orderBLL = new OrderBLL();

        allOrders = orderBLL.findAllOrders();
        for(int i=0;i<allOrders.size();i++){
            row[0] = allOrders.get(i).getIdOrder();
            row[1] = allOrders.get(i).getIdClient();
            row[2] = allOrders.get(i).getIdProduct();
            row[3] = allOrders.get(i).getOrderPricePerUnit();
            row[4] = allOrders.get(i).getOrderQuantity();
            row[5] = allOrders.get(i).getOrderTotal();

            model.addRow(row);

        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderMenu orderMenu = new OrderMenu();

                setVisible(false);
            }
        });
        btnNewButton.setBounds(253, 334, 89, 23);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }
}
