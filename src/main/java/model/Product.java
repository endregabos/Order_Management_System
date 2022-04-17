package model;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class Product {
    /**
     * The ID of a Product
     */
    private int idProduct;
    /**
     * The Name of a Product
     */
    private String productName;
    /**
     * The Price of a Product
     */
    private double productPrice;
    /**
     * The available quantity of a Product
     */
    private int productQuantity;
    /**
     * The Unit of a Product (kg, pcs etc.)
     */
    private String productUnit;

    public Product(){
    }

    public Product(int idProduct, String productName, double productPrice, int productQuantity, String productUnit){
        super();
        this.idProduct = idProduct;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    @Override
    public String toString() {
        return String.format(idProduct + " " + productName + " " + productPrice + " " + productQuantity + " " + productUnit);
    }
}
