package com.co2.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.co2.exceptions.DistrictNotFoundException;
import com.co2.models.District;
import com.co2.repositories.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	DistrictRepository districtRepository;

	public List<District> findAll() {
		return districtRepository.findAll();
	}

	public District save(District newDistrict) {
		return districtRepository.save(newDistrict);
	}

	public District findById(Long id) {
		return districtRepository.findById(id).get();
	}
	
	public List<District> findByCity_Id(Long cityId){
		return districtRepository.findByCity_cityId(cityId);
	}
	
	public District saveOrUpdate(District newDistrict, Long id) {
		return districtRepository.findById(id).map(x -> {
			x.setDistrictId(newDistrict.getDistrictId());
			x.setDistrictCode(newDistrict.getDistrictCode());
			x.setDistrictName(newDistrict.getDistrictName());
			return districtRepository.save(x);
		}).orElseGet(() -> {
			newDistrict.setDistrictId(id);
			return districtRepository.save(newDistrict);
		});
	}

	public District patch(Map<String, String> update, Long id) {
		return districtRepository.findById(id).map(x -> {

			String districtName = update.get("districtName");
			if (!StringUtils.isEmpty(districtName)) {
				x.setDistrictName(districtName);

				// better create a custom method to update a value = :newValue where id = :id
				return districtRepository.save(x);
			} else {
				throw new DistrictNotFoundException(id);
			}

		}).orElseGet(() -> {
			throw new DistrictNotFoundException(id);
		});
	}

	public void deleteById(Long id) {
		districtRepository.deleteById(id);

	}

}
