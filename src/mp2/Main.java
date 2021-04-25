/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2;

import mp2.Models.Office;
import mp2.Models.Person;

/**
 *
 * @author S19314
 */
public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Nodzu", "Mitycura"),
               person2 = new Person("Nikolaj", "Lisicyn");
        Office office1 = new Office(12, "4551 Airport Rd, Riverton, WY 82501, USA"),
               office2 = new Office(35, "1501 N Poplar St, Casper, WY 82601, USA");;
               
        person1.addOffice(office2);
        office1.addPerson(person2);
        office1.addPerson(person2); // Test: Try to add second time. 
        // Ale nie dodadaje 'person2' - jak i powinno.
        office1.addPerson(person1);
        System.out.println("Info: ");
        System.out.println(office1);
        System.out.println(office2);
        System.out.println(person1);
        System.out.println(person2);
    }
    
}
