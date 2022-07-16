package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.poolEntity;

public interface poolSvc {

	public List<poolEntity> selectPoolList();

	public Optional<poolEntity> selectPoolByPoolId(String pool_id);
	
	public List<poolEntity> selectPoolListByPoolnm(String poolnm);

	public poolEntity insertPool(poolEntity pool);
	
	public poolEntity updatePool(poolEntity pool);

	public boolean deletePool(String pool_id);

}
