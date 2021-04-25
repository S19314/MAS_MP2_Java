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
public class Person {
    private String firstName;
    private String secondName;
    
    private List<Office> offices = new ArrayList<Office>();

    public Person(String firstName, String secondName) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Person{" + "firstName=" + firstName + ", secondName=" + secondName + ", offices={\n" );
        for(int i = 0; i < offices.size(); i++){
            Office office = offices.get(i);
            stringBuilder.append("Index: " + i + "; address: " + office.getAddress()+ "; numberOffice: " + office.getNumberOffice() +'\n');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
    
    public void addOffice(Office newOffice) {
        if(!offices.contains(newOffice)) { 
            offices.add(newOffice);

            newOffice.addPerson(this);
        }
    }
}
