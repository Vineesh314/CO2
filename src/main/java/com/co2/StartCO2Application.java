package com.co2;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.co2.models.CO2Reading;
import com.co2.models.City;
import com.co2.models.Client;
import com.co2.models.District;
import com.co2.models.Sensor;
import com.co2.repositories.CityRepository;
import com.co2.repositories.ClientRepository;
import com.co2.repositories.Co2ReadingRepository;
import com.co2.repositories.DistrictRepository;
import com.co2.repositories.SensorRepository;

@SpringBootApplication
public class StartCO2Application {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartCO2Application.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
   CommandLineRunner initDatabase(ClientRepository clientRepository, CityRepository cityRepository,
			DistrictRepository districtRepository, SensorRepository sensorRepository, Co2ReadingRepository co2ReadingRepository) {
		return args -> {
			Client client = new Client(1L, "TOY", "Toyota Motors");
			clientRepository.save(client);
			clientRepository.save(new Client(2L, "NIS", "Nissan Vehicles"));
			clientRepository.save(new Client(3l, "APL", "Apollo Hospitals"));

			City city1 = new City(1L, "MCH", "Munich", client);
			cityRepository.save(city1);
			City city2 = new City(2L, "BLN", "Berlin", client);
			cityRepository.save(city2);

			District district1 = new District(1L, "LEH", "Lehel", city1);
			districtRepository.save(district1);
			district1 = new District(2L, "Sch", "Schwabing ", city1);
			districtRepository.save(district1);

			district1 = new District(3L, "LIC", "Lichtenberg ", city2);
			districtRepository.save(district1);
			district1 = new District(4L, "PAN", "Pankow ", city2);
			districtRepository.save(district1);

			Sensor sensor1 = new Sensor(1L, "CO2Sensor1", "CO2S1", district1);
			sensorRepository.save(sensor1);

			sensor1 = new Sensor(2L, "CO2Sensor2", "CO2S2", district1);
			sensorRepository.save(sensor1);
			
			Date date = new Date(System.currentTimeMillis());
			co2ReadingRepository.save(new CO2Reading(1L, client, district1, city1,sensor1, 1.02, new java.sql.Date(System.currentTimeMillis())));
			co2ReadingRepository.save(new CO2Reading(1L, client, district1, city1,sensor1, 1.02, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-1)));
			co2ReadingRepository.save(new CO2Reading(3L, client, district1, city1,sensor1, 1.03, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-2)));
			co2ReadingRepository.save(new CO2Reading(4L, client, district1, city1,sensor1, 0.28, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-3)));
			co2ReadingRepository.save(new CO2Reading(5L, client, district1, city1,sensor1, 1.02, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-4)));
			co2ReadingRepository.save(new CO2Reading(6L, client, district1, city1,sensor1, 1.01, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-5)));
			co2ReadingRepository.save(new CO2Reading(7L, client, district1, city1,sensor1, 1.02, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-6)));
			co2ReadingRepository.save(new CO2Reading(8L, client, district2, city1,sensor1, 1.05, new java.sql.Date(System.currentTimeMillis())));
			co2ReadingRepository.save(new CO2Reading(9L, client, district2, city1,sensor1, 1.02, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-1)));
			co2ReadingRepository.save(new CO2Reading(10L, client, district2, city1,sensor1, 0.89, new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()-2)));
			
			
		};
	}
}
