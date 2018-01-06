package com.altimetrik.manch.usecase;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * The accounts web-application. This class has two uses:
 * <ol>
 * <li>Provide configuration and setup for micosrvice ... or</li>
 * <li>Run as a stand-alone Spring Boot web-application for testing (in which
 * case there is <i>no</i> microservice registration</li>
 * </ol>
 * <p>
 * To execute as a microservice, run Microserver class instead.
 * 
 */
@SpringBootApplication
@EnableAsync
@PropertySource("classpath:db-config.properties")
//@PropertySource("file:${properties.location}/db-config.properties") 
public class WebApplication {

	protected Logger logger = Logger.getLogger(WebApplication.class
			.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
//		System.setProperty("spring.config.name", "application");
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Manch");
        executor.initialize();
        return executor;
    }

}
