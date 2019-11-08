package com.jk.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "UID")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "UID_SEQ")
	private int uid;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false) 
	private String lastName;
	@Column(name = "EMAIL" )
	private String email;
	@Column(name = "PHONE_NUM", nullable = false)
	private long phoneNum;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Version
	@Column(name ="STATUS")
	private int status;
}
