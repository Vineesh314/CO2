package com.co2.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.co2.exceptions.CityNotFoundException;
import com.co2.models.City;
import com.co2.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public City save(City newCity) {
		return cityRepository.save(newCity);
	}

	public City findById(Long id) {
		return cityRepository.findById(id).get();
	}
	
	public List<City> findByClient_Id(Long clientId) {
		return cityRepository.findByClient_clientId(clientId);
	}
	public City saveOrUpdate(City newCity, Long id) {
		return cityRepository.findById(id).map(x -> {
			x.setCityId(newCity.getCityId());
			x.setCityCode(newCity.getCityCode());
			x.setCityName(newCity.getCityName());
			//x.setClient(newCity.getClient());
			return cityRepository.save(x);
		}).orElseGet(() -> {
			newCity.setCityId(id);
			return cityRepository.save(newCity);
		});
	}

	public City patch(Map<String, String> update, Long id) {
		return cityRepository.findById(id).map(x -> {

			String cityName = update.get("cityName");
			if (!StringUtils.isEmpty(cityName)) {
				x.setCityName(cityName);

				// better create a custom method to update a value = :newValue where id = :id
				return cityRepository.save(x);
			} else {
				throw new CityNotFoundException(id);
			}

		}).orElseGet(() -> {
			throw new CityNotFoundException(id);
		});
	}

	public void deleteById(Long id) {

		cityRepository.deleteById(id);
	}

}
