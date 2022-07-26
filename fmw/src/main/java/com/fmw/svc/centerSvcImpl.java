package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.centerRepository;
import com.fmw.entity.centerEntity;
import com.fmw.util.uniqueIdUtil;

@Service
public class centerSvcImpl implements centerSvc {

	@Autowired
	centerRepository centerrepository;

	@Override
	public List<centerEntity> selectCenterList() {
		return centerrepository.findAll();
	}

	@Override
	public Optional<centerEntity> selectCenterByCenterId(centerEntity center) {
		return centerrepository.findById(center.getCenterid());
	}

	@Override
	public List<centerEntity> selectCenterListByCenternm(centerEntity center) {
		return centerrepository.findByCenternm(center.getCenternm());
	}

	@Override
	public centerEntity insertCenter(centerEntity center) {
		List<centerEntity> tempcenter = centerrepository.findByCenternm(center.getCenternm());

		if (!tempcenter.isEmpty()) {// 같은이름의 수영장 존재
			return null;
		}

		center.setCenterid(uniqueIdUtil.generateUid("C"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		center.setRegdt(time);
		center.setMdfydt(time);

		return centerrepository.saveAndFlush(center);
	}

	@Override
	public centerEntity updateCenter(centerEntity center) {
		Optional<centerEntity> tempcenter = centerrepository.findById(center.getCenterid());

		if (tempcenter.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			center.setMdfydt(time);
			return centerrepository.saveAndFlush(center);
		} else {
			return null;
		}

	}

	@Override
	public boolean deleteCenter(centerEntity center) {
		Optional<centerEntity> tempcenter = centerrepository.findById(center.getCenterid());

		if (tempcenter.isPresent()) {
			centerrepository.deleteById(center.getCenterid());
			return true;
		} else {
			return false;
		}
	}

}
