package ua.andriosta.raiywayservice.dbconnection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



import java.sql.Connection;

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
               
                dataSource= (DataSource) initialContext.lookup("java:comp/env/jdbc/Avia");
                con= dataSource.getConnection();
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
