package com.dev.projetoAPI.controller.dto;

import com.dev.projetoAPI.model.SensorData;

public class SensorDataDto {
	
	private long timestamp;
	private double value;
	private int unitId;
	
	public SensorDataDto(SensorData sensorData){
		this.timestamp = sensorData.getTimestamp().getTime();
		this.value = sensorData.getValue();
		this.unitId = sensorData.getUnit().getId();
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public double getValue() {
		return value;
	}
	
	public int getUnitId() {
		return unitId;
	}

}
