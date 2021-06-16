package com.dev.projetoAPI.controller.form;

import com.dev.projetoAPI.model.SensorDevice;
import com.dev.projetoAPI.model.User;
import com.dev.projetoAPI.repository.UserRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class SensorDeviceForm {
	
	@NotNull @NotEmpty @Length(max = 255)
	private String label;
	
	@NotNull @NotEmpty @Length(max = 255)
	private String description;
	
	@NotNull @NotEmpty @Length(max = 255)
	private String userName;
	
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

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public SensorDevice converter(UserRepository repository) {
		
		User user = repository.findByUsername(userName);
		return new SensorDevice(label, description, user);
	}	

}
