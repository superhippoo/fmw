package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.poolttableRepository;
import com.fmw.entity.poolttableEntity;
import com.fmw.util.uniqueIdUtil;

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

	@Override
	public poolttableEntity insertPoolttable(poolttableEntity poolttable) {
		poolttable.setPttid(uniqueIdUtil.generateUid("S"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		poolttable.setRegdt(time);
		poolttable.setMdfydt(time);

		return poolttablerepository.saveAndFlush(poolttable);
	}
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
