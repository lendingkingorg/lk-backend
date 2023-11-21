package com.lkbackend.lkbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LkBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LkBackendApplication.class, args);
	}

}
