package com.fmw.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmw.dto.message;
import com.fmw.dto.userVO;
import com.fmw.entity.userEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
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
		return new ResponseEntity<message>(ms, HttpStatus.OK);

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
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "userbynickname", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserByNickname(@RequestParam("nickname") String nickname) {		
    	if (nickname == null || nickname == "") {
    		throw new BadRequestException("Nickname Required");
		} 
		
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
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserByUid(@RequestParam("uid") String uid) {
    	if (uid == null || uid == "") {
    		throw new BadRequestException("Uid Required");
		} 
    	
		message ms = new message();
		Optional<userEntity> result = usersvc.selectUserByUid(uid);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setReturnmessage("Success");
			ms.setData(result.get());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "userbysnsloginci", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserBySnsloginci(@RequestParam("snsloginci") String snsloginci) {
    	if (snsloginci == null || snsloginci == "") {
    		throw new BadRequestException("Snsloginci Required");
		} 
    	
		message ms = new message();
		Optional<userEntity> result = usersvc.selectUserBySnsloginci(snsloginci);
		ms.setData(result.get());
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Success");
		if (result.isPresent()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<message> insertUser(@RequestBody userEntity user) {
		
		//필수항목 정리 후 체크 로직 적용 예정
		
		message ms = new message();
		userEntity result = usersvc.insertUser(user);

		ms.setReturnmessage("Success");
		if (result == null) {
			ms.setReturnmessage("Exist User");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "user", method = RequestMethod.PATCH)
	public ResponseEntity<message> updateUser(@RequestBody userEntity user) {
    	if (user.getUid() == null || user.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		} 
		
		message ms = new message();
		userEntity result = usersvc.updateUser(user);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "user", method = RequestMethod.DELETE)
	public ResponseEntity<message> deleteUser(@RequestParam("uid") String uid) {
    	if (uid == null || uid == "") {
    		throw new BadRequestException("Uid Required");
		} 
		
		message ms = new message();
		boolean isdelete = usersvc.deleteUser(uid);
		
		//sw_user_history data delete 로직 개발 필요
		
		if (isdelete == false) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

}
