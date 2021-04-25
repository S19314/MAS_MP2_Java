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
    
    
    
    // 1. Сделать так же для Client
    // 2. Затетисть всё позже
    // 3. ... хз
    @Override
    public String toString() {
        return  "Сделай ToSting() в Order, PLS)";
        /*
        StringBuilder stringBuilder = new StringBuilder("Office{" + "numberOffice=" + numberOffice + ", address=" + address + ", persons={\n");
        for(int i = 0; i < persons.size(); i++){
            Client person = persons.get(i);
            stringBuilder.append("Index: " + i + "; firstName: " + person.getFirstName() + "; secondName: " + person.getSecondName() +'\n');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
        */
    }
    
    public void addClient(Client newClient) {
        // Будет ли StackOwerflow, если добавить null, как клиента?
        // Мб, сразу уьрать возможность добавления nnull
//         Ти: if(client.equals(null) || !newClient.equals(null)
        if(client.equals(null)) { 
            setClient(newClient);
            
            newClient.addOrder(this);
        }
    }
}
