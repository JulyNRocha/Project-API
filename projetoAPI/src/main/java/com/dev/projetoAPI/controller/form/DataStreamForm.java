package com.dev.projetoAPI.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.dev.projetoAPI.model.DataStream;
import com.dev.projetoAPI.model.MeasurementUnit;
import com.dev.projetoAPI.model.SensorDevice;
import com.dev.projetoAPI.repository.MeasurementUnitRepository;

public class DataStreamForm {
	
	@NotNull @NotEmpty
	private String label;
	
	@NotNull @PositiveOrZero
	private int unitId;
				
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public DataStream converter(MeasurementUnitRepository unitRepository,SensorDevice device) {
		MeasurementUnit unit = unitRepository.getById(unitId);
		
		return new DataStream(label, unit , device);
	}

}
