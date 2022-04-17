package model;

/**
 * @Author: Gabos Mihaly-Endre
 * @Since: May 26, 2021
 */
public class Client {
    /**
     * The ID of a Client
     */
    private int idClient;
    /**
     * The Name of a Client
     */
    private String clientName;
    /**
     * The Address of a Client
     */
    private String clientAddress;
    /**
     * The Email of a Client
     */
    private String clientEmail;

    public Client(){
    }

    public Client(int idClient, String clientName, String clientAddress, String clientEmail) {
        super();
        this.idClient = idClient;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }


    public String getClientEmail() {
        return clientEmail;
    }

    @Override
    public String toString() {
        return String.format(idClient + " " + clientName + " " + clientAddress + " " + clientEmail);
    }

}
