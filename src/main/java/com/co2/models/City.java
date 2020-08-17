package com.co2.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class City {
    @Id
    @GeneratedValue
    private Long cityId;
    private String cityCode;
    private String cityName;
    
	@NotNull(message = "The Client must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "clientId", nullable = false)
	private Client client;


	public City() {
		super();
	}

	public City(Long cityId, String cityCode, String cityName,
			@NotNull(message = "The Client must not be null") Client client) {
		super();
		this.cityId = cityId;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.client = client;
	}

	public Long getCityId() {
		return cityId;
	}
	
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

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

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityCode=" + cityCode + ", cityName=" + cityName + ", client=" + client
				+ "]";
	}
	
	

}
