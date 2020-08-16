package com.co2.models;

public class CityCustomMonthly extends AbstractCityCustom {
    

    private String month;

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "CityCustomMonthly [month=" + month + "]";
	}

 
    
}
