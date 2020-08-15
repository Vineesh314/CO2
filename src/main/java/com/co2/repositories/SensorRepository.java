package com.co2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co2.models.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
