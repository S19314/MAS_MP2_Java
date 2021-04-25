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
    private Client client;
            
    private CustomerConversation(
            int markServiceQuality, 
            int conversationLengthInSeconds,
            Receptionist receptionist, 
            Client client) {
        this.setMarkServiceQuality(markServiceQuality);
        this.setConversationLengthInSeconds(conversationLengthInSeconds);
        this.setReceptionist(receptionist);
        this.setClient(client);
    }
    
    public static CustomerConversation createCustomerConversation (
            int markServiceQuality, 
            int conversationLengthInSeconds,
            Receptionist receptionist, 
            Client client
    ) throws Exception {
        if(client == null){
            throw new Exception("Client is null. CustomerConversation can't be created.");
        }
        
        if(receptionist == null){
            throw new Exception("Receptionist is null. CustomerConversation can't be created.");
        }
        
       CustomerConversation conversation = new CustomerConversation(
            markServiceQuality, 
            conversationLengthInSeconds,
            receptionist, 
            client);
       return conversation;
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
                startDateTime.getDayOfMonth(),
                startDateTime.getHour(),
                startDateTime.getMinute(),
                startDateTime.getSecond()
        );
        endDateTime = endDateTime.plusSeconds(getConversationLengthInSeconds());
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
        if((getReceptionist() == null) && !(newReceptionist == null)){
            this.receptionist = newReceptionist;
            
            newReceptionist.addCustomerConversation(this);
        }
    }
    public void removeReception(Receptionist receptionistToRemove){
        if( getReceptionist() != null && getReceptionist() == receptionistToRemove) {
            receptionist = null;
            
            receptionistToRemove.removeCustomerConversation(this);
        }
    }
    
    
    private Client getClient()
    {
        return client;
    }
    public void setClient(Client newClient) {
        if((getClient() == null) && !(newClient == null)){
            this.client = newClient;
            
            newClient.addCustomerConversation(this);
        }
    }
    
    public void removeClient(Client clientToRemove){
        if( getClient() != null && getClient() == clientToRemove) {
            client = null;
            
            clientToRemove.removeCustomerConversation(this);
        }
    }
    
    
    
    public String getShortInfo(){
        return "CustomerConversation{" 
                + "id=" + getId() 
                + ", markServiceQuality=" + getMarkServiceQuality() 
                + ", conversationLengthInSeconds=" + getConversationLengthInSeconds()
                + ", startDateTime=" + getStartDateTime()
                + ", endDateTime=" + getEndDateTime()
                + '}';
    }

    @Override
    public String toString() {
        String baseMessage = getShortInfo() + ", " 
                + client.getShortInfo() + ", " 
                + receptionist.getShortInfo() + ".";
        return baseMessage;
    }
    
    
}
