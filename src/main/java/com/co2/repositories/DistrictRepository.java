package com.co2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.co2.models.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
	
	List<District> findByCity_cityId(Long cityId);
	
	Integer countDistinctSensorBydistrictId(Long districtId);
	
}
