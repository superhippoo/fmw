package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.centerclassttableEntity;

public interface centerclassttableSvc {

	public List<centerclassttableEntity> selectCenterclassttableList();

	public Optional<centerclassttableEntity> selectCenterclassttableByccttId(centerclassttableEntity centerclassttable);

	public List<centerclassttableEntity> selectCenterclassttableByClassId(centerclassttableEntity centerclassttable);

	public centerclassttableEntity insertCenterclassttable(centerclassttableEntity centerclassttable);

	public centerclassttableEntity updateCenterclassttable(centerclassttableEntity centerclassttable);

	public boolean deleteCenterclassttable(centerclassttableEntity centerclassttable);

}
