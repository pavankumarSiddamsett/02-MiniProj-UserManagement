package com.pathanam.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathanam.entity.State;
import com.pathanam.stateNameCode.StateNames;

public interface StateRepository extends JpaRepository<State, Serializable>{

	List<StateNames> findByCountryId(Integer countryId);
}
