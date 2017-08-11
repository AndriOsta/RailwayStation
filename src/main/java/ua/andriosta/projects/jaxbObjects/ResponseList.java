/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.jaxbObjects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ua.andriosta.projects.directory_objects.City;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList {
    
    private List<City> cities;

    public ResponseList() {
    }

    public List<City> getCities() {
        return cities;
    }
   @XmlElement(name ="city")
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    
    
    
}
