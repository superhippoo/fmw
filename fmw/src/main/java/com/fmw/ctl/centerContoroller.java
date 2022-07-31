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
import com.fmw.entity.centerEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.centerSvc;

@RestController
@RequestMapping("/center")
public class centerContoroller {

	@Autowired
	private centerSvc centersvc;

	@RequestMapping(value = "centerlist", method = RequestMethod.GET)
	public ResponseEntity<message> selectCenterList() {
		message ms = new message();
		List<centerEntity> result = new ArrayList<centerEntity>();
		result = centersvc.selectCenterList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenter", method = RequestMethod.POST)
	public ResponseEntity<message> selectCenterByCenterId(@RequestBody centerEntity center) {
		if (center.getCenterid() == null || center.getCenterid() == "") {
			throw new BadRequestException("Centerid Required");
		}

		message ms = new message();
		Optional<centerEntity> result = centersvc.selectCenterByCenterId(center);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {
			ms.setReturnmessage("Success");
			ms.setData(result.get());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterbycenternm", method = RequestMethod.POST)
	public ResponseEntity<message> selectUserByNickname(@RequestBody centerEntity center) {
		if (center.getCenternm() == null || center.getCenternm() == "") {
			throw new BadRequestException("centernm Required");
		}

		message ms = new message();
		List<centerEntity> result = new ArrayList<centerEntity>();
		result = centersvc.selectCenterListByCenternm(center);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "insertcenter", method = RequestMethod.POST)
	public ResponseEntity<message> insertCenter(@RequestBody centerEntity center) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		centerEntity result = centersvc.insertCenter(center);

		ms.setReturnmessage("Success");
		if (result == null) {
			ms.setReturnmessage("Exist Center");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "updatecenter", method = RequestMethod.POST)
	public ResponseEntity<message> updateCenter(@RequestBody centerEntity center) {
		if (center.getCenterid() == null || center.getCenterid() == "") {
			throw new BadRequestException("Centerid Required");
		}

		message ms = new message();
		centerEntity result = centersvc.updateCenter(center);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "deletecenter", method = RequestMethod.POST)
	public ResponseEntity<message> deleteCenter(@RequestBody centerEntity center) {
		if (center.getCenterid() == null || center.getCenterid() == "") {
			throw new BadRequestException("Centerid Required");
		}

		message ms = new message();
		boolean isdelete = centersvc.deleteCenter(center);

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
