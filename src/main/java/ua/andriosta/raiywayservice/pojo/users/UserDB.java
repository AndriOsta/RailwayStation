package ua.andriosta.raiywayservice.pojo.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.andriosta.raiywayservice.dbconnection.AviaDB;

public class UserDB {
	
	 
    private static UserDB instance;


  
    
    
   
    public static UserDB getInstance(){
        if (instance==null){
            instance=new UserDB();
        }
        return instance;
    }
    
    
    public User fillObject(ResultSet rs) throws SQLException{
       User p=new User();
         
         p.setUsername(rs.getString("username"));
         p.setPassword(rs.getString("password"));
       //  p.setEnabled(rs.getInt("enabled"));
        
         return p;
    }
    
     
    public PreparedStatement getInsertStmt(User user) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into users (username, password) values (?,?)");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
 //       stmt.setInt(3, user.getEnabled());
   
        return stmt;
    }
	

    
    public int insertObjects(PreparedStatement stmt) throws SQLException {
        int result = -1;
        ResultSet rs = null;

        try {
            result = stmt.executeUpdate();

         


            

        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        }

        return result;
    }
}
