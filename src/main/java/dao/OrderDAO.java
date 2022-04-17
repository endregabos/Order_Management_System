package dao;

import dbconnection.DBConnection;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class OrderDAO {
    /**
     * An ArrayList to store in all the orders from the database
     */
    private List<Order> list = new ArrayList<>();

    public List<Order> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM order_management.order");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    list.add(new Order(resultSet.getInt(meta.getColumnName(1)), resultSet.getInt(meta.getColumnName(2)), resultSet.getInt(meta.getColumnName(3)), resultSet.getDouble(meta.getColumnName(4)), resultSet.getInt(meta.getColumnName(5)), resultSet.getDouble(meta.getColumnName(6))));
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

    public void newOrder(int idOrder, int idClient, int idProduct, int quantity){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("call TotalPriceTrigger(?, ?, ?, ?)");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idOrder);
            statement.setInt(2, idClient);
            statement.setInt(3, idProduct);
            statement.setInt(4, quantity);
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

    // Queries for the order bill
    public int orderPayer(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT idClient FROM order_management.order WHERE idOrder = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getInt(meta.getColumnName(1));
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

        return 0;
    }

    public int buyedProduct(int id){ //returneaza id-ul produsului cumparat
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT idProduct FROM order_management.order WHERE idOrder = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getInt(meta.getColumnName(1));
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

        return 0;
    }

    public int orderedQuantity(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT orderQuantity FROM order_management.order WHERE idOrder = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getInt(meta.getColumnName(1));
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

        return 0;
    }

    public double pricePerUnit(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT orderPricePerUnit FROM order_management.order WHERE idOrder = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getDouble(meta.getColumnName(1));
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

        return 0;
    }

    public double totalPrice(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT orderTotal FROM order_management.order WHERE idOrder = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    return resultSet.getDouble(meta.getColumnName(1));
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

        return 0;
    }
}
