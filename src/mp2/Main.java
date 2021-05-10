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
        
        // 4. Kompozycja jest stworzona w Order.
        Order order1 = null;
        Order order2 = null;
        System.out.println("Info: ");
        try {
            order1 = Order.createOrder(2, "", 3000.0, "USD", "Luksus", 3);
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            System.out.println(e.getMessage()); 
            /* Kożystam z "out", a nie z "err" tylko dla prezentacji,
            żeby łatwiej obejrzeć sekwencje wykonania programu.
            */
        }
        
        try {
            order2 = Order.createOrder(
                5,
                "Pokój z widokiem na morze.",
                6000.4,
                "EUR",
                "Luksus",
                2);
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            System.out.println(e.getMessage()); 
            /* Kożystam z "out", a nie z "err" tylko dla prezentacji,
            żeby łatwiej obejrzeć sekwencje wykonania programu.
            */
        }
        try{
            Order.PaymentRecord pr = order1.createPart(1000, "YAN", "Standart", 1);
            System.out.println("Created PaymentRecord: " + pr);
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            System.out.println(e.getMessage()); 
            /* Kożystam z "out", a nie z "err" tylko dla prezentacji,
            żeby łatwiej obejrzeć sekwencje wykonania programu.
            */
        }
        
        try{
            Order.PaymentRecord pr = order1.createPart(1000, "YAN", "Standart", 1);
            System.out.println("Created PaymentRecord: " + pr);
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            System.out.println("EXPECTED_EXCEPTION. Two equal PaymentRecord in on order: " + e.getMessage()); 
            /* Kożystam z "out", a nie z "err" tylko dla prezentacji,
            żeby łatwiej obejrzeć sekwencje wykonania programu.
            */
        }
        
        
        try{
            Order.PaymentRecord paymentRecord232 = order1.new PaymentRecord(1000, "YAN", "Standart", 1, null);
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            System.out.println("EXPECTED_EXCEPTION. Order is null: " + e.getMessage()); 
            /* Kożystam z "out", a nie z "err" tylko dla prezentacji,
            żeby łatwiej obejrzeć sekwencje wykonania programu.
            */
        }
        
        showOrderInfo(order1);
        showOrderFromPaymentRecordes(order1);
        showOrderInfo(order2);
        showOrderFromPaymentRecordes(order2);
        
//      1. Asocjacja zwykla DOWN
        
        client1.addOrder(order2);
        client1.addOrder(null); // funkcja flitruje null
        order1.setClient(null); // funkcja flitruje null
        order1.setClient(client2);
        order1.setClient(client2); // Test: Try to add second time. 
        // Ale nie dodadaje 'client2' - jak i powinno, bo już jest dodany.
        order1.setClient(client1);
        
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(client1);
        System.out.println(client2);
    //      Asocjacja zwykla UP
        //      2. Asocjacja z atrybutem DOWN
        
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
        
    //  3.  Asocjacja kwalifikowana DOWN
        order1.setReceptionistQualif(receptionist2);
        System.out.println(order1);
        System.out.println(receptionist2);
    //      Asocjacja kwalifikowana UP   
    }
    
    public static void showOrderFromPaymentRecordes(Order order) {
        System.out.println("START showOrderFromPaymentRecordes");
        Order.PaymentRecord[] records =  order.getPaymentRecordes();
        for(Order.PaymentRecord paymentRecord : records){
            System.out.println(paymentRecord);
        }
        System.out.println("END showOrderFromPaymentRecordes");
    }
    
    public static void showOrderInfo(Order order) {
        System.out.println("START showOrderInfo");
        System.out.println(order);
        System.out.println("END showOrderInfo");
    }
    
}
