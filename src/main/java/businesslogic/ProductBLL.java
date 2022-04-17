package businesslogic;

import dao.ProductDAO;
import model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ProductBLL {
    /**
     * An instance for accessing the queries for the products
     */
    private ProductDAO productDAO;

    public ProductBLL(){
        productDAO = new ProductDAO();
    }

    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            JOptionPane.showMessageDialog(null, "The product with id = " + id + " was not found!");
        }
        return product;
    }

    public List<Product> findAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        allProducts = productDAO.findAll();

        if(allProducts.isEmpty()){
            JOptionPane.showMessageDialog(null, "No products in the database");
        }

        return allProducts;
    }

    public void insertProduct(int id, String name, Double price, int quantity, String unit){
        if(id <= 0 || price <= 0 || quantity < 0){
            JOptionPane.showMessageDialog(null, "ERROR! (Negative id, price or quantity for the new product)");
        }
        else{
            productDAO.insert(id, name, price, quantity, unit);
            JOptionPane.showMessageDialog(null, "Success!");
        }
    }

    public void deleteProduct(String name){
        productDAO.delete(name);
        JOptionPane.showMessageDialog(null, "Success!");
    }

    public void updateProduct(int id, String name, Double price, int quantity, String unit) {
        if(id <= 0 || price <= 0 || quantity < 0){
            JOptionPane.showMessageDialog(null, "ERROR! (Negative id, price or quantity for the updated product)");
        }
        else{
            productDAO.update(id, name, price, quantity, unit);
            JOptionPane.showMessageDialog(null, "Success!");
        }
    }


}
