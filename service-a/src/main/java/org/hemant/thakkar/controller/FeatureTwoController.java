package org.hemant.thakkar.controller;

import org.hemant.thakkar.service.FeatureTwoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureTwoController {

	private static Logger logger = LoggerFactory.getLogger(FeatureTwoController.class);

	@Autowired
	@Qualifier("featureTwoService")
	private FeatureTwoService featureTwoService;

	@RequestMapping(value = "/serviceA/featureTwo/status", method = RequestMethod.GET) 
	public String getStatus() {
		logger.trace("Entering getStatus");
		String result = featureTwoService.getStatus();
		logger.trace("Exiting getStatus");
		return result;
	}
}

