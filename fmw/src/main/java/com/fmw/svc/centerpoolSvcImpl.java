package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.centerpoolRepository;
import com.fmw.entity.centerpoolEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class centerpoolSvcImpl implements centerpoolSvc {

	@Autowired
	centerpoolRepository centerpoolrepository;

	@Override
	public List<centerpoolEntity> selectCenterpoolList() {
		// TODO Auto-generated method stub
		return centerpoolrepository.findAll();
	}

	@Override
	public Optional<centerpoolEntity> selectCenterpoolByCenterpoolId(centerpoolEntity centerpool) {
		// TODO Auto-generated method stub
		return centerpoolrepository.findById(centerpool.getPoolid());
	}

	@Override
	public List<centerpoolEntity> selectCenterpoolByCenterId(centerpoolEntity centerpool) {
		return centerpoolrepository.findByCenterid(centerpool.getCenterid());
	}

	@Override
	public centerpoolEntity insertCenterpool(centerpoolEntity centerpool) {
		centerpool.setPoolid(uniqueIdUtil.generateUid("P"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		centerpool.setRegdt(time);
		centerpool.setMdfydt(time);

		return centerpoolrepository.saveAndFlush(centerpool);
	}

	@Override
	public centerpoolEntity updateCenterpool(centerpoolEntity centerpool) {
		Optional<centerpoolEntity> tempcenterpool = centerpoolrepository.findById(centerpool.getPoolid());

		if (tempcenterpool.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			centerpool.setMdfydt(time);

			return centerpoolrepository.saveAndFlush(centerpool);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCenterpool(centerpoolEntity centerpool) {
		Optional<centerpoolEntity> tempcenterttable = centerpoolrepository.findById(centerpool.getPoolid());

		if (tempcenterttable.isPresent()) {
			centerpoolrepository.deleteById(centerpool.getPoolid());
			return true;
		} else {
			return false;
		}
	}

}
