package com.dev.projetoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dev.projetoAPI.model.MeasurementUnit;

public class MeasurementUnitDto {
	
	private int id;
	private String symbol;
	private String description;

	public MeasurementUnitDto(MeasurementUnit measurementUnit) {
		this.id = measurementUnit.getId();
		this.symbol = measurementUnit.getSymbol();
		this.description = measurementUnit.getDescription();
	}

	public int getId() {
		return id;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static List<MeasurementUnitDto> converter(List<MeasurementUnit> measurementUnit){
		return measurementUnit.stream().map(MeasurementUnitDto::new).collect(Collectors.toList());
	}
	
}
