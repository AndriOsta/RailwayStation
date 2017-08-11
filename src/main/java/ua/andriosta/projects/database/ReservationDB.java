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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.abstractions.AbstractDBObjectOperations;
import ua.andriosta.projects.grennwitchtime.GreenweachTime;
import ua.andriosta.projects.objects.Passenger;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */
public class ReservationDB extends AbstractDBObjectOperations<Reservation>{
    
    
   private static ReservationDB instance;
    
   public static final String TABLE_RESERVATION="reservation";

    public ReservationDB() {
        super(TABLE_RESERVATION);
    }
   
   
    public static ReservationDB getInstance(){
        if (instance==null){
            instance=new ReservationDB();
        }
        return instance;
    }
    
   @Override
    public Reservation fillObject(ResultSet rs) throws SQLException{
        Reservation p=new Reservation();
         p.setId(rs.getLong("id"));
         p.setInfo(rs.getString("add_info"));
         p.setFlight(FlightDB.getInstance().executeObject(FlightDB.getInstance().getObjectById(rs.getLong("flight_id"))));
         p.setPlace(PlaceDB.getInstance().executeObject(PlaceDB.getInstance().getObjectById(rs.getLong("place_id"))));
         p.setPassenger(PassengerDB.getInstance().executeObject(PassengerDB.getInstance().getObjectById(rs.getLong("passenger_id"))));
        
         
         return p;
    }
       
      
      
      
       public PreparedStatement getInsertReservationStmt(Reservation reservation) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into "+TABLE_RESERVATION+"(flight_id, passenger_id, place_id, add_info, reserve_datetime, code) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setLong(1, reservation.getFlight().getId());
        stmt.setLong(2, reservation.getPassenger().getId());
        stmt.setLong(3, reservation.getPlace().getId());
        stmt.setString(4, reservation.getAddInfo());
        stmt.setLong(5, reservation.getReserve_datatime().getTimeInMillis());
        stmt.setString(6, reservation.getCode());
        return stmt;
    }

        public PreparedStatement getStmtByDocumentNumber(String docNumber) throws SQLException {
        
        Connection conn = AviaDB.getInstance().getConnection();
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM reservation r inner join passenger p on p.id=r.passenger_id ");
        sb.append(" where p.document_number=?");
        
        PreparedStatement stmt = conn.prepareStatement(sb.toString());
        stmt.setString(1, docNumber);
        
        return stmt;
    }
    
     public PreparedStatement getStmtByFamilyName(String familyName) throws SQLException {
        
        Connection conn = AviaDB.getInstance().getConnection();
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM reservation r inner join passenger p on p.id=r.passenger_id ");
        sb.append(" where p.family_name=?");
        
        PreparedStatement stmt = conn.prepareStatement(sb.toString());
        stmt.setString(1, familyName);
        
        return stmt;
    }
     
     
      public PreparedStatement getStmtByCode(String code) throws SQLException {
        
        Connection conn = AviaDB.getInstance().getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reservation r inner join passenger p on p.id=r.passenger_id where r.code=?");
        stmt.setString(1, code);
        
        return stmt;
    }

      
       public PreparedStatement getStmtByDateReserv(Calendar timeDate) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservation where reserve_datetime>=? and  reserve_datetime<?");


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

     


        ps.setLong(1, timeDate.getTimeInMillis());
        ps.setLong(2, dateTimeInterval.getTimeInMillis());
        return ps;
    } 
      
      


}
