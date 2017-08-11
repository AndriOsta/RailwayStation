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
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.abstractions.AbstractDBObjectOperations;
import ua.andriosta.projects.directory_objects.Country;
import ua.andriosta.projects.directory_objects.FlightClass;

/**
 *
 * @author Admin
 */
public class FlightClassDB extends AbstractDBObjectOperations<FlightClass>{
    
    
    public static final String TABLE_FLIGHT_CLASS="spr_flight_class";
    
   
    public FlightClassDB() {
        super(TABLE_FLIGHT_CLASS);
    }
    
    private static FlightClassDB instance;
    
    public static FlightClassDB getInstatnce(){
        if(instance==null){
            instance=new FlightClassDB();
        }
        return instance;
    }

  
    
    @Override
    public FlightClass fillObject(ResultSet rs) throws SQLException{
        FlightClass fc=new FlightClass();
        fc.setId(rs.getInt("id"));
        fc.setDescr(rs.getString("desc"));
        fc.setName(rs.getString("name"));
        
        return fc;
        
        
    }
  
    
}
