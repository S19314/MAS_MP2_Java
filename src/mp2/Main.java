/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2;

import mp2.Models.Order;
import mp2.Models.Client;
import mp2.Models.CustomerConversation;
import mp2.Models.Receptionist;

/**
 *
 * @author S19314
 */
public class Main {

    public static void main(String[] args) {
        Client client1 = new Client("Nodzu", "Mitycura", "SL4055855", "+238974312");
        Client client2 = new Client("Nikolaj", "Lisicyn", "VT214124", "+214125415");
        Order order1 = new Order(2, "");
        Order order2 = new Order(5, "Pokój z widokiem na morze.");
//      Asocjacja zwykla DOWN
        client1.addOrder(order2);
        client1.addOrder(null); // funkcja flitruje null
        order1.setClient(null); // funkcja flitruje null
        order1.setClient(client2);
        order1.setClient(client2); // Test: Try to add second time. 
        // Ale nie dodadaje 'client2' - jak i powinno, bo już jest dodany.
        order1.setClient(client1);
        System.out.println("Info: ");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(client1);
        System.out.println(client2);
    //      Asocjacja zwykla UP
    //      Asocjacja z atrybutem DOWN
        
        Receptionist receptionist1 = new Receptionist(
                "Grzegorz",
                "Tuskin", 
                Receptionist.WorkShift.Dzienna,
                new String[]{"Polski"}
                ),
                receptionist2 = new Receptionist(
                "William",
                "Shakespeare", 
                Receptionist.WorkShift.Nocna,
                new String[]{"English", "Japanese"}
                );
        
        // А если будет null, как obj?
        // Создать метод который выбрасывает ошибку,
        // если один из obj - null.
        CustomerConversation customerConversation1 = null,
                customerConversation2 = null;
        try {
            customerConversation1 =
                CustomerConversation.createCustomerConversation(
                3,
                2000, 
                receptionist1,
                client2);       
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            customerConversation2 =
                CustomerConversation.createCustomerConversation(
                4,
                3000,
                receptionist1,
                client1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        CustomerConversation customerConversationNull = null;
        try {
            customerConversationNull =
                CustomerConversation.createCustomerConversation(
                4,
                3000,
                null,
                null
                );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(receptionist1);
        System.out.println(receptionist2);
        System.out.println(customerConversation1);
        System.out.println(customerConversation2);
        System.out.println(customerConversationNull);
        
    //      Asocjacja z atrybutem UP
    }
    
}
