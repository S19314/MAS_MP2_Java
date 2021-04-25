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
public class Office { // Biuro
    private int numberOffice;
    private String address; 
    
    private List<Person> persons = new ArrayList<>();
            
            
    public Office(int numberOffice, String address) {
        this.setNumberOffice(numberOffice);
        this.setAddress(address);
    }

    public int getNumberOffice() {
        return numberOffice;
    }

    public void setNumberOffice(int numberOffice) {
        this.numberOffice = numberOffice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    // 1. Сделать так же для особы
    // 2. Затетисть всё позже
    // 3. ... хз
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Office{" + "numberOffice=" + numberOffice + ", address=" + address + ", persons={\n");
        for(int i = 0; i < persons.size(); i++){
            Person person = persons.get(i);
            stringBuilder.append("Index: " + i + "; firstName: " + person.getFirstName() + "; secondName: " + person.getSecondName() +'\n');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
    
    public void addPerson(Person newPerson) {
        if(!persons.contains(newPerson)) { 
            persons.add(newPerson);
            
            newPerson.addOffice(this);
        }
    }
}
