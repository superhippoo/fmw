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
import com.fmw.entity.poolttableEntity;
import com.fmw.entity.userEntity;
import com.fmw.enums.statusEnum;
import com.fmw.exception.BadRequestException;
import com.fmw.svc.poolSvc;
import com.fmw.svc.poolttableSvc;

@RestController
@RequestMapping("/poolttable")
public class poolttableContoroller {

	@Autowired
	private poolttableSvc poolttablesvc;

	@RequestMapping(value = "poolttablelist", method = RequestMethod.GET)
	public ResponseEntity<message> selectPoolttableList() {
		message ms = new message();
		List<poolttableEntity> result = new ArrayList<poolttableEntity>();
		result = poolttablesvc.selectPoolttbleList();
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "poolttable", method = RequestMethod.GET)
	public ResponseEntity<message> selectPoolttableByPttId(@RequestParam("pttid") String pttid) {
		if (pttid == null || pttid == "") {
			throw new BadRequestException("pttid Required");
		}
		message ms = new message();
		Optional<poolttableEntity> result = poolttablesvc.selectPoolttableByPoolttableId(pttid);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Data Not Found");
		if (result.isPresent()) {// 값이 없으면
			ms.setData(result.get());
			ms.setReturnmessage("Success");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "poolttablebypoolid", method = RequestMethod.GET)
	public ResponseEntity<message> selectpoolttableByPoolid(@RequestParam("poolid") String poolid) {
		if (poolid == null || poolid == "") {
			throw new BadRequestException("poolid Required");
		}

		message ms = new message();
		List<poolttableEntity> result = new ArrayList<poolttableEntity>();
		result = poolttablesvc.selectPoolttbleByPoolId(poolid);
		ms.setData(result);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(result.size()));
		ms.setReturnmessage("Success");
		if (result.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}
		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}
//
//	@RequestMapping(value = "pool", method = RequestMethod.POST)
//	public ResponseEntity<message> insertPool(@RequestBody poolEntity pool) {
//
//		// 필수항목 정리 후 체크 로직 적용 예정
//
//		message ms = new message();
//		poolEntity result = poolsvc.insertPool(pool);
//
//		ms.setReturnmessage("Success");
//		if (result == null) {
//			ms.setReturnmessage("Exist Pool");
//			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
//		} else {
//			ms.setReturnmessage("Success");
//			ms.setStatus(statusEnum.OK.getStatusCode());
//		}
//		return new ResponseEntity<message>(ms, HttpStatus.OK);
//
//	}
//
//	@RequestMapping(value = "pool", method = RequestMethod.PATCH)
//	public ResponseEntity<message> updatePool(@RequestBody poolEntity pool) {
//		if (pool.getPool_id() == null || pool.getPool_id() == "") {
//			throw new BadRequestException("Poolid Required");
//		}
//
//		message ms = new message();
//		poolEntity result = poolsvc.updatePool(pool);
//
//		if (result == null) {
//			ms.setReturnmessage("Data Not Found");
//			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
//		} else {
//			ms.setReturnmessage("Success");
//			ms.setStatus(statusEnum.OK.getStatusCode());
//		}
//
//		return new ResponseEntity<message>(ms, HttpStatus.OK);
//
//	}
//
//	@RequestMapping(value = "pool", method = RequestMethod.DELETE)
//	public ResponseEntity<message> deletePool(@RequestParam("pool_id") String pool_id) {
//		if (pool_id == null || pool_id == "") {
//			throw new BadRequestException("Poolid Required");
//		}
//
//		message ms = new message();
//		boolean isdelete = poolsvc.deletePool(pool_id);
//
//		if (isdelete == false) {
//			ms.setReturnmessage("Data Not Found");
//			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
//		} else {
//			ms.setReturnmessage("Success");
//			ms.setStatus(statusEnum.OK.getStatusCode());
//		}
//		return new ResponseEntity<message>(ms, HttpStatus.OK);
//
//	}

}
