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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Api
@RestController
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    // Find
    @ApiOperation(value = "List all districts", notes = "This service is to list all districts configured", tags = {"District"}, httpMethod = "GET")
    @GetMapping("/districts")
    List<District> findAll() {
        return districtService.findAll();
    }

    // Save
    @ApiOperation(value = "Save district", notes = "This service is to save district info", tags = {"District"}, httpMethod = "POST")
    @PostMapping("/districts")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    District newDistrict(@RequestBody District newDistrict) {
        return districtService.save(newDistrict);
    }

    // Find
    @ApiOperation(value = "Find district by id", notes = "This service is to fetch a single district info", tags = {"District"}, httpMethod = "GET")
    @GetMapping("/districts/{id}")
    District findOne(@PathVariable Long id) {
        return districtService.findById(id);
    }

    // Save or update
    @ApiOperation(value = "Update or Save district", notes = "This service is to update or save district info", tags = {"District"}, httpMethod = "PUT")
    @PutMapping("/districts/{id}")
    District saveOrUpdate(@RequestBody District newDistrict, @PathVariable Long id) {
    	return districtService.saveOrUpdate(newDistrict,id);
    }

    // update name only
    @ApiOperation(value = "Update district by id", notes = "This service is to update a single district info", tags = {"District"}, httpMethod = "PATCH")
    @PatchMapping("/districts/{id}")
    District patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
    	return districtService.patch(update,id);
    }

    @ApiOperation(value = "Delete district by id", notes = "This service is to delete a single district", tags = {"District"}, httpMethod = "DELETE")
    @DeleteMapping("/districts/{id}")
    void deleteClient(@PathVariable Long id) {
		districtService.deleteById(id);
    }

}