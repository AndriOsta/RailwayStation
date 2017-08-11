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
import ua.andriosta.projects.directory_objects.Company;
import ua.andriosta.projects.directory_objects.FlightClass;

/**
 *
 * @author Admin
 */
public class CompanyDB extends AbstractDBObjectOperations<Company>{
    
    public static final String TABLE_COMPANY="spr_company";
    private static CompanyDB instance;

    public CompanyDB() {
        super(TABLE_COMPANY);
    }

  
   
    
     public static CompanyDB getInstance(){
        
        if (instance==null){
            instance=new CompanyDB();
        }
        return instance;
    }
     @Override
     public Company fillObject(ResultSet rs) throws SQLException{
         Company company=new Company();
              
               company .setId(rs.getLong("id"));  
               company.setDescr(rs.getString("desc"));
               company.setName(rs.getString("name"));
         return company;      
     }
          
       
    
}
