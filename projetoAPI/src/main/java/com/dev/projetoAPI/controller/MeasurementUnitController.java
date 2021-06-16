package com.dev.projetoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.projetoAPI.controller.dto.MeasurementUnitDto;
import com.dev.projetoAPI.model.MeasurementUnit;
import com.dev.projetoAPI.repository.MeasurementUnitRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Unidade de Medidas (MeasureUnit)")
@RestController
@RequestMapping(value = "/MeasureUnit", produces = "application/json")
public class MeasurementUnitController {

	@Autowired
	private MeasurementUnitRepository measurementUnitRepository;

	@ApiOperation(value = "Consultar unidades de medida (MeasurementUnit)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorno da Lista de Unidades de Medida (Measure Unit)"),
			@ApiResponse(code = 500, message = "Erro interno"), })
	@GetMapping
	@Cacheable(value = "units")
	public List<MeasurementUnitDto> lista() {

		List<MeasurementUnit> measurementUnit = measurementUnitRepository.findAll();

		return MeasurementUnitDto.converter(measurementUnit);

	}

}
