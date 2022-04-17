package gui;

import businesslogic.ClientBLL;
import model.Client;

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
public class AllClientsView extends JFrame {
    /**
     * An instance of a JTable to show the data from the database
     */
    private JTable table;

    public AllClientsView() {
        setTitle("All Clients");
        setBounds(100, 100, 617, 407);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("=  Clients  =");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(198, 11, 224, 23);
        getContentPane().add(lblNewLabel);

        table = new JTable();

        //Folosim reflexion technique pt a genera capul tabelului
        Class reflectClass = Client.class;
        Field[] classFields = reflectClass.getDeclaredFields();

        Object[] columns = new Object[4];
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
        Object[] row = new Object[4];
        List<Client> allClients = new ArrayList<>();
        ClientBLL clientBLL = new ClientBLL();

        allClients = clientBLL.findAllClients();
        for(int i=0;i<allClients.size();i++){
            row[0] = allClients.get(i).getIdClient();
            row[1] = allClients.get(i).getClientName();
            row[2] = allClients.get(i).getClientAddress();
            row[3] = allClients.get(i).getClientEmail();
            model.addRow(row);

        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientMenu clientMenu = new ClientMenu();

                setVisible(false);
            }
        });
        btnNewButton.setBounds(253, 334, 89, 23);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }
}
