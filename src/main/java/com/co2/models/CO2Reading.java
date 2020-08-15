package com.co2.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CO2Reading {
    @Id
    @GeneratedValue
    private Long id;
    private Long districtId;
    private Long cityId;
    private Long clientId;
    private String sensorId;
    private String concentration;
    private Date dateTime;
    
	public CO2Reading(Long id, String sensorId, String concentration, Date dateTime) {
		super();
		this.id = id;
		this.sensorId = sensorId;
		this.concentration = concentration;
		this.dateTime = dateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CO2Reading [id=" + id + ", districtId=" + districtId + ", cityId=" + cityId + ", clientId=" + clientId
				+ ", sensorId=" + sensorId + ", concentration=" + concentration + ", dateTime=" + dateTime + "]";
	}

    
    
}
