package dao;

import dbconnection.DBConnection;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ClientDAO {
    /**
     * An ArrayList to store in all the clients from the database
     */
    private List<Client> list = new ArrayList<Client>(); //pentru select *

    public ClientDAO(){};

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM order_management.client WHERE " + field + " = ?");
        return sb.toString();
    }

    public Client findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("idClient");
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id); //inlocuim primul "?" cu id-ul pe care il dam noi
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try {
                while(resultSet.next()) {
                    return new Client(resultSet.getInt(meta.getColumnName(1)), resultSet.getString(meta.getColumnName(2)), resultSet.getString(meta.getColumnName(3)), resultSet.getString(meta.getColumnName(4)));
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

    public List<Client> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM order_management.client");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            try{
                while(resultSet.next()){
                    list.add(new Client(resultSet.getInt(meta.getColumnName(1)), resultSet.getString(meta.getColumnName(2)), resultSet.getString(meta.getColumnName(3)), resultSet.getString(meta.getColumnName(4))));
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

    public void insert(int id, String name, String address, String email){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO order_management.client(idClient, clientName, clientAddress, clientEmail) VALUES (?, ?, ?, ?)");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setString(4, email);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public void update(int id, String name, String address, String email){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE order_management.client SET clientName = ?, clientAddress = ? , clientEmail = ? WHERE idClient = ?");
        String query = sb.toString();

        try{
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.setInt(4, id);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public void delete(String name) { //facem stergerea unui client dupa nume
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM order_management.client WHERE clientName = ?");
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

    public String buyerDetails(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT clientName FROM order_management.client WHERE idClient = ?");
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
