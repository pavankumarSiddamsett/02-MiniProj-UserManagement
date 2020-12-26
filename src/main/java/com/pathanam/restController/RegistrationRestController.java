package com.pathanam.restController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pathanam.entity.UserMaster;
import com.pathanam.service.UserMasterService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegistrationRestController {
	@Autowired
	private UserMasterService userService;

	@GetMapping(value="/loadCountries",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object loadCountries() {
		Map<Integer, String> countries = userService.findCountries();
		return countries;
	}
	@GetMapping(value="/loadStates",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object loadStates(@RequestParam("countryId") Integer countryId) {
		Map<Integer, String> states = userService.findStates(countryId);
		return states;
	}
	@GetMapping(value="/loadCities",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object loadCities(@RequestParam("stateId") Integer stateId) {
		Map<Integer, String> cities = userService.findCities(stateId);
		return cities;
	}
	
	@PostMapping(value="/saveUser",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String handleUserRegisterBtn(@RequestBody UserMaster um) {
		boolean isUserSaved = userService.saveUser(um);
		if(isUserSaved) {
			//write logic  for sending mail to user to unlock user account
			return "please check your email to unlock account";
		}
		return "User Registration failed";
	}
	@GetMapping(value="/uniqueEmail")
	public boolean checkIsEmailUnique(@RequestParam("email") String emailId) {
				return  userService.isEmailUnique(emailId);
	}
	@PostMapping(value="/signIn")
	public String handleUserSignInBtn(@RequestParam("email") String email,
																@RequestParam("pwd") String pwd
																) {
		String resText = userService.loginCheck(email, pwd);
		
		return resText;
	}
	
		@GetMapping("/sendForgotPwd")
	public String handleForgotPwdSubmitBtn(@RequestParam("email") String emailId) {
		String password = userService.forgotPassword(emailId);
		if(password!=null) {
			//write logic to send password to mail
			return "password send to your mail successfully";
		}
		return "failed to send password to your mail";
		
	}
}
