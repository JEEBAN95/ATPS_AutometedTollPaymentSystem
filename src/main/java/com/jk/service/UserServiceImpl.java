package com.jk.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jk.dto.UserDTO;
import com.jk.commons.Infomessages;
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
	// save data
	@Override
	public User saveUser(UserDTO userDto) {
		User userEntity = new User();
		BeanUtils.copyProperties(userDto, userEntity);
		String tempPwd = TemporaryPasswordGenerator
				.getAlphaNumericString(Integer.parseInt(env.getProperty("passwordlength")));
		userEntity.setRole(Infomessages.DefaultRole);
		userEntity.setPassword(tempPwd);
		userEntity = userRepo.save(userEntity);
		System.out.println(userEntity);
		return userEntity;
	}// saveUser

	// use userRepo
	// get data
	@Override
	public User getUserByID(int uid) {
		User userEntity = null;
		Optional<User> optUserEntity = userRepo.findById(uid);
		if (optUserEntity.isPresent()) {
			userEntity = optUserEntity.get();
		} // if
		return userEntity;
	}// getUserByID

	// use userRepo
	// get data using email
	// update data
	@Override
	public User updateUser(UserDTO userDto) {
		User userEntity = userRepo.getUserByEmail(userDto.getEmail());
		if (userEntity.getPassword().equals(userDto.getPassword())
				&& userDto.getNewPassword().equals(userDto.getConfirmPassword())) {
			userEntity.setPassword(userDto.getNewPassword());
			userEntity = userRepo.save(userEntity);
		}
		return userEntity;
	}// updateUser

	// user userRepo
	// check the credentials provided by the user
	@Override
	public User userLogin(UserDTO userDto) {
		User userEntity = userRepo.getUserByEmail(userDto.getEmail());
		if (userDto.getEmail().equals(userEntity.getEmail()) && userDto.getPassword().equals(userEntity.getPassword()))
			return userEntity;
		else
			return null;
	}// userLogin
}
