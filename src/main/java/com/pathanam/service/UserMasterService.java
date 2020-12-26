package com.pathanam.service;


import java.util.Map;

import com.pathanam.entity.UserMaster;





public interface UserMasterService {

//login page operation
public String loginCheck(String email,String pwd);
//unlock Account Operation
public boolean isTempPwdValid(String email,String tempPwd);
public boolean unlockAccount(String email,String newPwd);

//public String sendForgotPasswordToMail(UserRegistration user);
//public String sendUnlockAccountLinkToMail(UserRegistration user);
//public String genrateRandomPwd();
//Registration page operations
public boolean saveUser(UserMaster um);
public boolean isEmailUnique(String emailId);
public Map<Integer, String> findCountries();
public Map<Integer,String> findStates(Integer countryId);
public Map<Integer,String> findCities(Integer stateId);
//forgot password operation
public String forgotPassword(String email);
}
