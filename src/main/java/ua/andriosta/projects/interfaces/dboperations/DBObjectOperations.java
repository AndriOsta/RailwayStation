/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces.dboperations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DBObjectOperations<T>{
    
    int insertObjects(PreparedStatement ps) throws SQLException;
   
    T executeObject(PreparedStatement ps)throws SQLException;
    
    ArrayList<T> executeAllObjects(PreparedStatement ps)throws SQLException;
    
    T fillObject(ResultSet rs)throws SQLException;
    
    PreparedStatement getObjectById(long id)throws SQLException;
    
    PreparedStatement getAllObjects()throws SQLException;
    
   
}
