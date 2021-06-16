package com.dev.projetoAPI.controller.form;

import javax.validation.constraints.NotNull;

import com.dev.projetoAPI.model.DataStream;
import com.dev.projetoAPI.model.SensorData;

public class SensorDataForm {

	@NotNull
	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public SensorData converter(DataStream dataStream) {
		return new SensorData(value, dataStream);
	}

}
