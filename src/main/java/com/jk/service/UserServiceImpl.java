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
	 * @param userDto  not null
	 * @throws Exception
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
		userEntity.setRole(ApplicationConstants.DEFAULT_ROLE);
		userEntity.setAccStatus(ApplicationConstants.USER_LOCKED);
		userEntity.setPassword(tempPwd);
		userEntity.setIsActive("Y");
		List<User> userList = userRepo.getUserByEmail(userDto.getEmail());
		if (userList.size() == 0) {
			userEntity = userRepo.save(userEntity);
			isSent = mailSender.sendMail(userEntity);
			return userEntity;
		}
		System.out.println("Status------->" + isSent);
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
	 * @apiNote use userRepo get data using email and update password
	 */
	@Override
	public User updateUser(UserDTO userDto) throws Exception {
		System.out.println("UserServiceImpl.updateUser()");
		User userEntity = null;
		if (userDto.getNewPassword().equals(userDto.getConfirmPassword())) {
			userEntity = userRepo.getUserByEmail(userDto.getEmail()).get(0);
			if (userEntity.getPassword().equals(userDto.getPassword())) {
				userEntity.setPassword(userDto.getNewPassword());
				userEntity.setAccStatus(ApplicationConstants.USER_UnLOCKED);
				userEntity = userRepo.save(userEntity);
			}
			return userEntity;
		} else
			return null;
	}// updateUser

	/**
	 * @apiNote user userRepo check the credentials provided by the user called by
	 * @param UserLoginController
	 */
	@Override
	public User userLogin(UserDTO userDto) throws Exception {
		User userEntity = userRepo.getUserByEmail(userDto.getEmail()).get(0);
		if (userDto.getEmail().equals(userEntity.getEmail()) && userDto.getPassword().equals(userEntity.getPassword()))
			if (userEntity.getAccStatus().equalsIgnoreCase(ApplicationConstants.USER_UnLOCKED)) {
				if (userEntity.getIsActive().equalsIgnoreCase("Y")) {
					return userEntity;
				}
			}
		return null;
	}// userLogin

	/**
	 * @apiNote this method is used for forgot password link to search whether the User's email is available or not ?
	 */
	@Override
	public User searchUserByEmail(String email) throws Exception {
		User userEntity = new User();
		boolean isSent = false;
		userEntity.setEmail(email);
		userEntity = userRepo.getUserByEmail(userEntity.getEmail()).get(0);
		isSent = mailSender.sendMailAsResetPwd(userEntity);
		System.out.println("Passsword sent------------------------------->"+isSent);
		return userEntity;
	}
}// class
