package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ClientMenu extends JFrame {
    public ClientMenu(){
        setTitle("Menu - Clients");
        setBounds(100, 100, 375, 384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnClientsInsert = new JButton("Insert");
        btnClientsInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertClientView newClient = new InsertClientView();

                setVisible(false);
            }
        });
        btnClientsInsert.setBounds(128, 62, 107, 42);
        getContentPane().add(btnClientsInsert);

        JButton btnClientsDelete = new JButton("Delete");
        btnClientsDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteClientView deleteClient = new DeleteClientView();

                setVisible(false);
            }
        });
        btnClientsDelete.setBounds(128, 115, 107, 42);
        getContentPane().add(btnClientsDelete);

        JLabel lblNewLabel = new JLabel("Clients - Operations");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(91, 11, 183, 23);
        getContentPane().add(lblNewLabel);

        JButton btnClientsEdit = new JButton("Edit");
        btnClientsEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateClientView updateClient = new UpdateClientView();

                setVisible(false);
            }
        });
        btnClientsEdit.setBounds(128, 168, 107, 42);
        getContentPane().add(btnClientsEdit);

        JButton btnClientsView = new JButton("View Clients");
        btnClientsView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllClientsView allClients = new AllClientsView();

                setVisible(false);
            }
        });
        btnClientsView.setBounds(128, 221, 107, 42);
        getContentPane().add(btnClientsView);

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
