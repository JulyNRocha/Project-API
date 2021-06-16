package com.dev.projetoAPI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dev.projetoAPI.config.key.AlphaNumericStringGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "data_stream")
public class DataStream {
	
	@ApiModelProperty(value = "Código das streams de dados(DataStream)")

	@Transient
	private int keyLength = 32;
	
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(nullable = false, unique = true)
	private String streamKey;
	private String label;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	private MeasurementUnit unit;
	
	@ManyToOne
	@JoinColumn(name = "device_id")
	private SensorDevice device;
	
	@OneToMany(mappedBy = "stream")
	private List<SensorData> collects;
	
	public DataStream() {
		
	}
	
	public DataStream(String label, MeasurementUnit unit, SensorDevice device) {
		this.label = label;
		this.streamKey = AlphaNumericStringGenerator.getRandomString(keyLength);
		this.unit = unit;
		this.device = device;
		this.collects = new ArrayList<SensorData>();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStreamKey() {
		return streamKey;
	}
	
	public void setStreamKey(String streamKey) {
		this.streamKey = streamKey;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public MeasurementUnit getUnit() {
		return unit;
	}

	public void setUnit(MeasurementUnit unit) {
		this.unit = unit;
	}
	
	public SensorDevice getDevice() {
		return device;
	}

	public void setDevice(SensorDevice device) {
		this.device = device;
	}

	public List<SensorData> getCollects() {
		return collects;
	}

	public void setMeasurement(List<SensorData> collects) {
		this.collects = collects;
	}

	

}
