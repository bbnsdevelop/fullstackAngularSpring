package br.com.fullstackAngularSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FullstackAngularSpringApplication {
	private static final Logger logger = LoggerFactory.getLogger(FullstackAngularSpringApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FullstackAngularSpringApplication.class, args);
		logger.info("--Application Started--");
	}
}
