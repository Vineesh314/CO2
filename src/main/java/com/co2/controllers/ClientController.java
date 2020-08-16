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

import com.co2.models.Client;
import com.co2.services.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Find
    @GetMapping("/clients")
    List<Client> findAll() {
        return clientService.findAll();
    }

    // Save
    @PostMapping("/clients")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Client newClient(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

    // Find
    @GetMapping("/clients/{id}")
    Client findOne(@PathVariable Long id) {
        return clientService.findById(id);
    }

    // Save or update
    @PutMapping("/clients/{id}")
    Client saveOrUpdate(@RequestBody Client newClient, @PathVariable Long id) {

    	return clientService.saveOrUpdate(newClient,id);

    }

    // update name only
    @PatchMapping("/clients/{id}")
    Client patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

    	return clientService.patch(update,id);


    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
    	clientService.deleteClient(id);
    }

}
