package com.sf.report.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/hi")
	public String hi(@RequestParam String name){
		return "hi " + name;
	}
	
}
