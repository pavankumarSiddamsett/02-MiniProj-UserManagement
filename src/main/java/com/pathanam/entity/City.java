package com.pathanam.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="CITY")
public class City {
	
	@Id
	@Column(name="CITY_ID")
	private Integer cityId;
	@Column(name="CITY_NAME")
	private String cityName;
	@Column(name="STATE_CODE")
	private String stateCode;
}
