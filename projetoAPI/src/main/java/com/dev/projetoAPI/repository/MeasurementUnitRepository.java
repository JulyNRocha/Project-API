package com.dev.projetoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projetoAPI.model.MeasurementUnit;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Integer> {

}
