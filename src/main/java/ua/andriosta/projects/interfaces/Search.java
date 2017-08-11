/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces;

import java.util.Date;
import java.util.List;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.objects.Flight;

/**
 *
 * @author Admin
 */
public interface Search {
    
  List<Flight>searchFlight(Long date, Long cityFrorm, Long cityTo);
 
  List<City>getAllCities();
  
  List<Flight>getAllFlights();
  
  List<Place> getAllPlacesByAircraft(Long aircraftid);
  
    
}
