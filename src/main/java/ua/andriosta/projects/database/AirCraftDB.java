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
import ua.andriosta.projects.directory_objects.AirCraft;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;

/**
 *
 * @author Admin
 */
public class AirCraftDB extends AbstractDBObjectOperations<AirCraft>{
    
    
   private static AirCraftDB instance;
   
   public static final String TABLE_AIRCRAFT="spr_aircraft";

    public AirCraftDB() {
        super(TABLE_AIRCRAFT);
    }
   
   
   
    
    public static AirCraftDB getInstance(){
        if(instance==null){
            instance=new AirCraftDB();
        }
        return instance;
    } 
    
    
     private PreparedStatement getAirCraftByName(String name) throws SQLException{
        Connection conn=AviaDB.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement("select*from"+TABLE_AIRCRAFT+"where name=?");
        preparedStatement.setString(1, name);
        return preparedStatement;
        
    }
    
    
     
       
   @Override
   public AirCraft fillObject(ResultSet rs) throws SQLException{
      AirCraft  airCraft=new AirCraft();
               airCraft.setId(rs.getLong("id"));
               airCraft.setCompany(CompanyDB.getInstance().executeObject(CompanyDB.getInstance().getObjectById(rs.getLong("company_id"))));
               airCraft.setName(rs.getString("name"));
              ArrayList<Place> placeList = PlaceDB.getInstance().executeAllObjects(PlaceDB.getInstance().getPlacesPSByAircraft(rs.getLong("id")));
        airCraft.setPlaceList(placeList);
     return airCraft;
   }
   
    
    
}
