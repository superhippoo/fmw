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
import com.fmw.entity.poolEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.poolSvc;

@RestController
@RequestMapping("/pool")
public class poolContoroller {

	@Autowired
	private poolSvc poolsvc;

	@RequestMapping(value = "poollist", method = RequestMethod.GET)
	public ResponseEntity<message> selectPoolList() {
		message ms = new message();
		List<poolEntity> result = new ArrayList<poolEntity>();
		result = poolsvc.selectPoolList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "pool", method = RequestMethod.GET)
	public ResponseEntity<message> selectPoolByPoolId(@RequestParam("poolid") String poolid) {
		if (poolid == null || poolid == "") {
			throw new BadRequestException("Poolid Required");
		}

		message ms = new message();
		Optional<poolEntity> result = poolsvc.selectPoolByPoolId(poolid);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {
			ms.setReturnmessage("Success");
			ms.setData(result.get());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "poolbypoolnm", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserByNickname(@RequestParam("poolnm") String poolnm) {
		if (poolnm == null || poolnm == "") {
			throw new BadRequestException("poolnm Required");
		}

		message ms = new message();
		List<poolEntity> result = new ArrayList<poolEntity>();
		result = poolsvc.selectPoolListByPoolnm(poolnm);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "pool", method = RequestMethod.POST)
	public ResponseEntity<message> insertPool(@RequestBody poolEntity pool) {

		// 필수항목 정리 후 체크 로직 적용 예정

		message ms = new message();
		poolEntity result = poolsvc.insertPool(pool);

		ms.setReturnmessage("Success");
		if (result == null) {
			ms.setReturnmessage("Exist Pool");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "pool", method = RequestMethod.PATCH)
	public ResponseEntity<message> updatePool(@RequestBody poolEntity pool) {
		if (pool.getPoolid() == null || pool.getPoolid() == "") {
			throw new BadRequestException("Poolid Required");
		}

		message ms = new message();
		poolEntity result = poolsvc.updatePool(pool);

		if (result == null) {
			ms.setReturnmessage("Data Not Found");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "pool", method = RequestMethod.DELETE)
	public ResponseEntity<message> deletePool(@RequestParam("poolid") String poolid) {
		if (poolid == null || poolid == "") {
			throw new BadRequestException("Poolid Required");
		}

		message ms = new message();
		boolean isdelete = poolsvc.deletePool(poolid);

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
