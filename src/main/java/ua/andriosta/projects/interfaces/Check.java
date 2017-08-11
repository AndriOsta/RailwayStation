/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.interfaces;

import java.util.Calendar;
import java.util.List;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */
public interface Check {
    
  
    Reservation checkReservationByCode(String code);
    
    List <Reservation> checkReservationByFamilyName(String code);
    
    Reservation checkReservationByDocumentNumber(String code);
    
    List<Reservation> checkReservationByDateReserv(Calendar dateReserv);
    
    
}
