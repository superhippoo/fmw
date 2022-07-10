package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.userDao;
import com.fmw.dao.userRepository;
import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;

@Service
public class userSvcImpl implements userSvc {

	@Autowired
	private userDao userdao;

	@Autowired
	private userRepository userrepository;

	@Override
	public List<userVO> selectUserList() {
		return userdao.selectUserList();
	}

	@Override
	public List<userEntity> selectUserListJPA() {
		return userrepository.findAll();
	}

	@Override
	public List<userEntity> selectUserByNickname(String nickname) {
		return userrepository.findByNickname(nickname);
	}

	@Override
	public Optional<userEntity> selectUserByUid(String uid) {
		return userrepository.findById(uid);

	}

	@Override
	public List<userEntity> selectUserBySnsloginci(String snsloginci) {
		return userrepository.findBySnsloginci(snsloginci);
	}

}
