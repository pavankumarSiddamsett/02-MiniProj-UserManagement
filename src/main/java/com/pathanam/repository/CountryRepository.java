package com.pathanam.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathanam.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable>{

	
}
