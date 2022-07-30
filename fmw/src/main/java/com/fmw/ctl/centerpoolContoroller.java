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
import com.fmw.entity.centerpoolEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.centerpoolSvc;

@RestController
@RequestMapping("/centerpool")
public class centerpoolContoroller {

	@Autowired
	private centerpoolSvc centerpoolsvc;

	@RequestMapping(value = "centerpoollist", method = RequestMethod.GET)
	public ResponseEntity<message> selectCenterpoolList() {
		message ms = new message();
		List<centerpoolEntity> result = new ArrayList<centerpoolEntity>();
		result = centerpoolsvc.selectCenterpoolList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterpool", method = RequestMethod.POST)
	public ResponseEntity<message> selectCenterpoolByPoolId(@RequestBody centerpoolEntity centerpool) {
		if (centerpool.getPoolid() == null || centerpool.getPoolid() == "") {
			throw new BadRequestException("poolid Required");
		}
		message ms = new message();
		Optional<centerpoolEntity> result = centerpoolsvc.selectCenterpoolByCenterpoolId(centerpool);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setData(result.get());
			ms.setReturnmessage("Success");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "selectcenterpoolbycenterid", method = RequestMethod.POST)
	public ResponseEntity<message> selectcenterpoolByCenterid(@RequestBody centerpoolEntity centerpool) {
		if (centerpool.getCenterid() == null || centerpool.getCenterid() == "") {
			throw new BadRequestException("centerid Required");
		}

		message ms = new message();
		List<centerpoolEntity> result = new ArrayList<centerpoolEntity>();
		result = centerpoolsvc.selectCenterpoolByCenterId(centerpool);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "insertcenterpool", method = RequestMethod.POST)
	public ResponseEntity<message> insertCenterpool(@RequestBody centerpoolEntity centerpool) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		centerpoolEntity result = centerpoolsvc.insertCenterpool(centerpool);

		ms.setReturnmessage("Success");
		ms.setStatus(statusEnum.OK.getStatusCode());

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "updatecenterpool", method = RequestMethod.POST)
	public ResponseEntity<message> updateCenterpool(@RequestBody centerpoolEntity centerpool) {
		if (centerpool.getPoolid() == null || centerpool.getPoolid() == "") {
			throw new BadRequestException("Poolid Required");
		}

		message ms = new message();
		centerpoolEntity result = centerpoolsvc.updateCenterpool(centerpool);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "deletecenterpool", method = RequestMethod.POST)
	public ResponseEntity<message> deleteCenterpool(@RequestBody centerpoolEntity centerpool) {
		if (centerpool.getPoolid() == null || centerpool.getPoolid() == "") {
			throw new BadRequestException("Poolid Required");
		}

		message ms = new message();
		boolean isdelete = centerpoolsvc.deleteCenterpool(centerpool);

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
