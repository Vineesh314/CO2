package com.co2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.co2.models.Client;
import com.co2.repositories.ClientRepository;

@SpringBootApplication
public class StartCO2Application {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartCO2Application.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(ClientRepository repository) {
        return args -> {
            repository.save(new Client(1L,"TOY","Toyota Motors"));
            repository.save(new Client(2L,"NIS","Nissan Vehicles"));
            repository.save(new Client(3l,"APL","Apollo Hospitals"));
        };
    }
}