package com.co2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co2.models.CO2Reading;
import com.co2.models.City;
import com.co2.models.Client;
import com.co2.models.ClientCustomDaily;
import com.co2.models.ClientCustomMonthly;
import com.co2.models.ClientCustomWeekly;
import com.co2.models.Co2ReadingMarkerInterface;
import com.co2.models.District;
import com.co2.models.Type;
import com.co2.repositories.Co2ReadingRepository;

@Service
public class Co2ReadingService {

	@Autowired
	private Co2ReadingRepository co2ReadingRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private CityService cityService;

	@Autowired
	private DistrictService districtService;

	public Co2ReadingMarkerInterface getCo2Reports(Type type, Long clientId) {
		Co2ReadingMarkerInterface response = null;
		switch (type) {
		case daily:
			response = getClientCustomDaily(clientId);
			break;
		case weekly:
			response = getClientCustomWeekly(clientId);
			break;
		case monthly:
			response = getClientCustomMonthly(clientId);
			break;
		}
		return response;

	}

	public ClientCustomDaily getClientCustomDaily(Long clientId) {

		Client client = clientService.findById(clientId);
		System.out.println("client===" + client.toString());
		ClientCustomDaily clientCustomDaily=new ClientCustomDaily();
		
		if (client != null) {
			List<City> cityList = cityService.findByClient_Id(clientId);
			System.out.println("cityList===" + cityList.toString());
			for (City city : cityList) {
				System.out.println("city===" + city.toString());
				List<District> districtList = districtService.findByCity_Id(city.getCityId());
				for (District district : districtList) {
					System.out.println("district===" + district.toString());
					Integer sensorCount =districtService.sensorCount(district.getDistrictId());
					System.out.println("SensorCount===" + sensorCount);
					List<CO2Reading> co2ReadingList=co2ReadingRepository.findByDistrict_districtId(district.getDistrictId());
					for(CO2Reading co2Reading:co2ReadingList) {
						System.out.println("co2Reading===" + co2Reading.toString());
					}
				}
			}
		}
		
		List<CO2Reading> co2ReadingList= co2ReadingRepository.findByClient_clientId(clientId);
		for(CO2Reading co2Reading:co2ReadingList) {
			clientCustomDaily.setClientName(co2Reading.getClient().getClientName());
			List<City> cityList = cityService.findByClient_Id(clientId);
		}
		System.out.println("co2ReadingList===" + co2ReadingList.toString());
		return clientCustomDaily;
	}

	public ClientCustomWeekly getClientCustomWeekly(Long clientId) {

		return new ClientCustomWeekly();
	}

	public ClientCustomMonthly getClientCustomMonthly(Long clientId) {

		return new ClientCustomMonthly();
	}

	public CO2Reading save(CO2Reading newCO2Reading) {
		return co2ReadingRepository.save(newCO2Reading);
	}

	public CO2Reading findById(Long id) {
		return co2ReadingRepository.findById(id).get();
	}

	public CO2Reading saveOrUpdate(Long id, CO2Reading newCO2Reading) {
		return co2ReadingRepository.findById(id).map(x -> {
			x.setDistrict(newCO2Reading.getDistrict());
			x.setCity(newCO2Reading.getCity());
			x.setClient(newCO2Reading.getClient());
			x.setConcentration(newCO2Reading.getConcentration());
			x.setSensor(newCO2Reading.getSensor());
			x.setDateTime(newCO2Reading.getDateTime());
			return co2ReadingRepository.save(x);
		}).orElseGet(() -> {
			newCO2Reading.setId(id);
			return co2ReadingRepository.save(newCO2Reading);
		});
	}

	public void deleteById(Long id) {
		co2ReadingRepository.deleteById(id);

	}
}
