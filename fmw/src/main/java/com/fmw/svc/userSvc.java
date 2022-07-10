package com.fmw.svc;

import java.util.List;
import java.util.Optional;

import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;

public interface userSvc {

	public List<userVO> selectUserList();

	public List<userEntity> selectUserListJPA();

	public List<userEntity> selectUserByNickname(String nickname);

	public Optional<userEntity> selectUserByIid(String uid);

}
