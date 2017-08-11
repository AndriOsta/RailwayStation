/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.database.CityDB;
import ua.andriosta.projects.database.FlightDB;
import ua.andriosta.projects.database.PlaceDB;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.grennwitchtime.GreenweachTime;
import ua.andriosta.projects.interfaces.Search;
import ua.andriosta.projects.objects.Flight;

/**
 *
 * @author Admin
 */
public class SearchImplementation implements Search{

        public List<Flight> searchFlight(Long date, Long cityFrorm, Long cityTo) {
        
        ArrayList<Flight>flights=new ArrayList<Flight>();
       
        try {
             Calendar cal=GreenweachTime.getInstance();
        cal.setTimeInMillis(date);
            City cityfrom=CityDB.getInstance().executeObject(CityDB.getInstance().getObjectById(cityFrorm));
             City cityto=CityDB.getInstance().executeObject(CityDB.getInstance().getObjectById(cityTo));
            flights.addAll(FlightDB.getInstance().executeAllObjects(FlightDB.getInstance().getFlightsStmt(cal, cityfrom, cityto)));
        } catch (SQLException ex) {
            Logger.getLogger(SearchImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        return flights;
    } 

    @Override
    public List<City> getAllCities() {
     
        ArrayList<City> cities=new ArrayList<City>();
            try {
                cities=CityDB.getInstance().executeAllObjects(CityDB.getInstance().getAllObjects());
            } catch (SQLException ex) {
                Logger.getLogger(SearchImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       return cities;
              
    }

    @Override
    public List<Place> getAllPlacesByAircraft( Long aircraftid) {
         ArrayList<Place> list=null;
        try {
            list=PlaceDB.getInstance().executeAllObjects(PlaceDB.getInstance().getPlacesPSByAircraft(aircraftid));
        } catch (SQLException ex) {
            Logger.getLogger(SearchImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        return list;
    }

	@Override
	public List<Flight> getAllFlights() {
		  ArrayList<Flight> flights=new ArrayList<Flight>();
          try {
              flights=FlightDB.getInstance().executeAllObjects(FlightDB.getInstance().getAllObjects());
          } catch (SQLException ex) {
              Logger.getLogger(SearchImplementation.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     return flights;
	}

  
        
    }
    

