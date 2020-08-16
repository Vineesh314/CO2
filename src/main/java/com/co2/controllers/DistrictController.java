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

import com.co2.models.District;
import com.co2.services.DistrictService;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    // Find
    @GetMapping("/districts")
    List<District> findAll() {
        return districtService.findAll();
    }

    // Save
    @PostMapping("/districts")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    District newDistrict(@RequestBody District newDistrict) {
        return districtService.save(newDistrict);
    }

    // Find
    @GetMapping("/districts/{id}")
    District findOne(@PathVariable Long id) {
        return districtService.findById(id);
    }

    // Save or update
    @PutMapping("/districts/{id}")
    District saveOrUpdate(@RequestBody District newDistrict, @PathVariable Long id) {
    	return districtService.saveOrUpdate(newDistrict,id);

    }

    // update name only
    @PatchMapping("/districts/{id}")
    District patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
    	return districtService.patch(update,id);

    }

    @DeleteMapping("/districts/{id}")
    void deleteClient(@PathVariable Long id) {
		districtService.deleteById(id);
    }

}
