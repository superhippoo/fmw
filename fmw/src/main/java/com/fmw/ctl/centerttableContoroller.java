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
import com.fmw.entity.centerttableEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.centerttableSvc;

@RestController
@RequestMapping("/centerttable")
public class centerttableContoroller {

	@Autowired
	private centerttableSvc centerttablesvc;

	@RequestMapping(value = "centerttablelist", method = RequestMethod.GET)
	public ResponseEntity<message> selectCenterttableList() {
		message ms = new message();
		List<centerttableEntity> result = new ArrayList<centerttableEntity>();
		result = centerttablesvc.selectCenterttbleList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterttable", method = RequestMethod.POST)
	public ResponseEntity<message> selectCenterttableByPttId(@RequestBody centerttableEntity centerttable) {
		if (centerttable.getCttid() == null || centerttable.getCttid() == "") {
			throw new BadRequestException("cttid Required");
		}
		message ms = new message();
		Optional<centerttableEntity> result = centerttablesvc.selectCenterttableByCenterttableId(centerttable);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setData(result.get());
			ms.setReturnmessage("Success");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterttablebycenterid", method = RequestMethod.POST)
	public ResponseEntity<message> selectcenterttableByCenterid(@RequestBody centerttableEntity centerttable) {
		if (centerttable.getCenterid() == null || centerttable.getCenterid() == "") {
			throw new BadRequestException("centerid Required");
		}

		message ms = new message();
		List<centerttableEntity> result = new ArrayList<centerttableEntity>();
		result = centerttablesvc.selectCenterttableByCenterId(centerttable);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "insertcenterttable", method = RequestMethod.POST)
	public ResponseEntity<message> insertCenterttable(@RequestBody centerttableEntity centerttable) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		centerttableEntity result = centerttablesvc.insertCenterttable(centerttable);
		ms.setData(result);
		ms.setReturnmessage("Success");
		ms.setStatus(statusEnum.OK.getStatusCode());

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "updatecenterttable", method = RequestMethod.POST)
	public ResponseEntity<message> updateCenterttable(@RequestBody centerttableEntity centerttable) {
		if (centerttable.getCttid() == null || centerttable.getCttid() == "") {
			throw new BadRequestException("Centerttableid Required");
		}

		message ms = new message();
		centerttableEntity result = centerttablesvc.updateCenterttable(centerttable);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "deletecenterttable", method = RequestMethod.POST)
	public ResponseEntity<message> deleteCenterttable(@RequestBody centerttableEntity centerttable) {
		if (centerttable.getCttid() == null || centerttable.getCttid() == "") {
			throw new BadRequestException("Centerttableid Required");
		}

		message ms = new message();
		boolean isdelete = centerttablesvc.deleteCenterttable(centerttable);

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
