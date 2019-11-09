package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jk.command.UserCmd;
import com.jk.dto.UserDTO;
import com.jk.entity.User;
import com.jk.service.UserService;

@Controller
@SessionAttributes({ "userRegdCmd" })
public class UserLoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/userlogin")
	public String showLoginPage(Model model) {
		UserCmd userCmd = null;
		userCmd = new UserCmd();
		model.addAttribute("userRegdCmd", userCmd);
		return "login";
	}// showLoginPage

	// get data form login page
	// allow login for the user
	// use service
	@PostMapping("/signin")
	public String userSignIn(@ModelAttribute UserCmd userCmd) {
		
		User userEntity = null;
		UserDTO userDto = new UserDTO();
		userDto.setEmail(userCmd.getEmail());
		userDto.setPassword(userCmd.getPassword());
		userEntity = userService.userLogin(userDto);
		System.out.println(userEntity);
		if(userEntity==null) {
			return "login";
		}
		return "home";
	}
}
