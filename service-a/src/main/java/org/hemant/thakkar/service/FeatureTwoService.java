package org.hemant.thakkar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("featureTwoService")
public class FeatureTwoService {

	private static Logger logger = LoggerFactory.getLogger(FeatureTwoService.class);

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	public String getStatus() {
		logger.trace("Entering getStatus");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8091/serviceB/featureTwo/status", 
				HttpMethod.GET, entity, String.class);
		String result = "Service A - Feature Two is alive ---> " + response.getBody();
		logger.trace("Exiting getStatus");
		return result;
	}
}
