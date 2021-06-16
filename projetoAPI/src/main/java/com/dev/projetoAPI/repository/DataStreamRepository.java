package com.dev.projetoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projetoAPI.model.DataStream;

public interface DataStreamRepository extends JpaRepository<DataStream,Integer> {

	Optional<DataStream> findByStreamKey(String key);

}
