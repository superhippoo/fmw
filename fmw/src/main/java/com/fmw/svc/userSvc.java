package com.fmw.svc;

import java.util.List;

import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;

public interface userSvc {

	public List<userVO> selectUserList();
	
	public List<userEntity> selectUserListJPA();


}
