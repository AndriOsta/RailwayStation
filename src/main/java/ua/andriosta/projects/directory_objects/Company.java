/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.directory_objects;

/**
 *
 * @author Admin
 */
public class Company {

    
    private long id;
    private String name;
    private String descr;

    public Company() {
    }

    public Company(long id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
   
    
    
    
}
