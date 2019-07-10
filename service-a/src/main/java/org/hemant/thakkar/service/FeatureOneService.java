package org.hemant.thakkar.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("featureOneService")
public class FeatureOneService {

	private static Log logger = LogFactory.getLog(FeatureOneService.class);

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	public String getStatus() {
		logger.info("Entering getStatus");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8091/serviceB/featureOne/status", 
				HttpMethod.GET, entity, String.class);
		String result = "Service A - Feature One is alive ---> " + response.getBody();
		logger.info("Exiting getStatus");
		return result;
	}
}
