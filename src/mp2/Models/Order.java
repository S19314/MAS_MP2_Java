/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private Receptionist receptionist;
    
    public Order(int quantityPersonsForLiving, String comment) {
        setQuantityPersonsForLiving(quantityPersonsForLiving);
        setComment(comment);
    }
    
    private static int createId()
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

    public void setClient(Client newClient) {
        if((getClient() == null) && newClient != null){
            this.client = newClient;
            
            newClient.addOrder(this);
        }
    }
    
    public void removeClient(Client clientToRemove) {
        if( this.getClient() != null && this.getClient() == clientToRemove) {
            client = null;
            
            clientToRemove.removeOrder(this);
        }
    }
    
    public void setReceptionistQualif(Receptionist newReceptionist) {
        if((getReceptionistQualif()== null) && newReceptionist != null){
            this.receptionist = newReceptionist;
            
            newReceptionist.addOrderQualif(this);
        }
    }
    
    public void removeReceptionistQualif(Receptionist receptionistToRemove) {
        if( this.getReceptionistQualif() != null
            &&
            this.getReceptionistQualif() == receptionistToRemove
        ) {
            this.receptionist = null;
     
            receptionistToRemove.removeOrderQualif(this);
        }
    }
    public Receptionist getReceptionistQualif() {
        return this.receptionist;
    }
}
