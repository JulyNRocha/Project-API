package com.dev.projetoAPI.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "users")
public class User {

	@ApiModelProperty(value = "Código do Usuario (User)")

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "user")
	private List<SensorDevice> devices;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SensorDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<SensorDevice> devices) {
		this.devices = devices;
	}

}