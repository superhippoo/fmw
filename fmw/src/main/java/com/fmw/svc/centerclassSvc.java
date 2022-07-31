package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.centerclassEntity;

public interface centerclassSvc {

	public List<centerclassEntity> selectCenterclassList();

	public Optional<centerclassEntity> selectCenterclassByCenterclassId(centerclassEntity centerclass);

	public List<centerclassEntity> selectCenterclassByCenterId(centerclassEntity centerclass);

	public centerclassEntity insertCenterclass(centerclassEntity centerclass);

	public centerclassEntity updateCenterclass(centerclassEntity centerclass);

	public boolean deleteCenterclass(centerclassEntity centerclass);

}
