package com.co2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.co2.exceptions.DistrictNotFoundException;
import com.co2.models.CO2Reading;
import com.co2.repositories.Co2ReadingRepository;
import com.co2.services.Co2ReadingService;

@RestController
public class Co2Controller {

    @Autowired
    private Co2ReadingRepository repository;
    
    @Autowired
    private Co2ReadingService co2ReadingService;

    // Save
    @PostMapping("/co2reading")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    CO2Reading newCo2reading(@RequestBody CO2Reading newCO2Reading) {
        return repository.save(newCO2Reading);
    }

    // Find
    @GetMapping("/co2reading/{id}")
    CO2Reading findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DistrictNotFoundException(id));
    }

    // Save or update
    @PutMapping("/co2reading/{id}")
    CO2Reading saveOrUpdate(@RequestBody CO2Reading newCO2Reading, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setDistrictId(newCO2Reading.getDistrictId());
                    x.setCityId(newCO2Reading.getCityId());
                    x.setClientId(newCO2Reading.getClientId());
                    x.setConcentration(newCO2Reading.getConcentration());
                    x.setSensorId(newCO2Reading.getSensorId());
                    x.setDateTime(newCO2Reading.getDateTime());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	newCO2Reading.setDistrictId(id);
                    return repository.save(newCO2Reading);
                });
    }


    @DeleteMapping("/co2reading/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
