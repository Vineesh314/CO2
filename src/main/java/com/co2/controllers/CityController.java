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

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	// Find
	@GetMapping("/cities")
	List<City> findAll() {
		return cityService.findAll();
	}

	// Save
	@PostMapping("/cities")
	// return 201 instead of 200
	@ResponseStatus(HttpStatus.CREATED)
	City newCity(@RequestBody City newCity) {
		return cityService.save(newCity);
	}

	// Find
	@GetMapping("/cities/{id}")
	City findOne(@PathVariable Long id) {
		return cityService.findById(id);
	}

	// Save or update
	@PutMapping("/cities/{id}")
	City saveOrUpdate(@RequestBody City newCity, @PathVariable Long id) {

		return cityService.saveOrUpdate(newCity, id);

	}

	// update name only
	@PatchMapping("/cities/{id}")
	City patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

		return cityService.patch(update, id);

	}

	@DeleteMapping("/cities/{id}")
	void deleteClient(@PathVariable Long id) {
		cityService.deleteById(id);
	}

}
