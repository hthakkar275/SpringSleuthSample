package org.hemant.thakkar.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateFactory {

	private static Log logger = LogFactory.getLog(RestTemplateFactory.class);
	
	@Bean(name = "restTemplate")
	public RestTemplate getRestTemplate() {
		logger.info("Entering getRestTemplate");
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Exiting getRestTemplate");
		return restTemplate;
	}
}
