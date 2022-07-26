package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.centerttableEntity;

public interface centerttableSvc {

	public List<centerttableEntity> selectCenterttbleList();

	public Optional<centerttableEntity> selectCenterttableByCenterttableId(centerttableEntity centerttable);
	
	public List<centerttableEntity> selectCenterttableByCenterId(centerttableEntity centerttable);

	public centerttableEntity insertCenterttable(centerttableEntity centerttable);
//	
//	public centerEntity updateCenter(centerEntity center);
//
//	public boolean deleteCenter(String center_id);

}
