package com.dev.projetoAPI.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "sensor_data")
public class SensorData {
	
	@ApiModelProperty(value = "Código dos dados de leitura (SensorData)")

	@Id
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private double value;
	
	@ManyToOne
	@JoinColumn(name = "stream_id")
	private DataStream stream;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	private MeasurementUnit unit;
	
	public SensorData() {
		
	}
	
	public SensorData(double value, DataStream stream) {
		super();
		this.value = value;
		this.stream = stream;
		this.unit = stream.getUnit();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public MeasurementUnit getUnit() {
		return unit;
	}

	public void setUnit(MeasurementUnit unit) {
		this.unit = unit;
	}
	
	public DataStream getStream() {
		return stream;
	}
	
	public void setStream(DataStream stream) {
		this.stream = stream;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

}
