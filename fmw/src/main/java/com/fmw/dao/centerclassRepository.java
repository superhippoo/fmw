package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.centerclassEntity;

public interface centerclassRepository extends JpaRepository<centerclassEntity, String> {

	public List<centerclassEntity> findByCenterid(String centerid);

}
