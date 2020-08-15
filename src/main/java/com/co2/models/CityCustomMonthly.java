package com.co2.models;

import java.util.List;

public class CityCustomMonthly {
    
    private String cityCode;
    private String cityName;
    private List<DistrictCustomDaily> districtList;
    private String month;
    private Long maxCO2Units;
    private Long minCO2Units;
    private Long avgCO2Units;
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
	public Long getMaxCO2Units() {
		return maxCO2Units;
	}
	public void setMaxCO2Units(Long maxCO2Units) {
		this.maxCO2Units = maxCO2Units;
	}
	public Long getMinCO2Units() {
		return minCO2Units;
	}
	public void setMinCO2Units(Long minCO2Units) {
		this.minCO2Units = minCO2Units;
	}
	public Long getAvgCO2Units() {
		return avgCO2Units;
	}
	public void setAvgCO2Units(Long avgCO2Units) {
		this.avgCO2Units = avgCO2Units;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "CityCustomMonthly [cityCode=" + cityCode + ", cityName=" + cityName + ", districtList=" + districtList
				+ ", month=" + month + ", maxCO2Units=" + maxCO2Units + ", minCO2Units=" + minCO2Units
				+ ", avgCO2Units=" + avgCO2Units + "]";
	}
 
    
}
