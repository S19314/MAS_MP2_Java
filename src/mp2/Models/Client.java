/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Client {
    private String firstName;
    private String secondName;
    private String passportDetails;
    private String numberPhone;
    
    private List<Order> orders = new ArrayList<Order>();
    private List<CustomerConversation> customerConversations = new ArrayList<CustomerConversation>();
    
    public Client(String firstName, String secondName, String passportDetails, String numberPhone) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setPassportDetails(passportDetails);
        this.setNumberPhone(numberPhone);
    }
    
    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    public String getShortInfo(){
        return "Client{" + "firstName=" + getFirstName() + 
                ", secondName=" + getSecondName() + ", passportDetails=" 
                + getPassportDetails() + ", numberPhone=" + getNumberPhone();
    }
    
    @Override
    public String toString(){
        String baseMessage = getShortInfo() + ", orders={\n";
        StringBuilder stringBuilder = new StringBuilder(baseMessage);
        for(int i = 0; i < orders.size(); i++){
            Order order = orders.get(i);
            String infoOrder =  "Index: " + i + "Order{ id=" + order.getId() 
                                + ", orderDate=" 
                                + order.getOrderDate() +'\n';
            stringBuilder.append(infoOrder);
        }
        stringBuilder.append("},\n CustomerConversations={\n");
        for(int i = 0; i < customerConversations.size(); i++){
            CustomerConversation conversation  = customerConversations.get(i);
            String infoOrder =  "Index: " + i + ". "
                                + conversation.getShortInfo() + '\n';
            stringBuilder.append(infoOrder);
        }
        stringBuilder.append('}');
        
        return stringBuilder.toString();
    }

    public void addOrder(Order newOrder) {
        if( !(newOrder == null) && !orders.contains(newOrder)) { 
            orders.add(newOrder);

            newOrder.setClient(this);
        }
    }
    
    public void addCustomerConversation(CustomerConversation newConversation) {
        if( !(newConversation == null) && !customerConversations.contains(newConversation)) { 
            customerConversations.add(newConversation);

            newConversation.setClient(this);
        }
    }
}
