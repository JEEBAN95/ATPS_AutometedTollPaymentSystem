package com.jk.service;

import com.jk.dto.UserDTO;
import com.jk.entity.User;

public interface UserService {
	public User saveUser(UserDTO userDto);
	public User getUserByID(int uid);
}
