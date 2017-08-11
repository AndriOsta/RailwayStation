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
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Country;

/**
 *
 * @author Admin
 */
public class CountryDB extends AbstractDBObjectOperations<Country>{
    
    public static final String TABLE_COUNTRY="spr_country";
    
    private static CountryDB instance;

    public CountryDB() {
        super(TABLE_COUNTRY);
    }
    
    public static CountryDB getInstance(){
        
        if (instance==null){
            instance=new CountryDB();
        }
        return instance;
    }
    
    
    
     private static PreparedStatement getCountryByName(String name) throws SQLException{
        Connection conn=AviaDB.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement("select*from "+TABLE_COUNTRY+" where name=?");
        preparedStatement.setString(1, name);
        return preparedStatement;
        
    }
    
    @Override
            public Country fillObject(ResultSet rs) throws SQLException{
            
               Country country=new Country();
               country.setId(rs.getLong("id"));
               country.setCode(rs.getString("code"));
               country.setDescr(rs.getString("desc"));
               country.setName(rs.getString("name"));
               country.setFlag(rs.getBytes("flag"));
             return country;   
            }
        
    
}
