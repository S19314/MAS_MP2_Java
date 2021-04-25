package mp2.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author admin
 */
public class Receptionist {
    private String firstName;
    private String secondName;
    private List<String> knowledgeableLanguages = new ArrayList<>();
    public enum WorkShift{
        Dzienna,
        Nocna,
        Dzienna_Nocna, 
        Nocna_Dzienna
        /*
        Jest wykorzystane 'Dzienna_Nocna', a nie 'DziennaNocna'
        Ponieważ, ograniczenie zawiera w sobie jeden z typów w postaci 
        "dzienna-nocna", a nie "dziennanocna" albo "dziennaNocna".
        */
    }
    private String workShift;
    private List<CustomerConversation> customerConversations = new ArrayList<>();
    private Map<Integer, Order> ordersQualificator = new TreeMap<>();
    
    public Receptionist(String firstName, String secondName, WorkShift workShift, String[] knowledgeableLanguages) {
        setFirstName(firstName);
        setSecondName(secondName);
        setWorkShift(workShift);
        this.knowledgeableLanguages = Arrays.asList(knowledgeableLanguages);
    }
    
    public String[] getKnowledgeableLanguages() {
        return this.knowledgeableLanguages.toArray(new String[0]);
    }
    
    public void addKnowledgeableLanguage(String language) 
    {
        knowledgeableLanguages.add(language);
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

    public String getWorkShift() {
        return workShift;
    }
    
    public void setWorkShift(WorkShift workShift) {
        switch(workShift){
            case Dzienna:
                setWorkShift("dzienna");
                break;
            case Nocna:
                setWorkShift("nocna");
                break;
            case Dzienna_Nocna:
                setWorkShift("dzienna-nocna");
                break;
            case Nocna_Dzienna:
                setWorkShift("nocna-dzienna");
                break;
        }
    }
    private void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public String getShortInfo(){
        StringBuilder stringBuilder = new StringBuilder('[');
        for(int i = 0; i < knowledgeableLanguages.size(); i++)
        {
            stringBuilder.append(knowledgeableLanguages.get(i)+", ");
        }
        stringBuilder.append(']');
        return "Receptionist{" + "firstName=" + getFirstName() 
               + ", secondName=" + secondName 
               + ", knowledgeableLanguages=" + stringBuilder.toString()
               + ", workShift=" + workShift;
    }
    @Override
    public String toString() {
        String baseMessage = getShortInfo() + ", CustomerConversations={\n";
        StringBuilder stringBuilder = new StringBuilder(baseMessage);
        for(int i = 0; i < customerConversations.size(); i++){
            CustomerConversation conversation  = customerConversations.get(i);
            String infoOrder =  "Index: " + i + ". "
                                + conversation.getShortInfo() + '\n';
            stringBuilder.append(infoOrder);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
    
    public void addCustomerConversation(CustomerConversation newConversation) {
        if( !(newConversation == null) && !customerConversations.contains(newConversation)) { 
            customerConversations.add(newConversation);

            newConversation.setReceptionist(this);
        }
    }
    
    public void removeCustomerConversation(CustomerConversation conversationToRemove){
        if(customerConversations.contains(conversationToRemove)) {
            customerConversations.remove(conversationToRemove);
            
            conversationToRemove.removeReception(this);
        }
    }
    
    public void addOrderQualif(Order newOrder) {
        if(!ordersQualificator.containsKey(newOrder.getId())) { 
            ordersQualificator.put(newOrder.getId(), newOrder);
            
            newOrder.setReceptionistQualif(this);
        }
    }
    /*
    public void addOrderQualif(Order newOrder) {
        if(!ordersQualificator.containsKey(newOrder.getId())) { 
            ordersQualificator.put(newOrder.getId(), newOrder);
            
            newOrder.setReceptionistQualif(this);
        }
    }
    */
    
    public void removeOrderQualif(Order order){
        if(ordersQualificator.containsKey(order.getId())) {
            ordersQualificator.remove(order.getId());
            order.removeReceptionistQualif(this);
        }
    }
    
    
    
}
