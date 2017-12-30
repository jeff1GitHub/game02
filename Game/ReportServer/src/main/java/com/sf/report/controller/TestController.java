package com.sf.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/hi")
	public String hi(@RequestParam String name){
		if("hermes".equals(name)){
			logger.info("account {}", name);
			JsonObject json = new JsonObject();
			json.addProperty("status", 200);
			json.addProperty("result", "hi " + name);
			return json.toString();
		}else{
			logger.error("account error. {}", name);
			throw new RuntimeException("account error.");
		}
	}
	
}
