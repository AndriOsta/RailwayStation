package ua.andriosta.raiywayservice;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.andriosta.raiywayservice.pojo.users.Member;
import ua.andriosta.raiywayservice.pojo.users.MemberDB;
import ua.andriosta.raiywayservice.pojo.users.User;
import ua.andriosta.raiywayservice.pojo.users.UserDB;

@Controller
public class RegistUserController {
	
	@ModelAttribute
	public User createNewUser(){
		return new User();
	}
	
	

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registPage() {

		return "regist";

	}
	
	
	
	@RequestMapping(value = { "/add"}, method = RequestMethod.GET)
	public String addUser(@ModelAttribute("user")User user){
		
		
		
		
		
		try {
			Member member=new Member();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
			String newpassword=encoder.encode(user.getPassword());
			user.setPassword(newpassword);
			int insert=UserDB.getInstance().insertObjects(UserDB.getInstance().getInsertStmt(user));
		    member.setUsername(user.getUsername());
		    member.setGroup_id(1);;
			
			int insert2=MemberDB.getInstance().insertObjects(MemberDB.getInstance().getInsertStmt(member));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping(value = { "/cancel"}, method = RequestMethod.GET)
	public String cancel(){
		
		return "login";
	}
}
