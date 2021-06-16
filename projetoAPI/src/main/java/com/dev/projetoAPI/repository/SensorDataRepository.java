package com.dev.projetoAPI.repository;


import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projetoAPI.model.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData,Timestamp> {
	

}
