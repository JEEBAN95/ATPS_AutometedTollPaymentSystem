package com.jk.commonsUtils;

public interface ApplicationConstants {

	/**
	 * @Param below constants are used for some constant messages
	 * 
	 */
	String url = "Link to Unlock your account";
	
	String msg = "User Name and Password is already sent to your given email address";
	
	String pwdErr = "Please provide valid uname/password";
	
	String DefaultRole = "USER";
	
	String LoginMsg = "Use your email and password for login";
	
	String RegistrationSuccess = "You have successfully registered";
	
	String emailErr = "Your email is already exist "+"<a href=http://localhost:2525/atps/login>Login</a>";
	
	/**
	 * @Param below constants are used for some model attributes
	 * 
	*/	
	String UNAME_PASS_ERR_MSG = "msg";

	String SUCCESS_MSG = "success";
	
	String USER_EMAIL = "email";
	
	String LOGIN_MSG="loginMsg";
	
	String EMAIL_NOTIFICATION = "emailNotification";
	
	
	/**
	 * @Param below constants are used for referring the logical view pages 
	*/
	String LOGICAL_USER_LOGIN_FORM = "userloginForm";
	
	String LOGICAL_USER_SIGNUP_FORM = "userSignupForm";
	
	String LOGICAL_USER_ACC_UNLOCK_FORM = "userAccountUnlockForm";
	
	String LOGICAL_USER_DASHBOARD = "userDashboard";
}
