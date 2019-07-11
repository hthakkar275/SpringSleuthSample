package org.hemant.thakkar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("featureOneService")
public class FeatureOneService {

	private static Logger logger = LoggerFactory.getLogger(FeatureOneService.class);

	public String getStatus() {
		logger.trace("Entering getStatus");
		String result = "Service B - Feature One is alive\n";
		logger.trace("Exiting getStatus");
		return result;
	}
	
}
