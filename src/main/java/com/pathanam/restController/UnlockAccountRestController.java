package com.pathanam.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pathanam.model.ChangePassword;
import com.pathanam.service.UserMasterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UnlockAccountRestController {
	@Autowired
	private UserMasterService userService;

	
	@PostMapping("/unlockAccount")
	public String handleUnlockSubmitBtn(@RequestBody ChangePassword chngePwd) {
		boolean tempPwdValid = userService.isTempPwdValid(chngePwd.getEmail(), chngePwd.getTempPwd());
		if(tempPwdValid) {
		boolean isUnlockAccount = userService.unlockAccount(chngePwd.getEmail(), chngePwd.getNewPwd());
			if(isUnlockAccount) {
				return "Your Account is unlocked Proceed with login";
			}else {
				return "failed to unlock your Account";
			}
		}
		return "Your temporary Password is incorrect";
}
	

}
