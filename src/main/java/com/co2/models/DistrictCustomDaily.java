package com.co2.models;

import java.sql.Date;

public class DistrictCustomDaily extends AbstractDistrictCustom{

    private Date date;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "DistrictCustomDaily [date=" + date + "]";
	}


}