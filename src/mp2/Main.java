/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2;

import mp2.Models.Order;
import mp2.Models.Client;

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
    }
    
}
