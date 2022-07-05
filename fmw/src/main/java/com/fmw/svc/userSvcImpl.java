package com.fmw.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.userDao;
import com.fmw.dto.userVO;

@Service
public class userSvcImpl implements userSvc {

	@Autowired
	private userDao userdao;

	@Override
	public List<userVO> selectUserList() {
		return userdao.selectUserList();
	}

}
