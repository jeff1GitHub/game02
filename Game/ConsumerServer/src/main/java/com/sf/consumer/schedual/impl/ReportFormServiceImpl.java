package com.sf.consumer.schedual.impl;

import org.springframework.stereotype.Component;

import com.sf.consumer.schedual.IReportFormService;

@Component
public class ReportFormServiceImpl implements IReportFormService {

	@Override
	public String sayHI(String name) {
		System.out.println("-----------------------");
		return "sorry " + name;
	}

}
