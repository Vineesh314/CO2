package com.co2.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Sensor {
	
	@Id
	@GeneratedValue
	private Long sensorId;
	private String sensorName;
	private String sensorCode;
	
	@NotNull(message = "The District must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "districtId", nullable = false)
	private District district;
	
	

	public Sensor() {
		super();
	}

	public Sensor(Long sensorId, String sensorName, String sensorCode,
			@NotNull(message = "The District must not be null") District district) {
		super();
		this.sensorId = sensorId;
		this.sensorName = sensorName;
		this.sensorCode = sensorCode;
		this.district = district;
	}

	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getSensorCode() {
		return sensorCode;
	}

	public void setSensorCode(String sensorCode) {
		this.sensorCode = sensorCode;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", sensorName=" + sensorName + ", sensorCode=" + sensorCode
				+ ", district=" + district + "]";
	}
	
	

}
