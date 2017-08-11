/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.objects;

/**
 *
 * @author Admin
 */
public class Passenger {
    
    private long id;
    private String given_name;
    private String middle_name;
    private String familly_name;
    private String document_number;
    private String email;
    private String phone;

    public Passenger(long id, String given_name, String middle_name, String familly_name, String document_number, String email, String phone) {
        this.id = id;
        this.given_name = given_name;
        this.middle_name = middle_name;
        this.familly_name = familly_name;
        this.document_number = document_number;
        this.email = email;
        this.phone = phone;
    }

    public Passenger() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFamilly_name() {
        return familly_name;
    }

    public void setFamilly_name(String familly_name) {
        this.familly_name = familly_name;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
    
}
