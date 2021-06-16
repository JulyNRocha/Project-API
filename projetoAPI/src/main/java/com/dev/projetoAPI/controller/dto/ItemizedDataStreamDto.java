package com.dev.projetoAPI.controller.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.dev.projetoAPI.model.DataStream;

public class ItemizedDataStreamDto {

	private int id;
	private String label;
	private int unitId;
	private int deviceId;
	private int measurementCount;
	private List<SensorDataDto> measurements;

	public ItemizedDataStreamDto(DataStream dataStream) {
		this.id = dataStream.getId();
		this.label = dataStream.getLabel();
		this.unitId = dataStream.getUnit().getId();
		this.measurementCount = dataStream.getCollects().size();
		this.measurements = new ArrayList<>();
		this.measurements
				.addAll(dataStream.getCollects().stream().map(SensorDataDto::new).collect(Collectors.toList()));
		Collections.reverse(measurements);
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public int getUnitId() {
		return unitId;
	}

	public int getMeasurementCount() {
		return measurementCount;
	}

	public List<SensorDataDto> getMeasurement() {
		return measurements;
	}

	public static List<DataStreamDto> converter(List<DataStream> dataStream) {
		return dataStream.stream().map(DataStreamDto::new).collect(Collectors.toList());
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

}
