package com.co2.models;

import java.sql.Date;

public class DistrictCustomWeekly {

    private String districtCode;
    private String districtName;
    private Long maxCO2Units;
    private Long minCO2Units;
    private Long avgCO2Units;
    private Date startDate;
    private Date endDate;
    
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
		return "DistrictCustomWeekly [districtCode=" + districtCode + ", districtName=" + districtName
				+ ", maxCO2Units=" + maxCO2Units + ", minCO2Units=" + minCO2Units + ", avgCO2Units=" + avgCO2Units
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

    

}