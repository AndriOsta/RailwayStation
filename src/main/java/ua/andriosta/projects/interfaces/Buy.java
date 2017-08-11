/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces;

import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.objects.Flight;
import ua.andriosta.projects.objects.Passenger;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */
public interface Buy {
    
    long buyTicket(Long flightid, Long placeid,Passenger passenger,String addInfo);
    
}
