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
import org.springframework.web.bind.annotation.RestController;

import com.fmw.dto.message;
import com.fmw.entity.centerclassttableEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.centerclassttableSvc;

@RestController
@RequestMapping("/centerclassttable")
public class centerclassttableContoroller {

	@Autowired
	private centerclassttableSvc centerclassttablesvc;

	@RequestMapping(value = "centerclassttablelist", method = RequestMethod.GET)
	public ResponseEntity<message> selectCenterclassttableList() {
		message ms = new message();
		List<centerclassttableEntity> result = new ArrayList<centerclassttableEntity>();
		result = centerclassttablesvc.selectCenterclassttableList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);
	}

	@RequestMapping(value = "selectcenterclassttable", method = RequestMethod.POST)
	public ResponseEntity<message> selectCenterclassByPoolId(@RequestBody centerclassttableEntity centerclassttable) {
		if (centerclassttable.getCcttid() == null || centerclassttable.getCcttid() == "") {
			throw new BadRequestException("ccttid Required");
		}
		message ms = new message();
		Optional<centerclassttableEntity> result = centerclassttablesvc.selectCenterclassttableByccttId(centerclassttable);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setData(result.get());
			ms.setReturnmessage("Success");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterclassttablebyclassid", method = RequestMethod.POST)
	public ResponseEntity<message> selectcenterclassttableByclassid(@RequestBody centerclassttableEntity centerclassttable) {
		if (centerclassttable.getClassid() == null || centerclassttable.getClassid() == "") {
			throw new BadRequestException("classid Required");
		}

		message ms = new message();
		List<centerclassttableEntity> result = new ArrayList<centerclassttableEntity>();
		result = centerclassttablesvc.selectCenterclassttableByClassId(centerclassttable);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "insertcenterclassttable", method = RequestMethod.POST)
	public ResponseEntity<message> insertCenterclassttable(@RequestBody centerclassttableEntity centerclassttable) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		centerclassttableEntity result = centerclassttablesvc.insertCenterclassttable(centerclassttable);
		
		if (result == null) {
			ms.setReturnmessage("Duplicate cctt");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		}else {
			ms.setData(result);
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}
		

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "updatecenterclassttable", method = RequestMethod.POST)
	public ResponseEntity<message> updateCenterclassttable(@RequestBody centerclassttableEntity centerclassttable) {
		if (centerclassttable.getCcttid() == null || centerclassttable.getCcttid() == "") {
			throw new BadRequestException("ccttid Required");
		}

		message ms = new message();
		centerclassttableEntity result = centerclassttablesvc.updateCenterclassttable(centerclassttable);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "deletecenterclassttable", method = RequestMethod.POST)
	public ResponseEntity<message> deleteCenterclassttable(@RequestBody centerclassttableEntity centerclassttable) {
		if (centerclassttable.getCcttid() == null || centerclassttable.getCcttid() == "") {
			throw new BadRequestException("ccttid Required");
		}

		message ms = new message();
		boolean isdelete = centerclassttablesvc.deleteCenterclassttable(centerclassttable);

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
