package model;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class Order {
    /**
     * The ID of an Order
     */
    private int idOrder;
    /**
     * The ID of a Client
     */
    private int idClient;
    /**
     * The ID of a Product
     */
    private int idProduct;
    /**
     * The price/Unit of the product
     */
    private double orderPricePerUnit;
    /**
     * The chosen quantity
     */
    private int orderQuantity;
    /**
     * The total price
     */
    private double orderTotal;

    public Order(){}

    public Order(int idOrder, int idClient, int idProduct, double orderPricePerUnit, int orderQuantity, double orderTotal){
        super();
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.orderPricePerUnit = orderPricePerUnit;
        this.orderQuantity = orderQuantity;
        this.orderTotal = orderTotal;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public double getOrderPricePerUnit() {
        return orderPricePerUnit;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    @Override
    public String toString() {
        return String.format(idOrder + " " + idClient + " " + idProduct + " " + orderPricePerUnit + " " + orderQuantity + " " + orderTotal);
    }
}
