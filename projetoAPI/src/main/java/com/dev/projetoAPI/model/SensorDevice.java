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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "sensor_device")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SensorDevice {

	@ApiModelProperty(value = "Código do Sensor (SensorDevice)")

	@Transient
	private int keyLength = 32;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, unique = true)
	private String devicekey;
	private String label;
	private String description;

	@OneToMany(mappedBy = "device")
	private List<DataStream> streams;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public SensorDevice() {

	}

	public SensorDevice(String label, String description, User user) {
		this.label = label;
		this.devicekey = AlphaNumericStringGenerator.getRandomString(keyLength);
		this.description = description;
		this.user = user;
		this.streams = new ArrayList<DataStream>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceKey() {
		return devicekey;
	}

	public void setDeviceKey(String devicekey) {
		this.devicekey = devicekey;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<DataStream> getStreams() {
		return streams;
	}

	public void setStreams(List<DataStream> streams) {
		this.streams = streams;
	}

	public int getKeyLength() {
		return keyLength;
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}

}
