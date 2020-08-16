package com.co2.models;

import java.util.List;

public abstract class AbstractCityCustom extends AbstractCo2Measurments{
    private String cityCode;
    private String cityName;
    private List<DistrictCustomDaily> districtList;
    
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<DistrictCustomDaily> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(List<DistrictCustomDaily> districtList) {
		this.districtList = districtList;
	}
	@Override
	public String toString() {
		return "AbstractCityCustom [cityCode=" + cityCode + ", cityName=" + cityName + ", districtList=" + districtList
				+ "]";
	}
    
	
    
}
