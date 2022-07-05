package com.fmw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, String> {

//	public List<userEntity> findAll();

}
