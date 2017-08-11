/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.abstractions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ua.andriosta.projects.database.AviaDB;
import ua.andriosta.projects.interfaces.dboperations.DBObjectOperations;

/**
 *
 * @author Admin
 */
public abstract class AbstractDBObjectOperations<T>implements DBObjectOperations<T>{
    
    public String TABLE_NAME;

    public AbstractDBObjectOperations() {
    }

    public AbstractDBObjectOperations(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }
     @Override
    public T fillObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insertObjects(PreparedStatement stmt) throws SQLException {
        int result = -1;
        ResultSet rs = null;

        try {
            result = stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();

            rs.next();
            if (rs.isFirst()) {
                result = rs.getInt(1);// РІРµСЂРЅСѓС‚СЊ id РІСЃС‚Р°РІР»РµРЅРЅРѕР№ Р·Р°РїРёСЃРё
            }

            

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



    

    @Override
    public T executeObject(PreparedStatement ps) throws SQLException {
       ResultSet rs=null;
       T object=null;
        try{  
       rs=ps.executeQuery();
       rs.next();
       if(rs.isFirst()){
           object=fillObject(rs);
       }
      
      
      
        }finally{
            if(rs!=null){
            rs.close();
            }
            if(ps!=null){
            ps.close();
            }
        }
         return object;
    }

    @Override
    public ArrayList<T> executeAllObjects(PreparedStatement ps) throws SQLException {
        ArrayList<T> list = new ArrayList<T>();
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(fillObject(rs));
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return list;

    }

  

    @Override
    public PreparedStatement getObjectById(long id) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        String sql="select * from " + TABLE_NAME + " where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        System.out.println(sql);
        return stmt;

    }

    @Override
    public PreparedStatement getAllObjects() throws SQLException {
         Connection conn= AviaDB.getInstance().getConnection();
          PreparedStatement ps = conn.prepareStatement("select * from " + TABLE_NAME);
        //PreparedStatement ps=conn.prepareStatement(sql);
        
       // System.out.println(sql);
        return ps;
    }
    
    
    
}
