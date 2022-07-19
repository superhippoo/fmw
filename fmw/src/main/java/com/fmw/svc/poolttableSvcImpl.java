package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.poolttableRepository;
import com.fmw.entity.poolttableEntity;

@Service
public class poolttableSvcImpl implements poolttableSvc {

	@Autowired
	poolttableRepository poolttablerepository;

	@Override
	public List<poolttableEntity> selectPoolttbleList() {
		return poolttablerepository.findAll();
	}

	@Override
	public Optional<poolttableEntity> selectPoolttableByPoolttableId(String pttid) {
		return poolttablerepository.findById(pttid);
	}

	@Override
	public List<poolttableEntity> selectPoolttbleByPoolId(String poolid) {
		return poolttablerepository.findByPoolid(poolid);
	}

//	@Override
//	public Optional<poolEntity> selectPoolByPoolId(String pool_id) {
//		return poolrepository.findById(pool_id);
//	}
//
//	@Override
//	public List<poolEntity> selectPoolListByPoolnm(String poolnm) {
//		return poolrepository.findByPoolnm(poolnm);
//	}
//
//	@Override
//	public poolEntity insertPool(poolEntity pool) {
//		List<poolEntity> temppool = poolrepository.findByPoolnm(pool.getPoolnm());
//
//		if (!temppool.isEmpty()) {// 같은이름의 수영장 존재
//			return null;
//		}
//
//		pool.setPool_id(uniqueIdUtil.generateUid("P"));
//		Timestamp time = new Timestamp(System.currentTimeMillis());
//		pool.setReg_dt(time);
//		pool.setMdfy_dt(time);
//
//		return poolrepository.saveAndFlush(pool);
//	}
//
//	@Override
//	public poolEntity updatePool(poolEntity pool) {
//		Optional<poolEntity> temppool = poolrepository.findById(pool.getPool_id());
//
//		if (temppool.isPresent()) {
//			Timestamp time = new Timestamp(System.currentTimeMillis());
//			pool.setMdfy_dt(time);
//			return poolrepository.saveAndFlush(pool);
//		} else {
//			return null;
//		}
//
//	}
//
//	@Override
//	public boolean deletePool(String pool_id) {
//		Optional<poolEntity> temppool = poolrepository.findById(pool_id);
//
//		if (temppool.isPresent()) {
//			poolrepository.deleteById(pool_id);
//			return true;
//		} else {
//			return false;
//		}
//	}

}
