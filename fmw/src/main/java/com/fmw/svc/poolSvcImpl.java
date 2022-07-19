package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.poolRepository;
import com.fmw.entity.poolEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class poolSvcImpl implements poolSvc {

	@Autowired
	poolRepository poolrepository;

	@Override
	public List<poolEntity> selectPoolList() {
		return poolrepository.findAll();
	}

	@Override
	public Optional<poolEntity> selectPoolByPoolId(String poolid) {
		return poolrepository.findById(poolid);
	}

	@Override
	public List<poolEntity> selectPoolListByPoolnm(String poolnm) {
		return poolrepository.findByPoolnm(poolnm);
	}

	@Override
	public poolEntity insertPool(poolEntity pool) {
		List<poolEntity> temppool = poolrepository.findByPoolnm(pool.getPoolnm());

		if (!temppool.isEmpty()) {// 같은이름의 수영장 존재
			return null;
		}

		pool.setPoolid(uniqueIdUtil.generateUid("P"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		pool.setRegdt(time);
		pool.setMdfydt(time);

		return poolrepository.saveAndFlush(pool);
	}

	@Override
	public poolEntity updatePool(poolEntity pool) {
		Optional<poolEntity> temppool = poolrepository.findById(pool.getPoolid());

		if (temppool.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			pool.setMdfydt(time);
			return poolrepository.saveAndFlush(pool);
		} else {
			return null;
		}

	}

	@Override
	public boolean deletePool(String pool_id) {
		Optional<poolEntity> temppool = poolrepository.findById(pool_id);

		if (temppool.isPresent()) {
			poolrepository.deleteById(pool_id);
			return true;
		} else {
			return false;
		}
	}

}
