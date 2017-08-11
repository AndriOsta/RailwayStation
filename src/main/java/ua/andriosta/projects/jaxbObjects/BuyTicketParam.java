/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.jaxbObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.objects.Flight;
import ua.andriosta.projects.objects.Passenger;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BuyTicketParam {
    
    
     private long flightid; 
     private long placeid;
     private Passenger passenger;
     private String addInfo;

    public BuyTicketParam() {
    }

     
     
    public long getFlightid() {
        return flightid;
    }

    public void setFlightid(long flightid) {
        this.flightid = flightid;
    }

    public long getPlaceid() {
        return placeid;
    }

    public void setPlaceid(long placeid) {
        this.placeid = placeid;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

   
   

    
     
     
     
     
     
    
}
