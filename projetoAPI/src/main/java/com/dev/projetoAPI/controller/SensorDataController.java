package com.dev.projetoAPI.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dev.projetoAPI.controller.dto.SensorDataDto;
import com.dev.projetoAPI.controller.form.SensorDataForm;
import com.dev.projetoAPI.model.DataStream;
import com.dev.projetoAPI.model.SensorData;
import com.dev.projetoAPI.repository.DataStreamRepository;
import com.dev.projetoAPI.repository.SensorDataRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Dados (SensorData)")
@RestController
public class SensorDataController {

	@Autowired
	private SensorDataRepository sensorDataRepository;

	@Autowired
	private DataStreamRepository dataStreamRepository;

	//Swagger
	@ApiOperation(value = "Publicar medição (SensorData) em uma Stream (DataStream)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Medição Coletada com sucesso"),
			@ApiResponse(code = 404, message = "Stream (DataStream) com essa Key não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro interno"), })
	//[POST] Sensor Data
	@PostMapping(value = "/DataStream/{stream_key}/SensorData", produces = "application/json")
	public ResponseEntity<SensorDataDto> collect(@PathVariable String stream_key, @RequestBody @Valid SensorDataForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<DataStream> dataStream = dataStreamRepository.findByStreamKey(stream_key);
		if (dataStream.isPresent()) {

			SensorData sensorData = form.converter(dataStream.get());
			sensorDataRepository.save(sensorData);

			URI uri = uriBuilder.path("/SensorData/{id}").buildAndExpand(sensorData.getTimestamp()).toUri();
			return ResponseEntity.created(uri).body(new SensorDataDto(sensorData));
		}

		return ResponseEntity.notFound().build();
	}

}
