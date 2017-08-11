package ua.andriosta.raiywayservice;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import ua.andriosta.projects.database.CityDB;
import ua.andriosta.projects.database.FlightDB;
import ua.andriosta.projects.database.ReservationDB;
import ua.andriosta.projects.directory_objects.City;
import ua.andriosta.projects.directory_objects.Place;
import ua.andriosta.projects.interfaces.impl.BuyImplementaion;
import ua.andriosta.projects.interfaces.impl.ChecIimplementation;
import ua.andriosta.projects.interfaces.impl.SearchImplementation;
import ua.andriosta.projects.objects.Flight;
import ua.andriosta.projects.objects.Passenger;
import ua.andriosta.projects.objects.Reservation;
import ua.andriosta.raiywayservice.params.FlightParams;
import ua.andriosta.raiywayservice.pojo.users.User;


@Controller
@SessionAttributes({"cityList","flightList"})
public class AviaController {
	
	
	private SearchImplementation si=new SearchImplementation();
	private BuyImplementaion bi=new BuyImplementaion();
	private ChecIimplementation ci=new ChecIimplementation();
	private ArrayList<Flight> flightList=null;
	private Model modelAt;
	


	
	
	@RequestMapping(value = {"/user"}, method = RequestMethod.GET)
	public ModelAndView getAllcities(Model modelat){
		modelat.addAttribute("flightParams",new FlightParams());
		
		ArrayList<City> cityList=new ArrayList<City>();
		ModelAndView model=new ModelAndView();
		cityList=(ArrayList<City>) si.getAllCities();
		flightList=(ArrayList<Flight>) si.getAllFlights();
		model.addObject("cityList",cityList);
		model.addObject("flightList",flightList);
		
		model.setViewName("/content/user");
		return model;
	}
	@RequestMapping(value = "/adminpage", method = RequestMethod.GET)
	public ModelAndView administartorPage() {


		ArrayList<City> cityList=new ArrayList<City>();
		ModelAndView model=new ModelAndView();
		cityList=(ArrayList<City>) si.getAllCities();
		flightList=(ArrayList<Flight>) si.getAllFlights();
		model.addObject("cityList",cityList);
		model.addObject("flightList",flightList);
		
		model.setViewName("/content/adminpage");
		return model;

	}
	
	@RequestMapping(value ="getflights", method = RequestMethod.GET)
	public ModelAndView getFlights(@RequestParam(value="date") String date,@RequestParam(value="cityFrom") String cityFrom, @RequestParam(value="cityTo") String cityTo,Model modelat){
		// flightList=null;
		
		modelat.addAttribute("flightParams",new FlightParams());
		ModelAndView model=new ModelAndView();
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		Long milliseconds=null;
		try {
			Date d=f.parse(date);
			 milliseconds = d.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		flightList=(ArrayList<Flight>) si.searchFlight(milliseconds,new Long(cityFrom),new Long(cityTo));
		model.addObject("flightList",flightList);
		model.setViewName("/content/user");
		System.out.println(flightList);
		System.out.println(date);
		System.out.println(cityFrom);
		System.out.println(cityTo);
		System.out.println(milliseconds);
		
		return model;
		
	}
	@RequestMapping(value ="addpassenger", method = RequestMethod.GET)
	public ModelAndView addPassenger(@RequestParam(value="firstname") String firstname,
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="middlename") String middlename ,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="email") String email,
			@RequestParam(value="addinfo") String addinfo,
			@RequestParam(value="number") String number,
			@RequestParam(value="placeid") String placeid){
		ModelAndView model=new ModelAndView();
		Passenger passenger=new Passenger();
		passenger.setGiven_name(firstname);
		passenger.setFamilly_name(lastname);
		passenger.setMiddle_name(middlename);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		passenger.setDocument_number(number);
		
		
	
		
		
			long buy=bi.buyTicket(1l, new Long(placeid), passenger, addinfo);
			 System.out.println(buy);
			
		
		
		model.setViewName("/content/admin");
		
		return model;
		
		
		
	}
	
	@RequestMapping(value ="getplaces", method = RequestMethod.GET)
	public ModelAndView getplaces(@RequestParam(value="param") String flightid){
		
	   ArrayList<Place> placeList=new ArrayList<>(); 
	   ModelAndView model=new ModelAndView();
		Flight flight=null;
		try {
			flight = FlightDB.getInstance().executeObject(FlightDB.getInstance().getObjectById(new Long(flightid)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        String s1=String.valueOf(flight.getAirCraft().getId());
            
       for(Place place:flight.getAirCraft().getPlaceList()){
            if(!place.isBusy()){
                placeList.add(place);
            }
        }
       model.addObject("placeList",placeList);
       model.setViewName("/content/user");
       
       
       return model;
	}
	
	@RequestMapping(value ="checkcode", method = RequestMethod.GET)
	public ModelAndView check(@RequestParam(value="code") String code){
		
		ModelAndView model=new ModelAndView();
		
		   Reservation resrvation=ci.checkReservationByCode(code);
		   
		   model.addObject("reserv",resrvation);
		   
		   model.setViewName("/content/admin");
		   
		   return model;
		   
		
	}

}
