/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Order { 
    private static int maxId = -1;
    private int id = createId(); // unique // CreateUniqueNumber;
    private Date orderDate = new Date();
    private int quantityPersonsForLiving;
    private String comment; 
   
    private Client client;

    public Order(int quantityPersonsForLiving, String comment) {
        setQuantityPersonsForLiving(quantityPersonsForLiving);
        setComment(comment);
    }
    
    private int createId()
    {
        maxId++;
        return maxId;
    }
    
    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getQuantityPersonsForLiving() {
        return quantityPersonsForLiving;
    }

    public String getComment() {
        return comment;
    }

    public void setQuantityPersonsForLiving(int quantityPersonsForLiving) {
        this.quantityPersonsForLiving = quantityPersonsForLiving;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private Client getClient() {
        return client;
    }

    private void setClient(Client client) {
        this.client = client;
    }
    
    @Override
    public String toString() {
        String info = "Order{" + "id=" + getId() + ", orderDate=" 
               + getOrderDate() + ", quantityPersonsForLiving=" 
               + getQuantityPersonsForLiving() + ", comment=" + getComment() 
               + ", client={\n firstName: " + client.getFirstName() 
               + "; secondName: " + client.getSecondName()
               + "; phoneNumber: " + client.getNumberPhone()+ "}}\n";
        return info;
    }

    public void addClient(Client newClient) {
        // Будет ли StackOwerflow, если добавить null, как клиента?
        // Мб, сразу уьрать возможность добавления nnull
//         Ти:if(client.equals(null) || !newClient.equals(null)
//         if(client.equals(null)) { 
        if((getClient() == null) && !(newClient == null)){
            setClient(newClient);
            
            newClient.addOrder(this);
        }
    }
}
