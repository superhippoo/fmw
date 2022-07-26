package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.poolttableEntity;

public interface poolttableSvc {

	public List<poolttableEntity> selectPoolttbleList();

	public Optional<poolttableEntity> selectPoolttableByPoolttableId(String pttid);
	
	public List<poolttableEntity> selectPoolttbleByPoolId(String poolid);

	public poolttableEntity insertPoolttable(poolttableEntity poolttable);
//	
//	public poolEntity updatePool(poolEntity pool);
//
//	public boolean deletePool(String pool_id);

}
