/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Order { 
    private static int maxId = -1;
    private int id = createId(); // unique // CreateUniqueNumber;
    private Date orderDate = new Date();
    private int quantityPersonsForLiving;
    private String comment; 
   
    private Client client;
    private Receptionist receptionist;
    private List<PaymentRecord> paymentRecordes = new ArrayList<>();
    
    private Order(int quantityPersonsForLiving, String comment) {
        setQuantityPersonsForLiving(quantityPersonsForLiving);
        setComment(comment);
    }
    
    public static Order createOrder(
                            int quantityPersonsForLiving,
                            String comment,
                            double price, 
                            String currency,
                            String apartmentType, 
                            int quantityOfApartmentsType
    )throws Exception{
        Order order = new Order(quantityPersonsForLiving, comment);
        
        order.createPart(price, currency, apartmentType, quantityOfApartmentsType);
        return order;
    }
    private static int createId()
    {
        maxId++;
        return maxId;
    }
    
    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getQuantityPersonsForLiving() {
        return quantityPersonsForLiving;
    }

    public String getComment() {
        return comment;
    }

    public void setQuantityPersonsForLiving(int quantityPersonsForLiving) {
        this.quantityPersonsForLiving = quantityPersonsForLiving;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private Client getClient() {
        return client;
    }

    public PaymentRecord[] getPaymentRecordes() {
        return paymentRecordes.toArray(new PaymentRecord[0]);
    }
    
    
    public String getShortInfo()
    {
        return "Order{" + "id=" + getId() 
               + ", orderDate=" + getOrderDate() 
               + ", quantityPersonsForLiving=" + getQuantityPersonsForLiving() 
               + ", comment=" + getComment();
    }
    
    @Override
    public String toString() {
        String clientInfo = client == null ? "" : client.getShortInfo();
        String receptionistInfo = receptionist == null ? "" : receptionist.getShortInfo();
        String info = getShortInfo() + ", " 
                    + clientInfo + ", "
                    + receptionistInfo + " \n[";
        for(int i = 0; i < paymentRecordes.size(); i++){
            info += paymentRecordes.get(i).getShortInfo() +", ";
            // info += paymentRecordes.get(i).toString() +", ";
        }
        info += "]\n";
        return info;
    }

    public void setClient(Client newClient) {
        if((getClient() == null) && newClient != null){
            this.client = newClient;
            
            newClient.addOrder(this);
        }
    }
    
    public void removeClient(Client clientToRemove) {
        if( this.getClient() != null && this.getClient() == clientToRemove) {
            client = null;
            
            clientToRemove.removeOrder(this);
        }
    }
    
    public void setReceptionistQualif(Receptionist newReceptionist) {
        if((getReceptionistQualif()== null) && newReceptionist != null){
            this.receptionist = newReceptionist;
            
            newReceptionist.addOrderQualif(this);
        }
    }
    
    public void removeReceptionistQualif(Receptionist receptionistToRemove) {
        if( this.getReceptionistQualif() != null
            &&
            this.getReceptionistQualif() == receptionistToRemove
        ) {
            this.receptionist = null;
     
            receptionistToRemove.removeOrderQualif(this);
        }
    }
    public Receptionist getReceptionistQualif() {
        return this.receptionist;
    }
    
    public PaymentRecord createPart(double price, String currency, 
                                    String apartmentType, 
                                    int quantityOfApartmentsType
    ) throws Exception {
        
        PaymentRecord paymentRecord = new PaymentRecord(
                price,
                currency,
                apartmentType,
                quantityOfApartmentsType,
                this
        ); 
        if(paymentRecordes.contains(paymentRecord)){
            throw new Exception("Can't be created two equal PaymentRecord in the same Order.");
        }
        paymentRecordes.add(paymentRecord);
        return paymentRecord;
    }

    public class PaymentRecord {
        private Order order;
        private double price;
        private String currency;   
        private String apartmentType;
        private int quantityOfApartmentsType;

        public PaymentRecord(double price, String currency, String apartmentType, int quantityOfApartmentsType, Order order) {
            this.setOrder(order);
            this.setPrice(price);
            this.setCurrency(currency);
            this.setApartmentType(apartmentType);
            this.setQuantityOfApartmentsType(quantityOfApartmentsType);
        }

        public Order getOrder() {
            return order;
        }

        private void setOrder(Order order) {
            if(order == null) throw new NullPointerException("Payment Record can\'t be created without Order. ");
            this.order = order;
        }
        
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getApartmentType() {
            return apartmentType;
        }

        public void setApartmentType(String apartmentType) {
            this.apartmentType = apartmentType;
        }

        public int getQuantityOfApartmentsType() {
            return quantityOfApartmentsType;
        }

        public void setQuantityOfApartmentsType(int quantityOfApartmentsType) {
            this.quantityOfApartmentsType = quantityOfApartmentsType;
        }
        
        
        
        public String getShortInfo(){
            return "PaymentRecord{" + "price=" + price + ", currency=" + currency + ", apartmentType=" + apartmentType + ", quantityOfApartmentsType=" + quantityOfApartmentsType + '}'; 
        }
        
        @Override
        public String toString() {
            return "PaymentRecord{" + "price=" + price + ", currency=" + currency + ", apartmentType=" + apartmentType + ", quantityOfApartmentsType=" + quantityOfApartmentsType +", Order=" + this.getOrder().getShortInfo() +'}';
        }

        
        @Override
        public boolean equals(Object obj) {            
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            PaymentRecord paymentRecord = (PaymentRecord) obj;
            return this.getOrder().equals(paymentRecord.getOrder()) &&
                this.getPrice() == paymentRecord.getPrice() &&
                this.getCurrency().equals(paymentRecord.getCurrency()) && 
                this.getApartmentType().equals(paymentRecord.getApartmentType()) &&
                this.getQuantityOfApartmentsType() == paymentRecord.getQuantityOfApartmentsType();
        }
    }
}
