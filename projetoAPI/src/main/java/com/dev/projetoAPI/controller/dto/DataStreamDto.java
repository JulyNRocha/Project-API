package com.dev.projetoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dev.projetoAPI.model.DataStream;

public class DataStreamDto {
	
	private int id;
	private String key;
	private String label;
	private int unitId;
	private int measurementCount;

	public DataStreamDto(DataStream dataStream) {
		this.id = dataStream.getId();
		this.key = dataStream.getStreamKey();
		this.label = dataStream.getLabel();
		this.unitId = dataStream.getUnit().getId();
		this.measurementCount = dataStream.getCollects().size();	

	}
		
	public int getId() {
		return id;
	}

	public String getKey() {
		return key;
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

	public static List<DataStreamDto> converter(List<DataStream> dataStream){
		return dataStream.stream().map(DataStreamDto::new).collect(Collectors.toList());
	}

}
