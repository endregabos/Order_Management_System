package businesslogic;

import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;

import javax.swing.*;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class OrderBLL {
    /**
     * An instance for accessing the queries for the orders
     */
    private OrderDAO orderDAO;

    public OrderBLL(){ orderDAO = new OrderDAO();}

    public List<Order> findAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        allOrders = orderDAO.findAll();

        if(allOrders.isEmpty()){
            JOptionPane.showMessageDialog(null, "No orders in the database");
        }

        return allOrders;
    }

    public void insertNewOrder(int idOr, int idCl, int idPr, int qty) {
        ProductDAO prod = new ProductDAO();
        if(idOr <= 0 || idCl <= 0 || idPr <= 0 || qty <= 0){
            JOptionPane.showMessageDialog(null, "Negative data inserted!");
        }
        else{
            if(qty > prod.availableQuantity(idPr)){
                JOptionPane.showMessageDialog(null, "Insufficient quantity!");
            }
            else
            {
                orderDAO.newOrder(idOr, idCl, idPr, qty);
                JOptionPane.showMessageDialog(null, "Success!");
            }
        }
    }

    public void orderBill(int id){
        if(id >= 1){
            try{
                FileWriter bill = new FileWriter("Bill_order_" + id + ".txt", false);
                Date currDate = new Date();
                int buyerId;
                int productId;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                ClientDAO buyer = new ClientDAO();
                ProductDAO productBuyed = new ProductDAO();

                // Aici scriem in fisier detaliile facturarii
                bill.write("Order No. " + id + "\n");
                bill.write("Date: " + formatter.format(currDate) + "\n");

                buyerId = orderDAO.orderPayer(id); //returneaza id-ul cumparatorului
                bill.write("Client: " + buyer.buyerDetails(buyerId) + "\n"); //afisam numele cumparatorului

                productId = orderDAO.buyedProduct(id);
                bill.write("Product: " + productBuyed.productDetails(productId) + "\n" + "\t");

                bill.write(orderDAO.orderedQuantity(id) + " x " + orderDAO.pricePerUnit(id) + " RON" + "\n");
                bill.write("TOTAL PRICE: " + orderDAO.totalPrice(id) + " RON");

                // Aici inchidem fisierul
                bill.close();

                JOptionPane.showMessageDialog(null, "Success!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Negative order ID!");
        }

    }
}
