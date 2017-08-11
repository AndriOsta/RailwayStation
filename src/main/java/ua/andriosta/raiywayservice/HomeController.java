package ua.andriosta.raiywayservice;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.andriosta.raiywayservice.pojo.users.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */



	
	public String mainPage() {
		printUserDetails();

		return "/content/user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {

		return "/content/admin";

	}
	


	private void printUserDetails() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		logger.info("password = " + userDetails.getPassword());
		logger.info("username = " + userDetails.getUsername());

		for (GrantedAuthority auth : userDetails.getAuthorities()) {
			logger.info(auth.getAuthority());
		}

	}
 
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView();
		
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}

	//	model.addObject("user",new User());
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		// пока русский текст без локализации, хотя так не рекомендуется!
		if (user != null) {
			model.addObject("errorMsg", user.getName() + " you don't have access to this page");
		} else {
			model.addObject("errorMsg", "У вас нет доступа к этой странице!");
		}

		model.setViewName("/content/accessDenied");
		return model;

	}
}
