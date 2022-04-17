package dao;

import dbconnection.DBConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ProductDAO {
    /**
     * An ArrayList to store in all the products from the database
     */
    private List<Product> list = new ArrayList<>();

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM order_management.product WHERE " + field + " = ?");
        return sb.toString();
    }

    public Product findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("idProduct");
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id); //inlocuim primul "?" cu id-ul pe care il dam noi
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try {
                while(resultSet.next()) {
                    return new Product(resultSet.getInt(meta.getColumnName(1)), resultSet.getString(meta.getColumnName(2)), resultSet.getDouble(meta.getColumnName(3)), resultSet.getInt(meta.getColumnName(4)), resultSet.getString(meta.getColumnName(5)));
                }
            } catch (SecurityException | IllegalArgumentException | SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
        return null;
    }

    public List<Product> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM order_management.product");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    list.add(new Product(resultSet.getInt(meta.getColumnName(1)), resultSet.getString(meta.getColumnName(2)), resultSet.getDouble(meta.getColumnName(3)), resultSet.getInt(meta.getColumnName(4)), resultSet.getString(meta.getColumnName(5))));
                }
            } catch (SecurityException | IllegalArgumentException | SQLException e) {
                e.printStackTrace();
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return null;
    }

    public void insert(int id, String name, Double price, int quantity, String unit){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO order_management.product(idProduct, productName, productPrice, productQuantity, productUnit) VALUES (?, ?, ?, ?, ?)");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.setInt(4, quantity);
            statement.setString(5, unit);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public void update(int id, String name, Double price, int quantity, String unit){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE order_management.product SET productName = ?, productPrice = ? , productQuantity = ? , productUnit = ? WHERE idProduct = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.setString(4, unit);
            statement.setInt(5, id);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public void delete(String name) { //facem stergerea unui produs dupa nume
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM order_management.product WHERE productName = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public int availableQuantity(int id){
        int qty = 0;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT productQuantity FROM order_management.product WHERE idProduct = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    qty =  resultSet.getInt(meta.getColumnName(1));
                }
            } catch (SecurityException | IllegalArgumentException | SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return qty;
    }

    public String productDetails(int id){ //returneaza numele produsului ci id-ul 'id'
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT productName FROM order_management.product WHERE idProduct= ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getString(meta.getColumnName(1));
                }
            } catch (SecurityException | IllegalArgumentException | SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return null;
    }
}
