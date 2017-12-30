package com.sf.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.consumer.schedual.IReportFormService;

@RestController
public class ReportFormController {
	@Autowired
	private IReportFormService reportFormService;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHI(@RequestParam String name) {
		String msg = reportFormService.sayHI(name);
		return msg;
	}

}
