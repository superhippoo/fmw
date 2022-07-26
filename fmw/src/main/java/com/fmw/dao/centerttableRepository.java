package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.centerttableEntity;

public interface centerttableRepository extends JpaRepository<centerttableEntity, String> {

	public List<centerttableEntity> findByCenterid(String centerid);

}
