package com.fmw.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmw.dto.message;
import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;
import com.fmw.enums.statusEnum;
import com.fmw.svc.userSvc;

@RestController
@RequestMapping("/user")
public class userContoroller {

	@Autowired
	private userSvc usersvc;

	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserList() {
		message ms = new message();
		List<userVO> result = new ArrayList<userVO>();
		result = usersvc.selectUserList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms,HttpStatus.OK);

	}
	
	@RequestMapping(value = "userlistjpa", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserListJPA() {
		message ms = new message();
		List<userEntity> result = new ArrayList<userEntity>();
		result = usersvc.selectUserListJPA();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms,HttpStatus.OK);

	}
	
	@RequestMapping(value = "userbynickname", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserByNickname(@RequestParam("nickname") String nickname) {
		message ms = new message();
		List<userEntity> result = new ArrayList<userEntity>();
		result = usersvc.selectUserByNickname(nickname);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms,HttpStatus.OK);

	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserByUid(@RequestParam("uid") String uid) {
		message ms = new message();
		List<userEntity> result = new ArrayList<userEntity>();
		result = usersvc.selectUserByNickname(uid);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms,HttpStatus.OK);

	}
	
	@RequestMapping(value = "userbysnsloginci", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserBySnsloginci(@RequestParam("snsloginci") String snsloginci) {
		message ms = new message();
		List<userEntity> result = new ArrayList<userEntity>();
		result = usersvc.selectUserBySnsloginci(snsloginci);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms,HttpStatus.OK);

	}


}
