package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.centerEntity;

public interface centerSvc {

	public List<centerEntity> selectCenterList();

	public Optional<centerEntity> selectCenterByCenterId(centerEntity center);
	
	public List<centerEntity> selectCenterListByCenternm(centerEntity center);

	public centerEntity insertCenter(centerEntity center);
	
	public centerEntity updateCenter(centerEntity center);

	public boolean deleteCenter(centerEntity center);

}
