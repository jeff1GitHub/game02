package com.sf.consumer.schedual.impl;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.sf.consumer.schedual.IReportFormService;

@Component
public class ReportFormServiceImpl implements IReportFormService {

	@Override
	public String sayHI(String name) {
		JsonObject json = new JsonObject();
		json.addProperty("status", 501);
		json.addProperty("result", "sorry " + name);
		return json.toString();
	}

}
