package com.co2.models;

import java.util.List;
public class ClientCustomWeekly {
	
    private String clientName;
    private List<CityCustomWeekly> cityList;
    
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<CityCustomWeekly> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityCustomWeekly> cityList) {
		this.cityList = cityList;
	}
    

}
