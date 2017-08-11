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
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.abstractions.AbstractDBObjectOperations;
import ua.andriosta.projects.directory_objects.FlightClass;
import ua.andriosta.projects.directory_objects.Place;

/**
 *
 * @author Admin
 */
public class PlaceDB extends AbstractDBObjectOperations<Place>{
    
    public final  static String TABLE_PLACE="spr_place";
    public final  static String TABLE_AIRCRAFT_PLACE="spr_aircraft_place";
    private static PlaceDB instance;
  
        
    public static PlaceDB getInstance(){
        
        if(instance==null){
            
            instance=new PlaceDB();
        }
        return instance;
    } 

   

    private PlaceDB() {
        super(TABLE_PLACE);
    }

   
    public  PreparedStatement getPlacesPSByAircraft(long aircraft_id) throws SQLException{
          
           Connection conn=AviaDB.getInstance().getConnection();
       
          PreparedStatement ps=conn.prepareStatement("SELECT ap.id, p.seat_letter as seat_letter,p.seat_number as seat_number,p.flight_class_id as flight_class_id from "+TABLE_AIRCRAFT_PLACE+" ap inner join "+TABLE_PLACE+" p on ap.place_id=p.id where ap.aircraft_id=?");
                                                         
          ps.setLong(1, aircraft_id);
           
            
        return  ps;
      }
    
      public  PreparedStatement getPlacesPSByFlightClass(long flight_class_id) throws SQLException{
           Connection conn=AviaDB.getInstance().getConnection();
           PreparedStatement ps=conn.prepareStatement("select * from + "+TABLE_PLACE+" where flight_class_id=?");
           ps.setLong(1, flight_class_id);
          
           return  ps;
      }
      
      
      public PreparedStatement getPlacePSBusy(long aircraft_id,long flight_id) throws SQLException{
          Connection conn=AviaDB.getInstance().getConnection();
          PreparedStatement ps=conn.prepareStatement(("SELECT p.id, p.seat_letter, p.seat_number,p.flight_class_id, " +
            "if ((select r.id from "+ReservationDB.TABLE_RESERVATION+" r where r.flight_id=? and r.place_id=p.id)>1,1,0) as busy " +
            "FROM "+TABLE_PLACE+" p where id in (select place_id from "+TABLE_AIRCRAFT_PLACE+" a1 where a1.aircraft_id=?)  order by flight_class_id, seat_letter"));
          ps.setLong(1, flight_id);
          ps.setLong(2, aircraft_id);
          return ps;
      }
      
    
   
      @Override
       public  Place fillObject(ResultSet rs) throws SQLException{
        Place place=new Place();
               place.setId(rs.getLong("id"));  
              
               place.setRow(rs.getString("seat_letter").charAt(0));
               place.setSeat(rs.getInt("seat_number"));
               
               
               try{
                   place.setBusy(getBoolInt(rs.getInt("busy")));
               }catch(Exception e){
                   
                   place.setBusy(false);
               }
               
               FlightClass fc=FlightClassDB.getInstatnce().executeObject(FlightClassDB.getInstatnce().getObjectById(rs.getInt("flight_class_id")));
               place.setFlightClass(fc);
               return place;
    }
       
       
       
    private boolean   getBoolInt(int isbusy){
        
        if(isbusy>0){
            return true;
        }
        else
            return false;
    }
    
}
