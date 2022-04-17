package businesslogic;

import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class ClientBLL {
    /**
     * An instance for accessing the queries for the clients
     */
    private ClientDAO clientDAO;

    private static final String NAME_PATTERN = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$"; // ex. Firstname Lastname
    private static final String EMAIL_PATTERN = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}$"; // ex. name@gmail.com

    public ClientBLL(){
        clientDAO = new ClientDAO();
    }

    public boolean validateName(Client cl) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if (!pattern.matcher(cl.getClientName()).matches()) {
            return false;
        }
        return true;
    }

    public boolean validateEmail(Client cl) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher(cl.getClientEmail()).matches()) {
            return false;
        }
        return true;
    }

    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "The client with id = " + id + " was not found!");
        }
        return client;
    }

    public List<Client> findAllClients() {
        List<Client> allClients = new ArrayList<Client>();
        allClients = clientDAO.findAll();

        if(allClients.isEmpty()){
            JOptionPane.showMessageDialog(null, "No clients in the database");
        }

        return allClients;
    }

    public void insertClient(int id, String name, String address, String email){
        Client clNou = new Client(id, name, address, email);
        if(validateName(clNou) && validateEmail(clNou)){
            clientDAO.insert(id, name, address, email);
            JOptionPane.showMessageDialog(null, "Success!");
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR! (Incorrect Name or Email for the client)");
        }
    }

    public void deleteClient(String name){
        clientDAO.delete(name);
        JOptionPane.showMessageDialog(null, "Success!");
    }

    public void updateClient(int id, String name, String address, String email) {
        clientDAO.update(id, name, address, email);
        JOptionPane.showMessageDialog(null, "Success!");
    }

}
