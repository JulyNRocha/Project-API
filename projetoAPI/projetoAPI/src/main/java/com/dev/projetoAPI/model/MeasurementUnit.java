package com.dev.projetoAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "measurement_unit")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MeasurementUnit {

	@ApiModelProperty(value = "Código das Unidades de Media (MeasurementUnit)")

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String symbol;
	private String description;

	public int getId() {
		return id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
