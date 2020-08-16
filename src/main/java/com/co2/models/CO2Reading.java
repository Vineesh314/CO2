package com.co2.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CO2Reading {
    @Id
    @GeneratedValue
    private Long id;
    
	@NotNull(message = "The Client must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "clientId", nullable = false)
	private Client client;
    
	@NotNull(message = "The District must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "districtId", nullable = false)
	private District district;

	@NotNull(message = "The City must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cityId", nullable = false)
	private City city;
	
	@NotNull(message = "The Sensor must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sensorId", nullable = false)
	private Sensor sensor;
	
    private Double concentration;
    private Date dateTime;
    
	public CO2Reading() {
		super();
	}

	public CO2Reading(Long id, @NotNull(message = "The Client must not be null") Client client,
			@NotNull(message = "The District must not be null") District district,
			@NotNull(message = "The City must not be null") City city,
			@NotNull(message = "The Sensor must not be null") Sensor sensor, Double concentration, Date dateTime) {
		super();
		this.id = id;
		this.client = client;
		this.district = district;
		this.city = city;
		this.sensor = sensor;
		this.concentration = concentration;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Double getConcentration() {
		return concentration;
	}

	public void setConcentration(Double concentration) {
		this.concentration = concentration;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "CO2Reading [id=" + id + ", client=" + client + ", district=" + district + ", city=" + city + ", sensor="
				+ sensor + ", concentration=" + concentration + ", dateTime=" + dateTime + "]";
	}

 
    
}
