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
public class Place {
    
    private long id;
    private char row;
    private int seat;
    private FlightClass flightClass;
    private boolean busy;

    public Place() {
    }

    public Place(long id, char row, int seat, FlightClass flightClass) {
        this.id = id;
        this.row = row;
        this.seat = seat;
        this.flightClass = flightClass;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return busy;
    }
    
    
    
    
    
}
