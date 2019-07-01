package com.ps.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class M3Application {

	public static void main(String[] args) {
		SpringApplication.run(M3Application.class, args);
	}

}
