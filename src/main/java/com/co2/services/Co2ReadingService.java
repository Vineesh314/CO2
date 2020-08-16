package com.co2.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co2.models.CO2Reading;
import com.co2.models.City;
import com.co2.models.CityCustomWeekly;
import com.co2.models.Client;
import com.co2.models.ClientCustomDaily;
import com.co2.models.ClientCustomMonthly;
import com.co2.models.ClientCustomWeekly;
import com.co2.models.Co2ReadingMarkerInterface;
import com.co2.models.District;
import com.co2.models.DistrictCustomWeekly;
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
		
		Client client = clientService.findById(clientId);
		System.out.println("client===" + client.toString());
		ClientCustomWeekly clientCustomWeekly=new ClientCustomWeekly();
		List<CityCustomWeekly> cityCustomWeeklyList = new ArrayList<CityCustomWeekly>();
		List<DistrictCustomWeekly> districtCustomWeeklyList = new ArrayList<DistrictCustomWeekly>();
	
		Date endDate = new Date(System.currentTimeMillis());
		Date startDate = new Date(endDate.getYear(),endDate.getMonth(),endDate.getDay()-6);
		
		double districtAvgCO2Units =0;
		double districtMaxCO2Units =0;
		double districtMinCO2Units =0;
		
		if (client != null) {
			List<City> cityList = cityService.findByClient_Id(clientId);
			System.out.println("cityList===" + cityList.toString());
			Double cityAvgCO2Units = 0.0;
			Double cityMinCO2Units =0.0;
			Double cityMaxCO2Units =0.0;
			int cityCount = 0;
			for (City city : cityList) {
//				cityMinCO2Units =0.0;
//				cityMaxCO2Units =0.0;
				System.out.println("CITYCOUNT IN THE BEGINNING"+cityCount);
				cityCount = cityCount+1;
				System.out.println("CITYCOUNT IN THE next"+cityCount);
				System.out.println("city===" + city.toString());
				CityCustomWeekly cityCustomWeekly = new CityCustomWeekly();
				List<District> districtList = districtService.findByCity_Id(city.getCityId());
				for (District district : districtList) {
					System.out.println("district===" + district.toString());
					Integer sensorCount =districtService.sensorCount(district.getDistrictId());
					System.out.println("SensorCount===" + sensorCount);
					List<CO2Reading> co2ReadingList=co2ReadingRepository.findByDistrict_districtId(district.getDistrictId());
					districtAvgCO2Units = 0;
					districtMaxCO2Units=0;
					districtMinCO2Units=0;
					int readings =0;
					int length =0;
					for(CO2Reading co2Reading:co2ReadingList) {
//						Date startDate = new Date(System.currentTimeMillis()-7);
						if(readings==0) {
							districtMaxCO2Units = co2Reading.getConcentration();
							districtMinCO2Units = co2Reading.getConcentration();

							cityMaxCO2Units = co2Reading.getConcentration();
							cityMinCO2Units = co2Reading.getConcentration();
							System.out.println("CITYMAXCOUNT" + cityMaxCO2Units);

							System.out.println("CITYCOUNT"+cityCount);
						}
						Date date = co2Reading.getDateTime();
						if(co2Reading.getDateTime().compareTo(startDate)>=0) {
							districtAvgCO2Units += co2Reading.getConcentration();
							if(co2Reading.getConcentration()>districtMaxCO2Units)
								districtMaxCO2Units = co2Reading.getConcentration();
							if(co2Reading.getConcentration()<districtMinCO2Units)
								districtMinCO2Units = co2Reading.getConcentration();
							readings++;
						}
						System.out.println("co2Reading===" + co2Reading.toString());
						
					}
					if(districtAvgCO2Units != 0) {
						districtAvgCO2Units /=readings;
						System.out.println("districtAvgCO2Units is "+ districtAvgCO2Units);
					}
					if(readings>0) {
						DistrictCustomWeekly districtCustomWeekly = new DistrictCustomWeekly();
						districtCustomWeekly.setAvgCO2Units(districtAvgCO2Units);
						districtCustomWeekly.setDistrictCode(district.getDistrictCode());
						districtCustomWeekly.setDistrictName(district.getDistrictName());
						
						districtCustomWeekly.setStartDate(startDate);;
						districtCustomWeekly.setEndDate(endDate);
						districtCustomWeekly.setMaxCO2Units(districtMaxCO2Units);
						districtCustomWeekly.setMinCO2Units(districtMinCO2Units);
						districtCustomWeeklyList.add(districtCustomWeekly);
						cityAvgCO2Units += districtAvgCO2Units;
						if(districtMaxCO2Units>cityMaxCO2Units)
							cityMaxCO2Units = districtMaxCO2Units;
						if(districtMinCO2Units < cityMinCO2Units)
							cityMinCO2Units = districtMinCO2Units;
						System.out.println(districtMaxCO2Units+" > "+cityMaxCO2Units);
					}
					
//					readings = 0;
//					districtAvgCO2Units = 0;
//					cityCount=0;
				}
				if(cityCount>0) {
					cityCustomWeekly.setAvgCO2Units(cityAvgCO2Units);
					cityCustomWeekly.setCityCode(city.getCityCode());
					cityCustomWeekly.setCityName(city.getCityName());
					cityCustomWeekly.setDistrictWeeklyList(districtCustomWeeklyList);
					cityCustomWeekly.setEndDate(endDate);
					cityCustomWeekly.setMaxCO2Units(cityMaxCO2Units);
					cityCustomWeekly.setMinCO2Units(cityMinCO2Units);
					cityCustomWeekly.setStartDate(startDate);
					cityCustomWeeklyList.add(cityCustomWeekly);
					cityCount =0;
				}
//				cityCount =0;
				
			}
			clientCustomWeekly.setClientName(client.getClientName());
			clientCustomWeekly.setCityList(cityCustomWeeklyList);
		}
		

//		System.out.println("co2ReadingList===" + co2ReadingList.toString());
//		System.out.println(new Date(System.currentTimeMillis()-2));
		return clientCustomWeekly;
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
