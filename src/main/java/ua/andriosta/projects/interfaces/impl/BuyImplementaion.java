/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.database.FlightDB;
import ua.andriosta.projects.database.PassengerDB;
import ua.andriosta.projects.database.PlaceDB;
import ua.andriosta.projects.database.ReservationDB;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.grennwitchtime.GreenweachTime;
import ua.andriosta.projects.interfaces.Buy;
import ua.andriosta.projects.objects.Flight;
import ua.andriosta.projects.objects.Passenger;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */
public class BuyImplementaion implements Buy{

    
    
    
    private PlaceDB placeDB = PlaceDB.getInstance();
    private FlightDB flightDB = FlightDB.getInstance();
    private ReservationDB reservDB = ReservationDB.getInstance();
    private PassengerDB passengerDB = PassengerDB.getInstance();

    
    @Override
    public long buyTicket(Long flightid, Long placeid,Passenger passenger,String addInfo) {
        
      try {

            Reservation reserv = new Reservation();
            reserv.setAdd_info(addInfo);
            reserv.setCode(UUID.randomUUID().toString());
            reserv.setPassenger(passenger);

            Calendar c = GreenweachTime.getInstance();
            reserv.setReserve_datatime(c);
            
            Flight flight = flightDB.executeObject(flightDB.getObjectById(flightid));
            Place place = placeDB.executeObject(placeDB.getObjectById(placeid));
            
            
            reserv.setPlace(place);
            reserv.setFlight(flight);

            // Р¶РµР»Р°С‚РµР»СЊРЅРѕ СЂРµР°Р»РёР·РѕРІР°С‚СЊ РѕР±Рµ РѕРїРµСЂР°С†РёРё РІ РѕРґРЅРѕР№ С‚СЂР°РЅР·Р°РєС†РёРё
            int id = passengerDB.insertObjects(passengerDB.getInsertStmt(passenger));
            passenger.setId(id);
            
            id = reservDB.insertObjects(reservDB.getInsertReservationStmt(reserv));
            
            return (long)id;
        } catch (SQLException ex) {
            Logger.getLogger(BuyImplementaion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 2l;
    }

}
