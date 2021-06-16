package com.dev.projetoAPI.repository;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projetoAPI.model.SensorDevice;

public interface SensorDeviceRepository extends JpaRepository<SensorDevice,Integer> {


	Optional<SensorDevice> findByDevicekey(String key);



}
