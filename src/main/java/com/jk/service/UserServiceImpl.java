package com.jk.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jk.dto.UserDTO;
import com.jk.commons.TemporaryPasswordGenerator;
import com.jk.entity.User;
import com.jk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private Environment env;

	// use userRepo
	//save data
	@Override
	public User saveUser(UserDTO userDto) {
		User userEntity = new User();
		BeanUtils.copyProperties(userDto, userEntity);
		String tempPwd = TemporaryPasswordGenerator
				.getAlphaNumericString(Integer.parseInt(env.getProperty("passwordlength")));
		userEntity.setPassword(tempPwd);
		userEntity = userRepo.save(userEntity);
		System.out.println(userEntity);
		return userEntity;
	}//saveUser

	//use userRepo
	//get data
	@Override
	public User getUserByID(int uid) {
		User userEntity = null;
		Optional<User> optUserEntity = userRepo.findById(uid);
		if(optUserEntity.isPresent()) {
			userEntity = optUserEntity.get();
		}//if
		return userEntity;
	}//getUserByID
}
