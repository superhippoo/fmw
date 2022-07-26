package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.centerEntity;

public interface centerRepository extends JpaRepository<centerEntity, String> {

	public List<centerEntity> findByCenternm(String centernm);

}
