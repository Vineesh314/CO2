package com.co2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.co2.models.CO2Reading;
import com.co2.models.Co2ReadingMarkerInterface;
import com.co2.models.Type;
import com.co2.services.Co2ReadingService;

@RestController
public class Co2Controller {
    
    @Autowired
    private Co2ReadingService co2ReadingService;

    @GetMapping("/co2report/{type}")
    public Co2ReadingMarkerInterface Co2readings(@PathVariable Type type, @RequestParam("clientId") Long clientId) {
    	return co2ReadingService.getCo2Reports(type,clientId);
		
	}
    
    // Save
    @PostMapping("/co2reading")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    CO2Reading newCo2reading(@RequestBody CO2Reading newCO2Reading) {
    	return co2ReadingService.save(newCO2Reading);
    }

    // Find
    @GetMapping("/co2reading/{id}")
    CO2Reading findOne(@PathVariable Long id) {
    	return co2ReadingService.findById(id);
                
    }

    // Save or update
    @PutMapping("/co2reading/{id}")
    CO2Reading saveOrUpdate(@RequestBody CO2Reading newCO2Reading, @PathVariable Long id) {
    	return co2ReadingService.saveOrUpdate(id, newCO2Reading);

    }


    @DeleteMapping("/co2reading/{id}")
    void deleteClient(@PathVariable Long id) {
    	co2ReadingService.deleteById(id);
    }

}
