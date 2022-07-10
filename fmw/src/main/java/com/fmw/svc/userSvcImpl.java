package com.fmw.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmw.dao.userDao;
import com.fmw.dao.userRepository;
import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;
import com.fmw.util.uniqueIdUtil;

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
	public Optional<userEntity> selectUserBySnsloginci(String snsloginci) {
		return userrepository.findBySnsloginci(snsloginci);
	}

	@Override
	public userEntity insertUser(userEntity user) {
		Optional<userEntity> tempuser = userrepository.findBySnsloginci(user.getSnsloginci());

		if (tempuser.isPresent()) {
			return null;
		}

		user.setUid(uniqueIdUtil.generateUid("U"));
		user.setAct_yn("Y");
		user.setUser_type("U");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		user.setReg_dt(time);
		user.setMdfy_dt(time);
		user.setReport_num(0);

		return userrepository.saveAndFlush(user);
	}

	@Override
	public userEntity updateUser(userEntity user) {
		Optional<userEntity> tempuser = userrepository.findById(user.getUid());

		if (tempuser.isPresent()) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			user.setMdfy_dt(time);
			return userrepository.saveAndFlush(user);
		} else {
			return null;
		}

	}

	@Override
	public boolean deleteUser(String uid) {
		Optional<userEntity> tempuser = userrepository.findById(uid);

		if (tempuser.isPresent()) {
			userrepository.deleteById(uid);
			return true;
		} else {
			return false;
		}
	}

}
