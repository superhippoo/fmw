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
import com.fmw.entity.centerclassEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.centerclassSvc;

@RestController
@RequestMapping("/centerclass")
public class centerclassContoroller {

	@Autowired
	private centerclassSvc centerclasssvc;

	@RequestMapping(value = "centerclasslist", method = RequestMethod.GET)
	public ResponseEntity<message> selectCenterclassList() {
		message ms = new message();
		List<centerclassEntity> result = new ArrayList<centerclassEntity>();
		result = centerclasssvc.selectCenterclassList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);
	}

	@RequestMapping(value = "selectcenterclass", method = RequestMethod.POST)
	public ResponseEntity<message> selectCenterclassByPoolId(@RequestBody centerclassEntity centerclass) {
		if (centerclass.getClassid() == null || centerclass.getClassid() == "") {
			throw new BadRequestException("classid Required");
		}
		message ms = new message();
		Optional<centerclassEntity> result = centerclasssvc.selectCenterclassByCenterclassId(centerclass);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setData(result.get());
			ms.setReturnmessage("Success");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterclassbycenterid", method = RequestMethod.POST)
	public ResponseEntity<message> selectcenterclassByCenterid(@RequestBody centerclassEntity centerclass) {
		if (centerclass.getCenterid() == null || centerclass.getCenterid() == "") {
			throw new BadRequestException("centerid Required");
		}

		message ms = new message();
		List<centerclassEntity> result = new ArrayList<centerclassEntity>();
		result = centerclasssvc.selectCenterclassByCenterId(centerclass);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "insertcenterclass", method = RequestMethod.POST)
	public ResponseEntity<message> insertCenterclass(@RequestBody centerclassEntity centerclass) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		centerclassEntity result = centerclasssvc.insertCenterclass(centerclass);
		ms.setData(result);
		ms.setReturnmessage("Success");
		ms.setStatus(statusEnum.OK.getStatusCode());

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "updatecenterclass", method = RequestMethod.POST)
	public ResponseEntity<message> updateCenterclass(@RequestBody centerclassEntity centerclass) {
		if (centerclass.getClassid() == null || centerclass.getClassid() == "") {
			throw new BadRequestException("Classid Required");
		}

		message ms = new message();
		centerclassEntity result = centerclasssvc.updateCenterclass(centerclass);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "deletecenterclass", method = RequestMethod.POST)
	public ResponseEntity<message> deleteCenterclass(@RequestBody centerclassEntity centerclass) {
		if (centerclass.getClassid() == null || centerclass.getClassid() == "") {
			throw new BadRequestException("Classid Required");
		}

		message ms = new message();
		boolean isdelete = centerclasssvc.deleteCenterclass(centerclass);

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
