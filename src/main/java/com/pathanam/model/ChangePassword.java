package com.pathanam.model;

import lombok.Data;

@Data
public class ChangePassword {

	private String email;
	private String tempPwd;
	private String newPwd;
	private String cnfrmPwd;
}
