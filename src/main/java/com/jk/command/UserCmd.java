package com.jk.command;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCmd {
	
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNum;
	private Date dob;
	private String gender;
	
	private String password;
	private String newPassword;
	private String confirmPassword;
	
}
