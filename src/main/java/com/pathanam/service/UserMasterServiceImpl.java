package com.pathanam.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pathanam.entity.Country;
import com.pathanam.entity.UserMaster;
import com.pathanam.repository.CityRepository;
import com.pathanam.repository.CountryRepository;
import com.pathanam.repository.StateRepository;
import com.pathanam.repository.UserMasterRepository;
import com.pathanam.stateNameCode.CityNames;
import com.pathanam.stateNameCode.StateNames;

@Service
public class UserMasterServiceImpl implements UserMasterService {
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private UserMasterRepository userRepo;
	

	@Override
	public String loginCheck(String email, String pwd) {
		//String textMsg="";
		UserMaster userMaster = userRepo.findByEmailAndPwd(email, pwd);
		 if(userMaster !=null){
	            if(userMaster.getAccStatus().equals("LOCKED")){
	                     return "Your Account is Locked";
	            }
	            return "Login Successfully";
	        }
	            return"Invalid Credentials";
	       	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
UserMaster userMaster = userRepo.findByEmailAndPwd(email, tempPwd);
		if(userMaster!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
		UserMaster userMaster = userRepo.findByEmail(email);
		userMaster.setPwd(newPwd);
		userMaster.setAccStatus("UNLOCKED");
		UserMaster updateObj = userRepo.save(userMaster);
		return updateObj.getUid()!=null;
		
	}

	@Override
	public boolean saveUser(UserMaster um) {
		 final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 int len=8;
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < len; i++) {
	            int randomIndex = random.nextInt(chars.length());
	            sb.append(chars.charAt(randomIndex));
	        }
	        um.setPwd(sb.toString());
	        um.setAccStatus("LOCKED");
	        UserMaster savedObj = userRepo.save(um);
	        
		return savedObj.getUid()!=null;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
	  UserMaster userMaster = userRepo.findByEmail(emailId);
		return userMaster.getUid()!=null;
		}
	  	

	@Override
	public Map<Integer, String> findCountries() {
		Map<Integer,String> countriesMap=new HashMap<>();
		List<Country> countriesList = countryRepo.findAll();
		countriesList.forEach(cntry->{
		countriesMap.put(cntry.getCountryId(), cntry.getCountryName());
		});
		return countriesMap;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		Map<Integer,String> statesMap=new HashMap<>();
		List<StateNames> statesList = stateRepo.findByCountryId(countryId);
		statesList.forEach(st->{
			statesMap.put(st.getStateId(), st.getStateName());
		});
		return statesMap;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer,String> citiesMap=new HashMap<>();
		List<CityNames> citiesList = cityRepo.findByStateId(stateId);
		citiesList.forEach(ct->{
			citiesMap.put(ct.getCityId(), ct.getCityName());
		});
		return citiesMap;
	}

	@Override
	public String forgotPassword(String email) {
		UserMaster userDetails= userRepo.findByEmail(email);
		if(userDetails!=null) {
			return userDetails.getPwd();
		}
		return null;
	}
}

	



