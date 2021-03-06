package com.fmw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmw.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, String> {

	public List<userEntity> findByNickname(String nickname);

	public Optional<userEntity> findBySnsloginci(String snsloginci);

}
