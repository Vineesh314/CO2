package com.co2.models;

import java.sql.Date;

public class CityCustomWeekly extends AbstractCityCustom{
    
    private Date startDate;
    private Date endDate;

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
		return "CityCustomWeekly [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
