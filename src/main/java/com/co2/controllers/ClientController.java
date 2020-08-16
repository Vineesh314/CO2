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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Api
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Find
    @ApiOperation(value = "List all clients", notes = "This service is to list all clients configured", tags = {"Client"}, httpMethod = "GET")
    @GetMapping("/clients")
    List<Client> findAll() {
        return clientService.findAll();
    }

    // Save
    @ApiOperation(value = "Save client", notes = "This service is to save client info", tags = {"Client"}, httpMethod = "POST")
    @PostMapping("/clients")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Client newClient(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

    // Find
    @ApiOperation(value = "Find client by id", notes = "This service is to fetch a single client info", tags = {"Client"}, httpMethod = "GET")
    @GetMapping("/clients/{id}")
    Client findOne(@PathVariable Long id) {
        return clientService.findById(id);
    }

    // Save or update
    @ApiOperation(value = "Update or Save client", notes = "This service is to update or save client info", tags = {"Client"}, httpMethod = "PUT")
    @PutMapping("/clients/{id}")
    Client saveOrUpdate(@RequestBody Client newClient, @PathVariable Long id) {
    	return clientService.saveOrUpdate(newClient,id);
    }

    // update name only
    @ApiOperation(value = "Update client by id", notes = "This service is to update a single client info", tags = {"Client"}, httpMethod = "PATCH")
    @PatchMapping("/clients/{id}")
    Client patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
    	return clientService.patch(update,id);
    }

    @ApiOperation(value = "Delete client by id", notes = "This service is to delete a single client", tags = {"Client"}, httpMethod = "DELETE")
    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
    	clientService.deleteClient(id);
    }

}
