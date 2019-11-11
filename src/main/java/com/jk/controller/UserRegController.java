package com.jk.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class UserRegController {

	@Autowired
	private UserService userService;
	@Autowired
	Environment env;

	@GetMapping("/login")
	public String showLoginPage(Model model){
		UserCmd userCmd = null;
		userCmd = new UserCmd();
		model.addAttribute("userRegdCmd", userCmd);
		return ApplicationConstants.LOGICAL_USER_LOGIN_FORM;
	}// showLoginPage

	// Create UserCmd userCmd obj
	// launch form
	@GetMapping("/signUp")
	public String userSignUp(Model model, @ModelAttribute UserCmd userCmd) {
		model.addAttribute("userRegdCmd", userCmd);
		return ApplicationConstants.LOGICAL_USER_SIGNUP_FORM;
	}// userSignUp

	/**
	 * 
	 * @param service
	 * @param Register user
	 * @param sent     to email
	 */
	@PostMapping("/register")
	public String userRegister(@ModelAttribute UserCmd userCmd, Model model) {

		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(userCmd, userDto);
		User userEntity = null;
		try {
			userEntity = userService.saveUser(userDto);
			return "redirect:/sentMail?uid=" + userEntity.getUid();
		} catch (Exception e) {
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, "Your email is already exist");
			return "redirect:/sentMail?msg=" + model.getAttribute("msg");
		}
	}// userRegister

	@GetMapping("/sentMail")
	public String userRegisterSuccess(@ModelAttribute UserCmd userCmd, Model model, String msg) {
		
		if (msg != null)
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, "Your email is already exist");
		else {
			model.addAttribute(ApplicationConstants.SUCCESS_MSG, ApplicationConstants.RegistrationSuccess);
			model.addAttribute(ApplicationConstants.EMAIL_NOTIFICATION, env.getProperty("mailSent"));
		}
		return ApplicationConstants.LOGICAL_USER_SIGNUP_FORM;
	}// userRegisterSuccess

	/**
	 * use
	 * 
	 * @param service
	 * @param get     user info form database
	 */
	@GetMapping("/user-acc-unlock")
	public String showUnlockAccForm(@ModelAttribute UserCmd userCmd, Model model, @RequestParam("uid") int uid) {

		User userEntity = userService.getUserByID(uid);
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(userEntity, userDto);
		BeanUtils.copyProperties(userDto, userCmd);
		model.addAttribute(ApplicationConstants.USER_EMAIL, userCmd.getEmail());
		return ApplicationConstants.LOGICAL_USER_ACC_UNLOCK_FORM;
	}// showUnlockAccForm

	/**
	 * @param update   user's password
	 * @param unlock   user
	 * @param redirect to login page
	 */
	@PostMapping("/unlockUser")
	public String updatePassword(@ModelAttribute UserCmd userCmd, @RequestParam("userEmail") String email,
			Model model) {

		User userEntity = null;
		userCmd.setEmail(email);
		UserDTO userDto = new UserDTO();
		userDto.setEmail(userCmd.getEmail());
		userDto.setPassword(userCmd.getPassword());
		userDto.setNewPassword(userCmd.getNewPassword());
		userDto.setConfirmPassword(userCmd.getConfirmPassword());
		try {
			userEntity = userService.updateUser(userDto);
			if (userEntity.getStatus() == 0) {
				userEntity = null;
			}
			userDto.setEmail(userEntity.getEmail());
		} // try
		catch (Exception e) {
			model.addAttribute(ApplicationConstants.UNAME_PASS_ERR_MSG, ApplicationConstants.pwdErr);
			model.addAttribute(ApplicationConstants.USER_EMAIL, userDto.getEmail());
			return ApplicationConstants.LOGICAL_USER_ACC_UNLOCK_FORM;
		} // catch
		return "redirect:/userlogin?email=" + userDto.getEmail();
	}// updatePassword
}// class
