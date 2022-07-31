package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.centerclassRepository;
import com.fmw.entity.centerclassEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class centerclassSvcImpl implements centerclassSvc {

	@Autowired
	centerclassRepository centerclassrepository;

	@Override
	public List<centerclassEntity> selectCenterclassList() {
		return centerclassrepository.findAll();
	}

	@Override
	public Optional<centerclassEntity> selectCenterclassByCenterclassId(centerclassEntity centerclass) {
		return centerclassrepository.findById(centerclass.getClassid());
	}

	@Override
	public List<centerclassEntity> selectCenterclassByCenterId(centerclassEntity centerclass) {
		return centerclassrepository.findByCenterid(centerclass.getCenterid());
	}

	@Override
	public centerclassEntity insertCenterclass(centerclassEntity centerclass) {
		centerclass.setClassid(uniqueIdUtil.generateUid("C"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		centerclass.setRegdt(time);
		centerclass.setMdfydt(time);

		return centerclassrepository.saveAndFlush(centerclass);
	}

	@Override
	public centerclassEntity updateCenterclass(centerclassEntity centerclass) {
		Optional<centerclassEntity> tempcenterclass = centerclassrepository.findById(centerclass.getClassid());

		if (tempcenterclass.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			centerclass.setMdfydt(time);

			return centerclassrepository.saveAndFlush(centerclass);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCenterclass(centerclassEntity centerclass) {
		Optional<centerclassEntity> tempcenterclass = centerclassrepository.findById(centerclass.getClassid());

		if (tempcenterclass.isPresent()) {
			centerclassrepository.deleteById(centerclass.getClassid());
			return true;
		} else {
			return false;
		}
	}

}
