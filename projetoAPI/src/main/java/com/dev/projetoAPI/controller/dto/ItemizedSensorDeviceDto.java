package com.dev.projetoAPI.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dev.projetoAPI.model.SensorDevice;

public class ItemizedSensorDeviceDto {
	
	private int id;
	private String label;
	private String description;
	private List<ItemDataStreamDto> streams;

	public ItemizedSensorDeviceDto(SensorDevice sensorDevice) {
		this.id = sensorDevice.getId();
		this.label = sensorDevice.getLabel();
		this.description = sensorDevice.getDescription();
		this.streams = new ArrayList<>();
		this.streams.addAll(sensorDevice.getStreams().stream().map(ItemDataStreamDto::new).collect(Collectors.toList()));
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

	public List<ItemDataStreamDto> getStreams() {
		return streams;
	}	
	
}
