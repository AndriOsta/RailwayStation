/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class AviaDB {
    
    private static Connection con;
    private static InitialContext initialContext;
    private static DataSource dataSource;

    private AviaDB() {
    }
    
     private static AviaDB instance;
    
    public static AviaDB getInstance(){
        if(instance==null){
            instance=new AviaDB();
        }
        return instance;
    } 
    
    public Connection getConnection(){
        try {
            if(con==null||con.isClosed()){
                initialContext=new InitialContext();
                dataSource=(DataSource) initialContext.lookup("jdbc/Avia");
                con=dataSource.getConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AviaDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AviaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return con;
    }
    
    public void closeConnection(){
        if(con!=null){
            try {            
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AviaDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
        }
    }
}
