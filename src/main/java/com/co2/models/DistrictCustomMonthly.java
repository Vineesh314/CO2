package com.co2.models;

public class DistrictCustomMonthly extends AbstractDistrictCustom{

    private String month;
    
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "DistrictCustomMonthly [month=" + month + "]";
	}


}