package com.co2.models;

import java.util.List;
public class ClientCustomMonthly implements Co2ReadingMarkerInterface{
	
    private String clientName;
    private List<CityCustomMonthly> cityList;
    
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<CityCustomMonthly> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityCustomMonthly> cityList) {
		this.cityList = cityList;
	}
    

}
