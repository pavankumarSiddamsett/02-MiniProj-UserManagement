package com.pathanam.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathanam.entity.City;
import com.pathanam.stateNameCode.CityNames;

public interface CityRepository extends JpaRepository<City, Serializable>{
	
List<CityNames> findByStateId(Integer stateId);
	
}
