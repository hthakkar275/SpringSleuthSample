package org.hemant.thakkar.controller;

import org.hemant.thakkar.service.FeatureOneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureOneController {

	private static Logger logger = LoggerFactory.getLogger(FeatureOneController.class);

	@Autowired
	@Qualifier("featureOneService")
	private FeatureOneService featureOneService;

	@RequestMapping(value = "/serviceA/featureOne/status", method = RequestMethod.GET) 
	public String getStatus() {
		logger.trace("Entering getStatus");
		String result = featureOneService.getStatus();
		logger.trace("Exiting getStatus");
		return result;
	}
}

