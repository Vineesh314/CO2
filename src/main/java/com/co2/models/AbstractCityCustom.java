package com.co2.models;

import java.util.List;

public abstract class AbstractCityCustom extends AbstractCo2Measurments{
    private String cityCode;
    private String cityName;
    private List<DistrictCustomDaily> districtList;
    private List<DistrictCustomWeekly> districtWeeklyList;
    private List<DistrictCustomMonthly> districtMonthlyList;
    
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
	public List<DistrictCustomWeekly> getDistrictWeeklyList() {
		return districtWeeklyList;
	}
	public void setDistrictWeeklyList(List<DistrictCustomWeekly> districtWeeklyList) {
		this.districtWeeklyList = districtWeeklyList;
	}
	public List<DistrictCustomMonthly> getDistrictMonthlyList() {
		return districtMonthlyList;
	}
	public void setDistrictMonthlyList(List<DistrictCustomMonthly> districtMonthlyList) {
		this.districtMonthlyList = districtMonthlyList;
	}
	
	@Override
	public String toString() {
		return "AbstractCityCustom [cityCode=" + cityCode + ", cityName=" + cityName + ", districtList=" + districtList + ", districtMonthlyList=" + districtMonthlyList
				+ "]";
	}
    
	
    
}
