package com.pathanam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_REGISTRATION_DTLS")
public class UserMaster {

	@Id
	@SequenceGenerator(name = "USER_SEQ_ID", sequenceName = "USER_REG_SEQ_ID", allocationSize = 1)
	@GeneratedValue(generator = "USER_SEQ_ID", strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private Integer uid;
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	@Column(name = "PHN_NUM", length = 10, nullable = false)
	private Long phno;
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private Date dob;
	@Column(name = "GENDER", length = 1, nullable = false)
	private String gender;
	@Column(name = "COUNTRY", length = 50, nullable = false)
	private String country;
	@Column(name = "STATE", length = 50, nullable = false)
	private String state;
	@Column(name = "CITY", length = 50, nullable = false)
	private String city;
	@Column(name = "PASSWORD", nullable = false)
	private String pwd;
	@Column(name = "ACC_STATUS", length = 1, nullable = false)
	private String accStatus;

}
