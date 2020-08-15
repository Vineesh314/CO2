package com.co2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.co2.models.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
}
