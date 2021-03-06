package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class ImageAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageAnalyzerApplication.class, args);
	}
}
