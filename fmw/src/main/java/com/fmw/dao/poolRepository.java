package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.poolEntity;

public interface poolRepository extends JpaRepository<poolEntity, String> {

	public List<poolEntity> findByPoolnm(String poolnm);
	
}
