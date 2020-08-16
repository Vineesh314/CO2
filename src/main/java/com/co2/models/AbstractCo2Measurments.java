package com.co2.models;

public abstract class AbstractCo2Measurments {
    private Double maxCO2Units;
    private Double minCO2Units;
    private Double avgCO2Units;
	
	public Double getMaxCO2Units() {
		return maxCO2Units;
	}
	public void setMaxCO2Units(Double maxCO2Units) {
		this.maxCO2Units = maxCO2Units;
	}
	public Double getMinCO2Units() {
		return minCO2Units;
	}
	public void setMinCO2Units(Double minCO2Units) {
		this.minCO2Units = minCO2Units;
	}
	public Double getAvgCO2Units() {
		return avgCO2Units;
	}
	public void setAvgCO2Units(Double avgCO2Units) {
		this.avgCO2Units = avgCO2Units;
	}

    
}
