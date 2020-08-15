package com.co2.controllers;

import com.co2.exceptions.CityNotFoundException;
import com.co2.models.City;
import com.co2.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CityController {

    @Autowired
    private CityRepository repository;

    // Find
    @GetMapping("/cities")
    List<City> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/cities")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    City newCity(@RequestBody City newCity) {
        return repository.save(newCity);
    }

    // Find
    @GetMapping("/cities/{id}")
    City findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    // Save or update
    @PutMapping("/cities/{id}")
    City saveOrUpdate(@RequestBody City newCity, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setCityId(newCity.getCityId());
                    x.setCityCode(newCity.getCityCode());
                    x.setCityName(newCity.getCityName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	newCity.setCityId(id);
                    return repository.save(newCity);
                });
    }

    // update name only
    @PatchMapping("/cities/{id}")
    City patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String cityName = update.get("cityName");
                    if (!StringUtils.isEmpty(cityName)) {
                        x.setCityName(cityName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new CityNotFoundException(id);
                    }

                })
                .orElseGet(() -> {
                    throw new CityNotFoundException(id);
                });

    }

    @DeleteMapping("/cities/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
