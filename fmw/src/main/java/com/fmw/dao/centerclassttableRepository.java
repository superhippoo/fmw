package com.fmw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.centerclassttableEntity;

public interface centerclassttableRepository extends JpaRepository<centerclassttableEntity, String> {

	public List<centerclassttableEntity> findByClassid(String classid);
	
	public Optional<centerclassttableEntity> findByClassidAndCctttimeAndCcttday(String classid, int cctttime, String ccttday);

}
