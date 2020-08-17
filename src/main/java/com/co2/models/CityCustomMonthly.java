package com.co2.models;

import java.sql.Date;

public class CityCustomMonthly extends AbstractCityCustom {

	private String month;
    private Date startDate;
    private Date endDate;

    public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "DistrictCustomMonthly [month=" + month + "startDate=" + startDate + ", endDate=" + endDate + "]";
	}
 
    
}
