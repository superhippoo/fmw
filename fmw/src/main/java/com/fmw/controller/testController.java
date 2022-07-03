package com.fmw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
	
	@RequestMapping("testcall")
	public String test() {
		
		return "testCall!!";
	}

}
