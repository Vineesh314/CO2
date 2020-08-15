package com.co2.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class District {
    @Id
    @GeneratedValue
    private Long districtId;
    private String districtCode;
    private String districtName;
    
	@NotNull(message = "The Client must not be null")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cityId", nullable = false)
	private City city;


	public District() {
		super();
	}

	public District(Long districtId, String districtCode, String districtName, @NotNull(message = "The Client must not be null") City city) {
		super();
		this.districtId = districtId;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.city = city;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", districtCode=" + districtCode + ", districtName=" + districtName + ", city=" + city+ "]";
	}
}