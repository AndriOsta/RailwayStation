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
import ua.andriosta.projects.directory_objects.Place;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class PlaceList {
    
    
    private List<Place> places;

    public PlaceList() {
    }

    public List<Place> getPlaces() {
        return places;
    }
   @XmlElement(name ="place")
    public void setPlaces(List<Place> places) {
        this.places = places;
    }
    
}
