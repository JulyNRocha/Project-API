package com.dev.projetoAPI.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.dev.projetoAPI.model.SensorDevice;
import com.dev.projetoAPI.model.User;

public class SensorDeviceForm {

	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String label;

	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String description;

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

	public SensorDevice converter(User user) {

		return new SensorDevice(label, description, user);
	}

}
