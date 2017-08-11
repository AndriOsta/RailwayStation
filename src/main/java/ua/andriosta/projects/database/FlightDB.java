/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.abstractions.AbstractDBObjectOperations;
import ua.andriosta.projects.directory_objects.AirCraft;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.grennwitchtime.GreenweachTime;
import ua.andriosta.projects.objects.Flight;

/**
 *
 * @author Admin
 */
public class FlightDB extends AbstractDBObjectOperations<Flight>{


    private static final int INTERVAL=1;
    private static FlightDB instance;
    public  final static String TABLE_FLIGHT="flight";

     public FlightDB() {
        super(TABLE_FLIGHT);
    }
  
     public static FlightDB getInstance(){

        if(instance==null){
            instance=new FlightDB();
        }
        return instance;
    }
     
     
     
     @Override

    public Flight fillObject(ResultSet rs) throws SQLException{

        Flight flight=new Flight();

        Calendar datedepart = Calendar.getInstance();
        datedepart.setTimeInMillis(rs.getLong("date_depart"));

        Calendar datecome = Calendar.getInstance();
        datecome.setTimeInMillis(rs.getLong("date_come"));

        flight.setId(rs.getLong("id"));
        AirCraft a1=AirCraftDB.getInstance().executeObject(AirCraftDB.getInstance().getObjectById(rs.getLong("aircraft_id")));
        flight.setAirCraft(a1);
        flight.setCityFrom(CityDB.getInstance().executeObject(CityDB.getInstance().getObjectById(rs.getLong("city_from_id"))));
        flight.setCityTo(CityDB.getInstance().executeObject(CityDB.getInstance().getObjectById(rs.getLong("city_to_id"))));
        flight.setFlight_date(datedepart);
        flight.setFlight_datecome(datecome);
        flight.setCode(rs.getString("code"));
        
         ArrayList<Place> places=new ArrayList<Place>();
             places.addAll(PlaceDB.getInstance().executeAllObjects(PlaceDB.getInstance().getPlacePSBusy(a1.getId(), flight.getId())));
         a1.setPlaceList(places);
         
         for (Place place : places) {
             if(!place.isBusy()){
                 flight.setExistFreePlace(true);
                 break;
             }
             
         }

        int day=datecome.get(Calendar.DAY_OF_MONTH)-datedepart.get(Calendar.DAY_OF_MONTH);
        int month=datecome.get(Calendar.MONTH)-datedepart.get(Calendar.MONTH);
        int hour=datecome.get(Calendar.HOUR_OF_DAY)-datedepart.get(Calendar.HOUR_OF_DAY);
        int minute=datecome.get(Calendar.MINUTE)-datedepart.get(Calendar.MINUTE);

        StringBuffer sb=new StringBuffer();

        if(day>0 ){
            sb.append(day+" days");
        }
        if(month>0 ){
            sb.append(month+" month");
        }
        if(hour>0 ){
            sb.append(hour+" hours");
        }

        if(minute>0 ){
            sb.append(minute+" minutes");
        }

        flight.setDuration(sb.toString());





        return flight;

    }




      public PreparedStatement getFlightsByCriterationStmt(String cityFrom,String cityTo) throws SQLException{
         Connection conn=AviaDB.getInstance().getConnection();
         PreparedStatement ps=conn.prepareStatement("SELECT a.id,a.date_depart,a.date_come,a.code,c.name as name,cc.name as name, air.name as name FROM flight a \n" +
                                                     "inner join spr_city c on a.city_from_id=c.id\n" +
                                                       "inner join spr_city cc on a.city_to_id=cc.id\n" +
                                                      " inner join spr_aircraft air on a.aircraft_id=air.id\n" +
                                                             "where c.name like ?  and cc.name like ?");
         ps.setString(1, cityFrom);
         ps.setString(2, cityTo);
         return ps;

      }


       public PreparedStatement getFlightsStmt(Calendar timeDate,City c1,City c2) throws SQLException{
        Connection conn=AviaDB.getInstance().getConnection();
        PreparedStatement ps=conn.prepareStatement("select* from " +TABLE_NAME+ " where date_depart>=? and date_depart<? and city_from_id=? and city_to_id=?");


         timeDate.set(Calendar.HOUR_OF_DAY,0);
         timeDate.set(Calendar.MINUTE,0);
         timeDate.set(Calendar.SECOND,0);
         timeDate.set(Calendar.MILLISECOND,0);

         GreenweachTime.print(timeDate);
           System.out.println(timeDate.getTimeInMillis());

         Calendar dateTimeInterval=(Calendar) timeDate.clone();
         dateTimeInterval.add(Calendar.DATE,1);
         GreenweachTime.print(dateTimeInterval);
         System.out.println(dateTimeInterval.getTimeInMillis());

         ps.setLong(1,timeDate.getTimeInMillis());
         ps.setLong(2,dateTimeInterval.getTimeInMillis());
           ps.setLong(3, c1.getId());
         ps.setLong(4, c2.getId());

        return ps;

    }
       
}
