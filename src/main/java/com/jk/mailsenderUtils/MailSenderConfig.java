package com.jk.mailsenderUtils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.jk.entity.User;

@Component
public class MailSenderConfig {
	/**
	 * injecting mailsender object is used to send the mail
	 */
	@Autowired
	private JavaMailSender sender;

	/**
	 * this method is used to send the mail and give the boolean that means either
	 * send or not send scenarios
	 * 
	 */
	public boolean sendMail(User userEntity) {
		boolean flag = false;
		final String subject = "no Reply ETPS Registration details";
		final String txt = "Hi " + userEntity.getFirstName() + " " + userEntity.getLastName()
				+ ", Welcome to Electronic Toll Payment System.Your Registration is almost Complete.Please Un-lock your account using below details. Your Temporary Password "
				+ userEntity.getPassword() + "<a href=http://localhost:2525/atps/user-acc-unlock?uid=" + userEntity.getUid()
				+ "> Click Here to Un lock your Account </a>";
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, false);

			helper.setTo(userEntity.getEmail());
			helper.setSubject(subject);
			helper.setText(txt, true);
			sender.send(message);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
