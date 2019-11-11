package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jk.command.UserCmd;
import com.jk.commonsUtils.ApplicationConstants;
import com.jk.dto.UserDTO;
import com.jk.entity.User;
import com.jk.service.UserService;

@Controller
@SessionAttributes({ "userRegdCmd" })
public class UserLoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/userlogin")
	public String showLoginPage(Model model, @RequestParam("email") String email) {
		UserCmd userCmd = null;
		userCmd = new UserCmd();
		model.addAttribute(ApplicationConstants.LOGIN_MSG, ApplicationConstants.LoginMsg);
		model.addAttribute(ApplicationConstants.USER_EMAIL, email);
		model.addAttribute("userRegdCmd", userCmd);
		return ApplicationConstants.LOGICAL_USER_LOGIN_FORM;
	}// showLoginPage

	// get data form login page
	// allow login for the user
	// use service
	@PostMapping("/signin")
	public String userSignIn(@ModelAttribute UserCmd userCmd, Model model) {

		User userEntity = null;
		UserDTO userDto = new UserDTO();
		userDto.setEmail(userCmd.getEmail());
		userDto.setPassword(userCmd.getPassword());
		try {
			userEntity = userService.userLogin(userDto);
			userDto.setEmail(userEntity.getEmail());
		} // try
		catch (Exception e) {
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, ApplicationConstants.pwdErr);
			return ApplicationConstants.LOGICAL_USER_LOGIN_FORM;
		}
		return ApplicationConstants.LOGICAL_USER_DASHBOARD;
	}// userSignIn
}
