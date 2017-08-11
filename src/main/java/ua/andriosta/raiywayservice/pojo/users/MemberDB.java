package ua.andriosta.raiywayservice.pojo.users;

import java.awt.RenderingHints.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.andriosta.raiywayservice.dbconnection.AviaDB;

public class MemberDB {

	  private static MemberDB instance;


	  
	    
	    
	   
	    public static MemberDB getInstance(){
	        if (instance==null){
	            instance=new MemberDB();
	        }
	        return instance;
	    }
	    
	    
	    
	    public PreparedStatement getInsertStmt(Member member) throws SQLException {
	        Connection conn = AviaDB.getInstance().getConnection();
	        PreparedStatement stmt = conn.prepareStatement("insert into group_members (username, group_id) values (?,?)");
	        stmt.setString(1, member.getUsername());
	        stmt.setInt(2, member.getGroup_id());
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
