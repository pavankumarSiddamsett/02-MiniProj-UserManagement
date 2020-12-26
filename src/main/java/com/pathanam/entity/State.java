package com.pathanam.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "STATE")
public class State {

	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATe_NAME")
	private String stateName;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
}
