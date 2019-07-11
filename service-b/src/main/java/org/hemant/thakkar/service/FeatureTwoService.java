package org.hemant.thakkar.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("featureTwoService")
public class FeatureTwoService {

	private static Logger logger = LoggerFactory.getLogger(FeatureTwoService.class);

	@Autowired
	private Executor executor;
		
	public String getStatus() {
		logger.trace("Entering getStatus");
		String result = doInSeparateThread();
		logger.trace("Exiting getStatus");
		return result;
	}
	
	private String doInSeparateThread() {
		logger.trace("Entering doInSeparateThread");
		String status = CompletableFuture.supplyAsync(new Supplier<String>() {
			public String get() {
				logger.trace("Entering thread inside doInSeparateThread");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String result = "Service B - Feature Two is alive from thread\n";
				logger.trace("Exiting thread inside doInSeparateThread");
				return result;
			}
		}, executor).join();
		logger.trace("Exiting doInSeparateThread");
		return status;
	}

}
