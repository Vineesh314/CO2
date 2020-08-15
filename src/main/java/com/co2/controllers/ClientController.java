package com.co2.controllers;

import com.co2.exceptions.ClientNotFoundException;
import com.co2.models.Client;
import com.co2.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository repository;

    // Find
    @GetMapping("/clients")
    List<Client> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/clients")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    // Find
    @GetMapping("/clients/{id}")
    Client findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    // Save or update
    @PutMapping("/clients/{id}")
    Client saveOrUpdate(@RequestBody Client newClient, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setClientId(newClient.getClientId());
                    x.setClientCode(newClient.getClientCode());
                    x.setClientName(newClient.getClientName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newClient.setClientId(id);
                    return repository.save(newClient);
                });
    }

    // update name only
    @PatchMapping("/clients/{id}")
    Client patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String clientName = update.get("clientName");
                    if (!StringUtils.isEmpty(clientName)) {
                        x.setClientName(clientName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new ClientNotFoundException(id);
                    }

                })
                .orElseGet(() -> {
                    throw new ClientNotFoundException(id);
                });

    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
