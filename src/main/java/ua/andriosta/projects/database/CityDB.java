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
import ua.andriosta.projects.directory_objects.City;

/**
 *
 * @author Admin
 */
public class CityDB extends AbstractDBObjectOperations<City> {
    
  
    
    
    public static final String TABLE_CITY="spr_city";
    
    
    private static CityDB instance;

    public CityDB() {
        
        super(TABLE_CITY);
    }
    
    
    
    
    public static CityDB getInstance(){
     
        if(instance==null){
            instance=new CityDB();
        }
        return instance;
    } 
    
    private PreparedStatement getCityByName(String name) throws SQLException{
        Connection conn=AviaDB.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement("select*from+"+TABLE_CITY+" where name=?");
        preparedStatement.setString(1, name);
        return preparedStatement;
        
    }
    
     
      
   @Override   
      public City fillObject(ResultSet rs) throws SQLException{
          City city =new City();
          
          city.setId(rs.getLong("id"));
               city.setCode(rs.getString("code"));
               city.setDescr(rs.getString("desc"));
               city.setCountry(CountryDB.getInstance().executeObject(CountryDB.getInstance().getObjectById(rs.getLong("country_id"))));
               city.setName(rs.getString("name"));
               
               return city;
          
      }
    
}
