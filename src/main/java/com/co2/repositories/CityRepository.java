package com.co2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co2.models.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	List<City> findByClient_clientId(Long clientId);
}
