package com.security.gurume365;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.gurume365.dao.UsersDAO;
import com.security.gurume365.vo.Users;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UsersDAO usersDAO;
	
	@RequestMapping(value = "/login/loginForm", method = RequestMethod.GET)
	public String loginFor(Locale locale, Model model) {
		logger.info("Welcome Login Form!");
		
		return "login/loginForm";
	}
	
	@RequestMapping(value = "/login/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Locale locale, Model model) {
		logger.info("Welcome Access Denied!");
		
		return "login/accessDenied";
	}
	
	@RequestMapping(value="/join/joinPermission",method=RequestMethod.GET)
	public String joinPermission(Locale locale, Model model){
		logger.info("Welcome JoinPermission");
		return "join/joinPermission";
	}
	
	@RequestMapping(value="/join/joinForm",method=RequestMethod.GET)
	public String joinForm(Locale locale){
		logger.info("Welcome JoinForm");
		return "join/joinForm";
	}
	

	@RequestMapping(value="/join/insertUsers",method=RequestMethod.POST)
	@ResponseBody
	public void insertUsers(Users users){
		usersDAO.insertUsers(users);
	}
	
	@RequestMapping(value="/join/joinComplement",method=RequestMethod.GET)
	public String joinComplement(){
		return "join/joinComplement";
	}
}
