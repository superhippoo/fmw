package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.centerclassttableRepository;
import com.fmw.entity.centerclassttableEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class centerclassttableSvcImpl implements centerclassttableSvc {

	@Autowired
	centerclassttableRepository centerclassttablerepository;

	@Override
	public List<centerclassttableEntity> selectCenterclassttableList() {
		return centerclassttablerepository.findAll();
	}

	@Override
	public Optional<centerclassttableEntity> selectCenterclassttableByccttId(
			centerclassttableEntity centerclassttable) {
		return centerclassttablerepository.findById(centerclassttable.getCcttid());
	}

	@Override
	public List<centerclassttableEntity> selectCenterclassttableByClassId(centerclassttableEntity centerclassttable) {
		return centerclassttablerepository.findByClassid(centerclassttable.getClassid());
	}

	@Override
	public centerclassttableEntity insertCenterclassttable(centerclassttableEntity centerclassttable) {

		Optional<centerclassttableEntity> tempcenterclassttable = centerclassttablerepository
				.findByClassidAndCctttimeAndCcttday(centerclassttable.getClassid(), centerclassttable.getCctttime(),
						centerclassttable.getCcttday());
		if (tempcenterclassttable.isPresent()) {
			return null;
		}

		centerclassttable.setCcttid(uniqueIdUtil.generateUid("T"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		centerclassttable.setRegdt(time);
		centerclassttable.setMdfydt(time);

		return centerclassttablerepository.saveAndFlush(centerclassttable);
	}

	@Override
	public centerclassttableEntity updateCenterclassttable(centerclassttableEntity centerclassttable) {
		Optional<centerclassttableEntity> tempcenterclassttable = centerclassttablerepository
				.findById(centerclassttable.getCcttid());

		if (tempcenterclassttable.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			centerclassttable.setMdfydt(time);

			return centerclassttablerepository.saveAndFlush(centerclassttable);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCenterclassttable(centerclassttableEntity centerclassttable) {
		Optional<centerclassttableEntity> tempcenterclassttable = centerclassttablerepository
				.findById(centerclassttable.getCcttid());

		if (tempcenterclassttable.isPresent()) {
			centerclassttablerepository.deleteById(centerclassttable.getCcttid());
			return true;
		} else {
			return false;
		}
	}

}
