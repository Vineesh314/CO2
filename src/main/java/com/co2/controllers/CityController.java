package com.co2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.co2.models.City;
import com.co2.services.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Api
@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	// Find
	@ApiOperation(value = "List all cities", notes = "This service is to list all cities configured", tags = {"City"}, httpMethod = "GET", produces = "application/xml")
	@GetMapping("/cities")
	List<City> findAll() {
		return cityService.findAll();
	}

	// Save
	@ApiOperation(value = "Save city", notes = "This service is to save city info", tags = {"City"}, httpMethod = "POST")
	@PostMapping("/cities")
	// return 201 instead of 200
	@ResponseStatus(HttpStatus.CREATED)
	City newCity(@RequestBody City newCity) {
		return cityService.save(newCity);
	}

	// Find
	@ApiOperation(value = "Find city by id", notes = "This service is to fetch a single city info", tags = {"City"}, httpMethod = "GET")
	@GetMapping("/cities/{id}")
	City findOne(@PathVariable Long id) {
		return cityService.findById(id);
	}

	// Save or update
	@ApiOperation(value = "Update or Save city", notes = "This service is to update or save city info", tags = {"City"}, httpMethod = "PUT")
	@PutMapping("/cities/{id}")
	City saveOrUpdate(@RequestBody City newCity, @PathVariable Long id) {
		return cityService.saveOrUpdate(newCity, id);
	}

	// update name only
	@ApiOperation(value = "Update city by id", notes = "This service is to update a single city info", tags = {"City"}, httpMethod = "PATCH")
	@PatchMapping("/cities/{id}")
	City patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
		return cityService.patch(update, id);
	}
	
	@ApiOperation(value = "Delete city by id", notes = "This service is to delete a single city", tags = {"City"}, httpMethod = "DELETE")
	@DeleteMapping("/cities/{id}")
	void deleteCity(@PathVariable Long id) {
		cityService.deleteById(id);
	}
	
}