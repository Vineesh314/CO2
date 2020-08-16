package com.co2.models;

public abstract class AbstractDistrictCustom extends AbstractCo2Measurments{
	
    private String districtCode;
    private String districtName;
    
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
	
	@Override
	public String toString() {
		return "AbstractDistrictCustom [districtCode=" + districtCode + ", districtName=" + districtName + "]";
	}
    
}
