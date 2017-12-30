package com.sf.report.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class TestController {
	
	@RequestMapping("/hi")
	public String hi(@RequestParam String name){
		if("hermes".equals(name)){
			JsonObject json = new JsonObject();
			json.addProperty("status", 200);
			json.addProperty("result", "hi " + name);
			return json.toString();
		}else{
			throw new RuntimeException("account error.");
		}
	}
	
}
