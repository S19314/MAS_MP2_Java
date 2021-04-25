package mp2.Models;

import java.util.ArrayList;
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
    
    public 
    
    
}
