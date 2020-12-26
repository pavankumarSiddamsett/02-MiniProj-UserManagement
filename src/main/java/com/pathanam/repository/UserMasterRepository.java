package com.pathanam.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pathanam.entity.UserMaster;







public interface UserMasterRepository extends JpaRepository<UserMaster, Serializable> {

	//public UserMaster findByEmail(String email);
	//public int countByEmail(String email);
	public UserMaster findByEmailAndPwd(String email,String pwd);
	public UserMaster findByEmail(String email);
	//public UserEmailPwd findByEmailAndPwd(String email,String pwd);
	//@Query("UPDATE USER_MASTER UM SET UM.PWD=:newPwd,UM.ACC_STATUS=:accStatus WHERE UM.EMAIL=:email")
	//public int unlockUserAccountStatus(String email,String newPwd,String accStatus);
}
