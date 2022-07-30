package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.centerttableRepository;
import com.fmw.entity.centerttableEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class centerttableSvcImpl implements centerttableSvc {

	@Autowired
	centerttableRepository centerttablerepository;

	@Override
	public List<centerttableEntity> selectCenterttbleList() {
		return centerttablerepository.findAll();
	}

	@Override
	public Optional<centerttableEntity> selectCenterttableByCenterttableId(centerttableEntity centerttable) {
		return centerttablerepository.findById(centerttable.getCttid());
	}

	@Override
	public List<centerttableEntity> selectCenterttableByCenterId(centerttableEntity centerttable) {
		return centerttablerepository.findByCenterid(centerttable.getCenterid());
	}

	@Override
	public centerttableEntity insertCenterttable(centerttableEntity centerttable) {
		centerttable.setCttid(uniqueIdUtil.generateUid("T"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		centerttable.setRegdt(time);
		centerttable.setMdfydt(time);

		return centerttablerepository.saveAndFlush(centerttable);
	}

	@Override
	public centerttableEntity updateCenterttable(centerttableEntity centerttable) {
		Optional<centerttableEntity> tempcenterttable = centerttablerepository.findById(centerttable.getCttid());

		if (tempcenterttable.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			centerttable.setMdfydt(time);

			return centerttablerepository.saveAndFlush(centerttable);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCenterttable(centerttableEntity centerttable) {
		Optional<centerttableEntity> tempcenterttable = centerttablerepository.findById(centerttable.getCttid());

		if (tempcenterttable.isPresent()) {
			centerttablerepository.deleteById(centerttable.getCttid());
			return true;
		} else {
			return false;
		}
	}

}
