package com.jk.service;

import com.jk.dto.UserDTO;
import com.jk.entity.User;

public interface UserService {
	public User saveUser(UserDTO userDto) throws Exception;
	public User getUserByID(int uid);
	public User updateUser(UserDTO userDto) throws Exception;
	public User userLogin(UserDTO userDto) throws Exception;
	public User searchUserByEmail(String  email) throws  Exception;
}
