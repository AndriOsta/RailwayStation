/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.andriosta.projects.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.andriosta.projects.database.AirCraftDB;
import ua.andriosta.projects.database.CityDB;
import ua.andriosta.projects.database.CountryDB;
import ua.andriosta.projects.database.FlightClassDB;
import ua.andriosta.projects.database.FlightDB;
import ua.andriosta.projects.database.PassengerDB;
import ua.andriosta.projects.database.PlaceDB;
import ua.andriosta.projects.database.ReservationDB;
import ua.andriosta.projects.directory_objects.AirCraft;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Country;
import ua.andriosta.projects.directory_objects.FlightClass;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.grennwitchtime.GreenweachTime;
import ua.andriosta.projects.interfaces.Buy;
import ua.andriosta.projects.interfaces.impl.BuyImplementaion;
import ua.andriosta.projects.interfaces.impl.SearchImplementation;
import ua.andriosta.projects.objects.Flight;
import ua.andriosta.projects.objects.Passenger;
import ua.andriosta.projects.objects.Reservation;

/**
 *
 * @author Admin
 */

public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
       Passenger passenger=new Passenger();
      // passenger.setId(10l);
        passenger.setGiven_name("gdfgdf");
        passenger.setFamilly_name("gdfgdf");
        passenger.setMiddle_name("gdfgdf");
        passenger.setEmail("gdfgdf");
        passenger.setPhone("gdfgdf");
        passenger.setDocument_number("gdfgdf");
        
            BuyImplementaion bi=new BuyImplementaion();
            SearchImplementation si=new SearchImplementation();
         
            
            try {
               ArrayList<Place> places=new ArrayList<>();
             places.addAll(PlaceDB.getInstance().executeAllObjects(PlaceDB.getInstance().getPlacePSBusy(1, 1)));
                System.out.println(places);
            } catch (SQLException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           /// System.out.println(si.searchFlight(1328472000000l, 3l, 2l));
            
                
                // System.out.println(si.getAllCities());
           
       
//        
//            Place flightClass=PlaceDB.getInstance().getPlace(4);
//            System.out.println(flightClass.getRow());
//        
//            ArrayList<Place> place=PlaceDB.getInstance().getPlaces(2);
//            for (Place place1 : place) {
//                
//              System.out.println(place1.getRow());  
//            }
//            
//            City city1=CityDB.getInstance().getCity(1);
//            System.out.println(city1.getName());
//            ArrayList<City> cityes=CityDB.getInstance().getAllCityes();
//            for (City city : cityes) {
//                System.out.println(city.getName());
//            }
//            
//            
           // ArrayList<Flight> flight=FlightDB.getInstance().getFlight("Москва", "Нью-Йорк");
            
           // System.out.println(flight);
      
 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
