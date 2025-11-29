package com.sahil.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();		
	}
	

//	//As Spring Security going handle login feature so we don't need this logic any more here
//	//we are also going to delete AuthenticationService.java file and login.jsp file
//	//code snippet in saved in notepad for learning purpose as AuthenticationService and loginJSP
	
//	private AuthenticationService authenticationService;
//		
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
	

	
//	@RequestMapping("login")
////	here we have used concept of Model
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		return "login";
//	}
	

	
//	@RequestMapping(value = "login", method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
	
//	 //here we don't need to worry about login functionally spring security will handle everything.
//   //if anybody go to the root of the application then we want them to go to the welcome page and NOT to the login page
//	 //that's why we are removing login and changing return to welcome
	

	
//	//As Spring Security going handle login feature so we don't need this logic any more here
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
////			model.put("password", password);
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid credentials! Please try again.");
//		return "login";
//	}


}
