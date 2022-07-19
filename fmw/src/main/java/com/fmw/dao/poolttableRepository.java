package com.fmw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.poolttableEntity;

public interface poolttableRepository extends JpaRepository<poolttableEntity, String> {

	public List<poolttableEntity> findByPoolid(String poolid);

}
