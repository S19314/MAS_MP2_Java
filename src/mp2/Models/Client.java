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

    @Override
    public String toString(){
        return  "Сделай ToSting() в Client, PLS)";
        /*
        StringBuilder stringBuilder = new StringBuilder("Person{" + "firstName=" + firstName + ", secondName=" + secondName + ", offices={\n" );
        for(int i = 0; i < orders.size(); i++){
            Order office = orders.get(i);
            stringBuilder.append("Index: " + i + "; address: " + office.getAddress()+ "; numberOffice: " + office.getNumberOffice() +'\n');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
        */
    }
    
    public void addOrder(Order newOrder) {
        if(!orders.contains(newOrder)) { 
            orders.add(newOrder);

            newOrder.addPerson(this);
        }
    }
}
