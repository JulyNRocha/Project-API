package com.dev.projetoAPI.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.dev.projetoAPI.model.DataStream;
import com.dev.projetoAPI.model.SensorData;

public class SensorDataForm {
	
	@NotNull 
	private double value;
	
	@NotNull @PositiveOrZero
	private int stream_id;
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public int getStream_id() {
		return stream_id;
	}

	public void setStream_id(int stream_id) {
		this.stream_id = stream_id;
	}
	
	public SensorData converter(DataStream dataStream ) {
		return new SensorData(value, dataStream);
	}

}
