package org.hemant.thakkar.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("featureOneService")
public class FeatureOneService {

	private static Log logger = LogFactory.getLog(FeatureOneService.class);

	public String getStatus() {
		logger.info("Entering getStatus");
		String result = "Service B - Feature One is alive\n";
		logger.info("Exiting getStatus");
		return result;
	}
}
