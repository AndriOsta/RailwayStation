/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.objects;

import java.util.Calendar;
import ua.andriosta.projects.directory_objects.Place;

/**
 *
 * @author Admin
 */
public class Reservation {
    
    private long id;
    private Flight flight;
    private Place place;
    private Passenger passenger;
    private String add_info;
    private Calendar reserve_datatime;
    private String code;

    public Reservation() {
    }

    public Reservation(long id, Flight flight, Place place, Passenger passenger, String info) {
        this.id = id;
        this.flight = flight;
        this.place = place;
        this.passenger = passenger;
        this.add_info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getAddInfo() {
        return add_info;
    }

    public void setInfo(String info) {
        this.add_info = info;
    }

    public void setCode(String code) {
        this.code = code;
    }




    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    public Calendar getReserve_datatime() {
        return reserve_datatime;
    }

    public void setReserve_datatime(Calendar reserve_datatime) {
        this.reserve_datatime = reserve_datatime;
    }

    public String getCode() {
        return code;
    }
    
    


  
    
}
