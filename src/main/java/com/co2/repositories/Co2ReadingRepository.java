package com.co2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co2.models.CO2Reading;

public interface Co2ReadingRepository extends JpaRepository<CO2Reading, Long> {
}
