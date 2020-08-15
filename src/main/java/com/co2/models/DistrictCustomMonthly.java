package com.co2.models;

public class DistrictCustomMonthly {

    private String districtCode;
    private String districtName;
    private Long maxCO2Units;
    private Long minCO2Units;
    private Long avgCO2Units;
    private String month;
    
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "DistrictCustomMonthly [districtCode=" + districtCode + ", districtName=" + districtName
				+ ", maxCO2Units=" + maxCO2Units + ", minCO2Units=" + minCO2Units + ", avgCO2Units=" + avgCO2Units
				+ ", month=" + month + "]";
	}


    

}