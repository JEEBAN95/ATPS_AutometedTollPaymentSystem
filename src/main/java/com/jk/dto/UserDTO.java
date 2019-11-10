package com.jk.dto;

import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable {
	
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNum;
	private Date dob;
	private String gender;
	private String password;
	
	private String newPassword;
	private String confirmPassword;
}
