package com.jk.commonsUtils;

public interface ApplicationConstants {

	/**
	 * @Param this constants is used for specifying the 'account status of the user'
	 */
	String USER_LOCKED = "Locked";
	String USER_UnLOCKED = "Un-locked";
	
	/**
	 * @Param this constants is used for specifying the 'role'
	 */
	String DEFAULT_ROLE = "user";

	/**
	 * @Param this constants is used for 'email' notification
	 */
	String msg = "Your  Password is already sent to your given email address kindly Visit to your email.";

	/**
	 * @Param this constants is used for 'uname/password' error notification
	 */
	String pwdErr = "Please provide valid uname/password";

	/**
	 * @Param this constants is used for 'login' notification
	 */
	String LoginMsg = "Use your email and password for login";

	/**
	 * @Param this constants is used for 'success' notification
	 */
	String RegistrationSuccess = "You have successfully registered";

	/**
	 * @Param this constants is used for 'duplicate email' notification
	 */
	String emailErr = "Your email is already exist ";
	
	/**
	 * @Param this constants is used to find whether the given email lD is correct or not and send the notification
	 */
	String userEmailErr = "Your email id is not registered with us kindly provide a registered email id";
	
	/**
	 * @Param this constants is used for 'login' notification
	 */
	String InternalProblem = "Some thing went wrong or internal problem try again leter";

	/**
	 * @Param this is the model attribute for password and email error messages
	 */
	String UNAME_PASS_ERR_MSG = "msg";

	/**
	 * @Param this is the model attribute for success messages
	 */
	String SUCCESS_MSG = "success";

	/**
	 * @Param this is the model attribute for sending the email to logical view page
	 */
	String USER_EMAIL = "email";

	/**
	 * @Param this is the model attribute for login messages
	 */
	String LOGIN_MSG = "loginMsg";

	/**
	 * @Param this is the model attribute for email related notifications
	 */
	String EMAIL_NOTIFICATION = "emailNotification";

	/**
	 * @Param below constants are used for referring 'userloginForm' logical view
	 *        pages
	 */
	String LOGICAL_USER_LOGIN_FORM = "userloginForm";

	/**
	 * @Param below constants are used for referring 'userSignupForm' logical view
	 *        pages
	 */
	String LOGICAL_USER_SIGNUP_FORM = "userSignupForm";

	/**
	 * @Param below constants are used for referring 'userAccountUnlockForm' logical
	 *        view pages
	 */
	String LOGICAL_USER_ACC_UNLOCK_FORM = "userAccountUnlockForm";

	/**
	 * @Param below constants are used for referring 'Dashboard' logical view
	 *        pages
	 */
	String LOGICAL_USER_DASHBOARD = "Dashboard";
	/**
	 * @Param below constants are used for referring 'Dashboard' logical view
	 *        pages
	 */
	String LOGICAL_USER_FORGOTPASSWORD = "forgotpassword";
	
}
