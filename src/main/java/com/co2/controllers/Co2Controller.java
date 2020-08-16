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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Api
@RestController
public class Co2Controller {
    
    @Autowired
    private Co2ReadingService co2ReadingService;

    
    @ApiOperation(value = "Get CO2 report", notes = "This service is to get CO2 report based on type parameter", tags = {"CO2 Reading"}, httpMethod = "GET")
    @GetMapping("/co2report/{type}")
    public Co2ReadingMarkerInterface Co2readings(@PathVariable Type type, @RequestParam("clientId") Long clientId) {
    	return co2ReadingService.getCo2Reports(type,clientId);
	}
    
    // Save
    @ApiOperation(value = "Save CO2 Reading", notes = "This service is to save CO2 reading from sensor", tags = {"CO2 Reading"}, httpMethod = "POST")
    @PostMapping("/co2reading")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    CO2Reading newCo2reading(@RequestBody CO2Reading newCO2Reading) {
    	return co2ReadingService.save(newCO2Reading);
    }

    // Find
    @ApiOperation(value = "Find CO2 reading", notes = "This service is to fetch a single CO2 reading", tags = {"CO2 Reading"}, httpMethod = "GET")
    @GetMapping("/co2reading/{id}")
    CO2Reading findOne(@PathVariable Long id) {
    	return co2ReadingService.findById(id);
    }

    // Save or update
    @ApiOperation(value = "Save or Update CO2 reading", notes = "This service is to save or update CO2 reading", tags = {"CO2 Reading"}, httpMethod = "PUT")
    @PutMapping("/co2reading/{id}")
    CO2Reading saveOrUpdate(@RequestBody CO2Reading newCO2Reading, @PathVariable Long id) {
    	return co2ReadingService.saveOrUpdate(id, newCO2Reading);
    }

    @ApiOperation(value = "Delete a single CO2 reading by id", notes = "This service is to delete a single CO2 reading", tags = {"CO2 Reading"}, httpMethod = "DELETE")
    @DeleteMapping("/co2reading/{id}")
    void deleteClient(@PathVariable Long id) {
    	co2ReadingService.deleteById(id);
    }

}
