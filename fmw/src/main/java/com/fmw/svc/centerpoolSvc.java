package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.entity.centerpoolEntity;

public interface centerpoolSvc {

	public List<centerpoolEntity> selectCenterpoolList();

	public Optional<centerpoolEntity> selectCenterpoolByCenterpoolId(centerpoolEntity centerpool);
	
	public List<centerpoolEntity> selectCenterpoolByCenterId(centerpoolEntity centerpool);

	public centerpoolEntity insertCenterpool(centerpoolEntity centerpool);
	
	public centerpoolEntity updateCenterpool(centerpoolEntity centerpool);

	public boolean deleteCenterpool(centerpoolEntity centerpool);

}
