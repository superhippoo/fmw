package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.centerpoolEntity;

public interface centerpoolRepository extends JpaRepository<centerpoolEntity, String> {

	public List<centerpoolEntity> findByCenterid(String centerid);

}
