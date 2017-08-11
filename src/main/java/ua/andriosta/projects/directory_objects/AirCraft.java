/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.directory_objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AirCraft {
    
  private  long id;
  private  String name;
  private  List<Place> placeList;
  private  Company company;

    public AirCraft() {
    }

    public AirCraft(long id, String name, List<Place> placeList, Company company) {
        this.id = id;
        this.name = name;
        this.placeList = placeList;
        this.company = company;
    }

    
  
  
  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
  
  
  
    
}
