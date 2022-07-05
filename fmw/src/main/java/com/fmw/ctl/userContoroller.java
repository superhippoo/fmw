package com.fmw.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fmw.dto.userVO;
import com.fmw.svc.userSvc;

@RestController
@RequestMapping("/user")
public class userContoroller {

	@Autowired
	private userSvc usersvc;

	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public List<userVO> selectUserList() {
		return usersvc.selectUserList();
	}

}
