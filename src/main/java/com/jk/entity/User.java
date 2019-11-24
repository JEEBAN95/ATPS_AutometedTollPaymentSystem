package com.jk.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User implements Serializable {
	private static final long serialVersionUID = 5887763953884053517L;
	
	@Id
	@Column(name = "UID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UID_SEQ")
	private int uid;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "ACCOUNT_STATUS", nullable = false)
	private String accStatus;
	@Column(name = "ACTIVE_STATUS" , nullable = false)
	private String isActive;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NUM", nullable = false)
	private long phoneNum;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "CREATE_DT", updatable = false)
	@CreationTimestamp
	private Timestamp createDate;
	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private Timestamp updateDate;
	@Column(name = "USER_ROLE")
	private String role;
}
