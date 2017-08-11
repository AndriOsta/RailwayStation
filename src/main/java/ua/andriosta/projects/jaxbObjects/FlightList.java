/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.jaxbObjects;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ua.andriosta.projects.objects.Flight;



@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class FlightList {
    
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }
   @XmlElement(name ="flight")
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    
    
    
}
