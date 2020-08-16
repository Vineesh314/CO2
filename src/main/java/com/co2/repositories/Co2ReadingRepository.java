package com.co2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co2.models.CO2Reading;

public interface Co2ReadingRepository extends JpaRepository<CO2Reading, Long> {
	
	List<CO2Reading> findByClient_clientId(Long clientId);
	List<CO2Reading> findByDistrict_districtId(Long districtId);
}
