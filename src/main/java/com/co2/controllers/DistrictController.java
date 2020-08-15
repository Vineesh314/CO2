package com.co2.controllers;

import com.co2.exceptions.DistrictNotFoundException;
import com.co2.models.District;
import com.co2.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DistrictController {

    @Autowired
    private DistrictRepository repository;

    // Find
    @GetMapping("/districts")
    List<District> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/districts")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    District newDistrict(@RequestBody District newDistrict) {
        return repository.save(newDistrict);
    }

    // Find
    @GetMapping("/districts/{id}")
    District findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DistrictNotFoundException(id));
    }

    // Save or update
    @PutMapping("/districts/{id}")
    District saveOrUpdate(@RequestBody District newDistrict, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setDistrictId(newDistrict.getDistrictId());
                    x.setDistrictCode(newDistrict.getDistrictCode());
                    x.setDistrictName(newDistrict.getDistrictName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	newDistrict.setDistrictId(id);
                    return repository.save(newDistrict);
                });
    }

    // update name only
    @PatchMapping("/districts/{id}")
    District patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String districtName = update.get("districtName");
                    if (!StringUtils.isEmpty(districtName)) {
                        x.setDistrictName(districtName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new DistrictNotFoundException(id);
                    }

                })
                .orElseGet(() -> {
                    throw new DistrictNotFoundException(id);
                });

    }

    @DeleteMapping("/districts/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
