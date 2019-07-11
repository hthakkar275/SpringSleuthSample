package org.hemant.thakkar.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorFactory {

	@Autowired
	private BeanFactory beanFactory;

	@Bean
	public Executor executor() {
//		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//		threadPoolTaskExecutor.setCorePoolSize(10);
//		threadPoolTaskExecutor.setMaxPoolSize(10);
//		threadPoolTaskExecutor.setThreadFactory(new ThreadFactory() {
//			public Thread newThread(Runnable r) {
//				Thread t = new Thread(r, "General");
//				t.setDaemon(true);
//				return t;
//			}
//		});
//		threadPoolTaskExecutor.initialize();
//		return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);

		Executor executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r, "General");
				t.setDaemon(true);
				return t;
			}
		});
		return new LazyTraceExecutor(beanFactory, executor);

	}

}
