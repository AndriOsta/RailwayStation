/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.objects;

import java.util.Calendar;

import ua.andriosta.projects.directory_objects.AirCraft;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;

/**
 *
 * @author Admin
 */
public class Flight {
    
    private long id;
    private String code;
    private Calendar flight_datedepart;
    private Calendar flight_datecome;
    private AirCraft airCraft;
    private String duration;
    private City cityFrom;
    private City cityTo;
    private boolean existFreePlace;

    public Flight() {
    }

    public Flight(long id, String code, Calendar flight_datedepart, Calendar flight_datecome, AirCraft airCraft,  City cityFrom, City cityTo) {
        this.id = id;
        this.code = code;
        this.flight_datedepart = flight_datedepart;
        this.flight_datecome = flight_datecome;
        this.airCraft = airCraft;
       
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getFlight_date() {
        return flight_datedepart;
    }

    public void setFlight_date(Calendar flight_date) {
        this.flight_datedepart = flight_date;
    }

    public Calendar getFlight_datecome() {
        return flight_datecome;
    }

    public void setFlight_datecome(Calendar flight_time) {
        this.flight_datecome = flight_time;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public void setExistFreePlace(boolean existFreePlace) {
        this.existFreePlace = existFreePlace;
    }

    public boolean isExistFreePlace() {
        return existFreePlace;
    }
    
    private int getFreeCount(Flight flight) {
        int count = 0;
        for (Place place : flight.getAirCraft().getPlaceList()) {
            if (!place.isBusy()) {
                count++;
            }
        }

        return count;
    }
    
    
    
    
}
