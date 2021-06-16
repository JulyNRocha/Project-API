package com.dev.projetoAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dev.projetoAPI.controller.dto.ItemizedSensorDeviceDto;
import com.dev.projetoAPI.controller.dto.SensorDeviceDto;
import com.dev.projetoAPI.controller.form.SensorDeviceForm;
import com.dev.projetoAPI.model.SensorDevice;
import com.dev.projetoAPI.repository.SensorDeviceRepository;
import com.dev.projetoAPI.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="Dispositivos (SensorDevice)")
@RestController
@RequestMapping("/SensorDevice")
public class SensorDeviceController {
	
	@Autowired
	private SensorDeviceRepository sensorDeviceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@ApiOperation(value = "Consultar dispositivos (SensorDevice) de um Usuário (User)")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de dispositivos (SensorDevice)")
		})
	@GetMapping(produces="application/json")
	public List<SensorDeviceDto> getSensorDeviceslist() {
		
		List<SensorDevice> sensorDevices = sensorDeviceRepository.findAll();

		return SensorDeviceDto.converter(sensorDevices);
		
	}
	
	@ApiOperation(value = "Registrar dispositivo (SensorDevice) de um usuario (User)")
	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Resgistro de dispositivo (SensorDevice) criado com Sucesso"),
		    @ApiResponse(code = 500, message = "Erro interno")
		})
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<SensorDeviceDto> sensorDeviceRegister(@RequestBody @Valid SensorDeviceForm form, UriComponentsBuilder uriBuilder) {
		SensorDevice sensorDevice = form.converter(userRepository);
		sensorDeviceRepository.save(sensorDevice);
		
		URI uri = uriBuilder.path("/SensorData/{id}").buildAndExpand(sensorDevice.getId()).toUri();
		return ResponseEntity.created(uri).body(new SensorDeviceDto(sensorDevice));
	}	
	
	@ApiOperation(value = "Consulta de um dispositivo (SensorDevice) específico apartir de uma Key de dispositivo")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o sensores (SensorDevice) a partir da key"),
		    @ApiResponse(code = 404, message = "Dispositivo (SensorDevice) com essa Key não foi encontrado"),
		    @ApiResponse(code = 500, message = "Erro interno"),
		})
	@GetMapping(value = "/{device_key}", produces="application/json")
	public ResponseEntity<ItemizedSensorDeviceDto> getSensorDeviceByDeviceKey(@PathVariable String device_key) {
		
		Optional<SensorDevice> sensorDevice = sensorDeviceRepository.findByDevicekey(device_key);
		if(sensorDevice.isPresent()) {
			return ResponseEntity.ok(new ItemizedSensorDeviceDto(sensorDevice.get()));
		}
		
		return ResponseEntity.notFound().build();
 
	}
	
}
