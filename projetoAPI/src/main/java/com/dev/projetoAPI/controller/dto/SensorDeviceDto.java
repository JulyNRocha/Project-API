package com.dev.projetoAPI.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dev.projetoAPI.model.SensorDevice;

public class SensorDeviceDto {
	
	private int id;
	private String key;
	private String label;
	private String description;
	private List<DataStreamDto> streams;

	public SensorDeviceDto(SensorDevice sensorDevice) {
		this.id = sensorDevice.getId();
		this.label = sensorDevice.getLabel();
		this.key = sensorDevice.getDeviceKey();
		this.description = sensorDevice.getDescription();
		this.streams = new ArrayList<DataStreamDto>();
		this.streams.addAll(sensorDevice.getStreams().stream().map(DataStreamDto::new).collect(Collectors.toList()));
	}
		
	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	public List<DataStreamDto> getStreams() {
		return streams;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public static List<SensorDeviceDto> converter(List<SensorDevice> sensorDevice){
		return sensorDevice.stream().map(SensorDeviceDto::new).collect(Collectors.toList());
	}
	
}
