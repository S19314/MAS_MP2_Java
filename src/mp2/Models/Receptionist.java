package mp2.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class Receptionist {
    private String firstName;
    private String secondName;
    private List<String> knowledgeableLanguages = new ArrayList<>();
    enum WorkShift{
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

    @Override
    public String toString() {
        return "Сделай ToSttring() для Receptionist.";
// return "Receptionist{" + "firstName=" + firstName + ", secondName=" + secondName + ", knowledgeableLanguages=" + knowledgeableLanguages + ", workShift=" + workShift + ", customerConversations=" + customerConversations + '}';
    }
    
    public void addCustomerConversation(CustomerConversation newConversation) {
        if( !(newConversation == null) && !customerConversations.contains(newConversation)) { 
            customerConversations.add(newConversation);

            newConversation.setReceptionist(this);
        }
    }
}
