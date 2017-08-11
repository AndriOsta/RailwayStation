
package ua.andriosta.projects.interfaces.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.andriosta.projects.database.ReservationDB;
import ua.andriosta.projects.interfaces.Check;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */
public class ChecIimplementation implements Check {

    @Override
    public Reservation checkReservationByCode(String code) {
       Reservation reserv=null;
        try {
             reserv=ReservationDB.getInstance().executeObject(ReservationDB.getInstance().getStmtByCode(code));
        } catch (SQLException ex) {
            Logger.getLogger(ChecIimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return reserv;
    }

    @Override
    public List<Reservation> checkReservationByFamilyName(String family_name) {
        List<Reservation>reserv=new ArrayList<Reservation>();
        try {
             reserv=ReservationDB.getInstance().executeAllObjects(ReservationDB.getInstance().getStmtByFamilyName(family_name));
        } catch (SQLException ex) {
            Logger.getLogger(ChecIimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return reserv; 
    }

    @Override
    public Reservation checkReservationByDocumentNumber(String document_number) {
            Reservation reserv=null;
        try {
             reserv=ReservationDB.getInstance().executeObject(ReservationDB.getInstance().getStmtByDocumentNumber(document_number));
        } catch (SQLException ex) {
            Logger.getLogger(ChecIimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return reserv; 
        
    }

    @Override
    public List<Reservation> checkReservationByDateReserv(Calendar dateReserv) {
        
      List< Reservation> reserv=new ArrayList<Reservation>();
             
        try {
             reserv=ReservationDB.getInstance().executeAllObjects(ReservationDB.getInstance().getStmtByDateReserv(dateReserv));
        } catch (SQLException ex) {
            Logger.getLogger(ChecIimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return reserv; 
        
    }
    
}
