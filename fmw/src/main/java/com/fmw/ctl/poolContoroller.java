package com.fmw.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fmw.dto.message;
import com.fmw.entity.poolEntity;
import com.fmw.enums.statusEnum;
import com.fmw.svc.poolSvc;

@RestController
@RequestMapping("/pool")
public class poolContoroller {

	@Autowired
	private poolSvc poolsvc;

	@RequestMapping(value = "poollist", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserListJPA() {
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

}
