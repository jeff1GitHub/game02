package com.sf.consumer.schedual;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sf.consumer.schedual.impl.ReportFormServiceImpl;

@FeignClient(value = "report-form-service", fallback = ReportFormServiceImpl.class)
public interface IReportFormService {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHI(@RequestParam(value = "name") String name);
	
}
