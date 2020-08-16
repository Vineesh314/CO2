package com.co2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.co2.exceptions.SensorNotFoundException;
import com.co2.models.Sensor;
import com.co2.repositories.SensorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Api
@RestController
public class SensorController {
	
	@Autowired
	private SensorRepository repository;

	
	@ApiOperation(value = "List sensor", notes = "This service is to list all sensors configured", tags = {"Sensor"}, httpMethod = "GET")
	@GetMapping("/sensors")
	public List<Sensor> findAll() {
		return repository.findAll();
	}
	
	//Save
	@ApiOperation(value = "Save sensor", notes = "This service is to save sensor info", tags = {"Sensor"}, httpMethod = "POST")
	@PostMapping("/sensors")
	//return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
	Sensor newSensor(@RequestBody Sensor newSensor) {
		return repository.save(newSensor);
	}

	// Find
	@ApiOperation(value = "Find sensor by id", notes = "This service is to fetch a single sensor info", tags = {"Sensor"}, httpMethod = "GET")
    @GetMapping("/sensors/{id}")
	Sensor findOne(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new SensorNotFoundException(id));
	}
	
	// Save or update
	@ApiOperation(value = "Update or Save sensor", notes = "This service is to update or save sensor info", tags = {"Sensor"}, httpMethod = "PUT")
    @PutMapping("/sensors/{id}")
    Sensor saveOrUpdate(@RequestBody Sensor newSensor, @PathVariable Long id) {
    	return repository.findById(id)
    			.map(x -> {
    				x.setSensorId(newSensor.getSensorId());
    				x.setSensorName(newSensor.getSensorName());
    				x.setSensorCode(newSensor.getSensorCode());
    				return repository.save(x);
    			})
    			.orElseGet(() -> {
    				newSensor.setSensorId(id);
    				return repository.save(newSensor);
    			});
    }
    
	// update name only
	@ApiOperation(value = "Update sensor by id", notes = "This service is to update a single sensor info", tags = {"Sensor"}, httpMethod = "PATCH")
    @PatchMapping("/sensors/{id}")
    Sensor patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String sensorName = update.get("sensorName");
                    if (!StringUtils.isEmpty(sensorName)) {
                        x.setSensorName(sensorName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new SensorNotFoundException(id);
                    }

                })
                .orElseGet(() -> {
                    throw new SensorNotFoundException(id);
                });
    }
    
	@ApiOperation(value = "Delete sensor by id", notes = "This service is to delete a single sensor", tags = {"Sensor"}, httpMethod = "DELETE")
    @DeleteMapping("/sensors/{id}")
    void deleteSensor(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
