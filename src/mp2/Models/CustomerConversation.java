/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.Models;

import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public class CustomerConversation {
    private static int maxId = -1;
    private int id = createId(); // unique // CreateUniqueNumber;
    private int markUpperBound = 5,
                markBottomBound = 1;
    private int markServiceQuality;
    private int conversationLengthInSeconds; // długość rozmowy
    private LocalDateTime startDateTime = LocalDateTime.now();
    private Receptionist receptionist;

    public CustomerConversation(int markServiceQuality, int conversationLengthInSeconds, Receptionist receptionist) {
        this.setMarkServiceQuality(markServiceQuality);
        this.setConversationLengthInSeconds(conversationLengthInSeconds);
        this.setReceptionist(receptionist);
    }
    
    private int createId()
    {
        maxId++;
        return maxId;
    }
    
    public int getConversationLengthInSeconds() {
        return conversationLengthInSeconds;
    }

    public void setConversationLengthInSeconds(int conversationLengthInSeconds) {
        this.conversationLengthInSeconds = conversationLengthInSeconds;
    }
    
    public LocalDateTime getEndDateTime()
    {
        LocalDateTime endDateTime = LocalDateTime.of(
                startDateTime.getYear(),
                startDateTime.getMonthValue(),
                startDateTime.getHour(),
                startDateTime.getMinute(),
                startDateTime.getSecond()
        );
        endDateTime.plusSeconds(getConversationLengthInSeconds());
        return endDateTime;
    }
    
    public void setMarkServiceQuality(int mark){
        if (mark > markUpperBound) 
        {
            mark = markUpperBound; 
        }
        else if(mark <= markBottomBound) 
        {
            mark = markBottomBound;
        }

        markServiceQuality = mark;
    }

    public int getId() {
        return id;
    }

    public int getMarkServiceQuality() {
        return markServiceQuality;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    
    private Receptionist getReceptionist()
    {
        return receptionist;
    }
    public void setReceptionist(Receptionist newReceptionist) {
        // Будет ли StackOwerflow, если добавить null, как клиента?
        // Мб, сразу уьрать возможность добавления nnull
//         Ти:if(client.equals(null) || !newClient.equals(null)
//         if(client.equals(null)) { 
        if((getReceptionist() == null) && !(newReceptionist == null)){
            this.receptionist = newReceptionist;
            
            newReceptionist.addCustomerConversation(this);
        }
    }

    @Override
    public String toString() {
        return "Eeee, брат, сделай ToString*( в CustomerConversation";
//        return "CustomerConversation{" + "id=" + id + ", markUpperBound=" + markUpperBound + ", markBottomBound=" + markBottomBound + ", markServiceQuality=" + markServiceQuality + ", conversationLengthInSeconds=" + conversationLengthInSeconds + ", startDateTime=" + startDateTime + ", receptionist=" + receptionist + '}';
    }
    
    
}
