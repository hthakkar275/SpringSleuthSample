package org.hemant.thakkar.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("featureTwoService")
public class FeatureTwoService {

	private static Log logger = LogFactory.getLog(FeatureTwoService.class);

	public String getStatus() {
		logger.info("Entering getStatus");
		String result = "Service B - Feature Two is alive\n";
		logger.info("Exiting getStatus");
		return result;
	}
}
