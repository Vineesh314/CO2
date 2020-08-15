package com.co2.models;

import java.sql.Date;
import java.util.List;

public class CityCustomWeekly {
    
    private String cityCode;
    private String cityName;
    private List<DistrictCustomDaily> districtList;
    private Date startDate;
    private Date endDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "CityCustomWeekly [cityCode=" + cityCode + ", cityName=" + cityName + ", districtList=" + districtList
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", maxCO2Units=" + maxCO2Units
				+ ", minCO2Units=" + minCO2Units + ", avgCO2Units=" + avgCO2Units + "]";
	}


    
    
}
