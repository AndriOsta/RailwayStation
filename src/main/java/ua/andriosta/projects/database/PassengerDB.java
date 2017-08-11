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
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.abstractions.AbstractDBObjectOperations;
import ua.andriosta.projects.objects.Passenger;

/**
 *
 * @author Admin
 */
public class PassengerDB extends AbstractDBObjectOperations<Passenger>{
    
    
    private static PassengerDB instance;
    
    public static final String TABLE_PASSENGER="passenger";

    public PassengerDB() {
     super(TABLE_PASSENGER);
    }
    
    
    
   
    public static PassengerDB getInstance(){
        if (instance==null){
            instance=new PassengerDB();
        }
        return instance;
    }
    
    
    @Override
    public Passenger fillObject(ResultSet rs) throws SQLException{
        Passenger p=new Passenger();
         p.setId(rs.getLong("id"));
         p.setEmail(rs.getString("email"));
         p.setDocument_number(rs.getString("document_number"));
         p.setFamilly_name(rs.getString("family_name"));
         p.setMiddle_name(rs.getString("middle_name"));
         p.setPhone(rs.getString("phone"));
         p.setGiven_name(rs.getString("given_name"));
         
         return p;
    }
    
     
    public PreparedStatement getInsertStmt(Passenger passenger) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into " + TABLE_PASSENGER + "(given_name, middle_name, family_name, document_number, email, phone) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, passenger.getGiven_name());
        stmt.setString(2, passenger.getMiddle_name());
        stmt.setString(3, passenger.getFamilly_name());
        stmt.setString(4, passenger.getDocument_number());
        stmt.setString(5, passenger.getEmail());
        stmt.setString(6, passenger.getPhone());
        return stmt;
    }

   
}
