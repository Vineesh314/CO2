package com.co2.models;

import java.util.List;


public class ClientCustomDaily {
	
    private String clientName;
    private List<CityCustomDaily> cityList;
    
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<CityCustomDaily> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityCustomDaily> cityList) {
		this.cityList = cityList;
	}
    

}
