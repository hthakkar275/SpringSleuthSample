package org.hemant.thakkar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hemant.thakkar.service.FeatureTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureTwoController {

	private static Log logger = LogFactory.getLog(FeatureTwoController.class);

	@Autowired
	@Qualifier("featureTwoService")
	private FeatureTwoService featureTwoService;

	@RequestMapping(value = "/serviceB/featureTwo/status", method = RequestMethod.GET) 
	public String getStatus() {
		String result = featureTwoService.getStatus();
		return result;
	}
}

