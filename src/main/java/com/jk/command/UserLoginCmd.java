package com.jk.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserLoginCmd {
	private String email;
	private String password;
}
