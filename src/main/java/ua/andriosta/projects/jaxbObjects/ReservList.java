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
import ua.andriosta.projects.objects.Reservation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ReservList {
    
    private List<Reservation> reservs;

    public ReservList() {
    }

    @XmlElement(name="reserv")
    public void setReservs(List<Reservation> reservs) {
        this.reservs = reservs;
    }

    public List<Reservation> getReservs() {
        return reservs;
    }
    
    
    
}
