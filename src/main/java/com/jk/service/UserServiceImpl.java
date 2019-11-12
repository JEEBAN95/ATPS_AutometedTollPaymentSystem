package com.jk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jk.commonsUtils.ApplicationConstants;
import com.jk.commonsUtils.TemporaryPasswordGenerator;
import com.jk.dto.UserDTO;
import com.jk.entity.User;
import com.jk.mailsenderUtils.MailSenderConfig;
import com.jk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private Environment env;
	@Autowired
	MailSenderConfig mailSender;

	/**
	 * @param userRepo not null
	 * @param userDto not null
	 * @apiNote save data send uname, pass, mail addr to user's mail
	 * @apiNote this is used for saving the user's information
	 */
	@Override
	public User saveUser(UserDTO userDto) throws Exception {
		User userEntity = new User();
		boolean isSent = false;
		BeanUtils.copyProperties(userDto, userEntity);
		String tempPwd = TemporaryPasswordGenerator
				.getAlphaNumericString(Integer.parseInt(env.getProperty("passwordlength")));
		userEntity.setRole(ApplicationConstants.DefaultRole);
		userEntity.setPassword(tempPwd);

		List<User> userList = userRepo.getUserByEmail(userDto.getEmail());
		if (userList.size() == 0) {
			userEntity = userRepo.save(userEntity);
			//isSent = mailSender.sendMail(userEntity);
			return userEntity;
		}
		System.out.println("Mail Status-------------->" + isSent);
		return null;
	}// saveUser

	/**
	 * @category userRepo not null
	 * @param uid not '0'
	 * @apiNote used userRepo for getting users details
	 */
	@Override
	public User getUserByID(int uid) {
		User userEntity = null;
		Optional<User> optUserEntity = userRepo.findById(uid);
		if (optUserEntity.isPresent()) {
			userEntity = optUserEntity.get();
		} // if
		return userEntity;
	}// getUserByID

	/**
	 * @param userDto not null 
	 * @apiNote use userRepo get data using email  and update password
	 */
	@Override
	public User updateUser(UserDTO userDto) throws Exception {
		User userEntity = null;
		if (userDto.getNewPassword().equals(userDto.getConfirmPassword())) {
			userEntity = userRepo.getUserByEmail(userDto.getEmail()).get(0);

			if (userEntity.getPassword().equals(userDto.getPassword())) {
				userEntity.setPassword(userDto.getNewPassword());
				userEntity = userRepo.save(userEntity);
			}
		}
		return userEntity;
	}// updateUser

	/**
	 * @apiNote user userRepo check the credentials provided by the user called by
	 * @param UserLoginController
	 */
	@Override
	public User userLogin(UserDTO userDto) throws Exception {
		User userEntity = userRepo.getUserByEmail(userDto.getEmail()).get(0);
		if (userDto.getEmail().equals(userEntity.getEmail()) && userDto.getPassword().equals(userEntity.getPassword()))
			return userEntity;
		else
			return null;
	}// userLogin
}
