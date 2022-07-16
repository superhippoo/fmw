package com.fmw.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.poolRepository;
import com.fmw.entity.poolEntity;

@Service
public class poolSvcImpl implements poolSvc {
	
	@Autowired
	poolRepository poolrepository;

	@Override
	public List<poolEntity> selectPoolList() {
		return poolrepository.findAll();
	}
	
	

}
