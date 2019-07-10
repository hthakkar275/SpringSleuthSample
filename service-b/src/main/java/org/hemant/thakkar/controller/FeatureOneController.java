package org.hemant.thakkar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hemant.thakkar.service.FeatureOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureOneController {

	private static Log logger = LogFactory.getLog(FeatureOneController.class);

	@Autowired
	@Qualifier("featureOneService")
	private FeatureOneService featureOneService;

	@RequestMapping(value = "/serviceB/featureOne/status", method = RequestMethod.GET) 
	public String getStatus() {
		logger.info("Entering getStatus");
		String result = featureOneService.getStatus();
		logger.info("Exiting getStatus");
		return result;
	}
}

