/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.grennwitchtime;

import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Admin
 */
public class GreenweachTime {
    
    public static Calendar getInstance(){
        return Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        
    }
    
    public static void print(Calendar c){
        int day=c.get(Calendar.DAY_OF_MONTH);
          int month=c.get(Calendar.MONTH);
            int year=c.get(Calendar.YEAR);
            
            int minute=c.get(Calendar.MINUTE);
            int hour=c.get(Calendar.HOUR);
            
            System.out.println("Current date is "+day+"/"+month+"/"+year+" "+hour+":"+minute);
        
    }
    
}
