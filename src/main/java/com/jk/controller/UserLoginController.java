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
	/**
	 * @apiNote get data form login page allow login for the user use service
	 */
	@GetMapping("/userlogin")
	public String showLoginPage(Model model, @RequestParam("email") String email) {
		UserCmd userCmd = null;
		userCmd = new UserCmd();
		model.addAttribute(ApplicationConstants.LOGIN_MSG, ApplicationConstants.LoginMsg);
		model.addAttribute(ApplicationConstants.USER_EMAIL, email);
		model.addAttribute("userRegdCmd", userCmd);
		return ApplicationConstants.LOGICAL_USER_LOGIN_FORM;
	}// showLoginPage

	/**
	 * @apiNote get data form login page allow login for the user
	 */
	@PostMapping("/signin")
	public String userSignIn(@ModelAttribute UserCmd userCmd, Model model) {

		User userEntity = null;
		UserDTO userDto = new UserDTO();
		userDto.setEmail(userCmd.getEmail());
		userDto.setPassword(userCmd.getPassword());
		try {
			userEntity = userService.userLogin(userDto);
			userDto.setEmail(userEntity.getEmail());
		} catch (Exception e) {
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, ApplicationConstants.pwdErr);
			return ApplicationConstants.LOGICAL_USER_LOGIN_FORM;
		}
		return userEntity.getRole()+ApplicationConstants.LOGICAL_USER_DASHBOARD;
	}// userSignIn
	
	/**
	 * @apiNote this method is used for lunching the forgot password logical form.
	*/
	@GetMapping("/forgotpassword")
	public String forgotPassword(@ModelAttribute("frgtPwd")UserCmd userCmd) {
		return ApplicationConstants.LOGICAL_USER_FORGOTPASSWORD;
	}
	
	/**
	 * @apiNote this method is used for sending the password to the user's email
	*/
	@PostMapping("/resetPassword")
	public String sendPasswordToUserEmail(@ModelAttribute("frgtPwd")UserCmd userCmd, Model model) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(userCmd.getEmail());
		try {
			userService.searchUserByEmail(userDto.getEmail());
			model.addAttribute(ApplicationConstants.SUCCESS_MSG, ApplicationConstants.msg);
		} catch (Exception e) {
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, ApplicationConstants.userEmailErr);
		}
		return ApplicationConstants.LOGICAL_USER_FORGOTPASSWORD;
	}//resetPassword
}// class