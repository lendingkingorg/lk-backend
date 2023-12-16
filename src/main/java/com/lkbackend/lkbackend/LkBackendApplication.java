package com.lkbackend.lkbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.*"})
@EnableJpaRepositories("com.lkbackend.lkbackend.repository")
@SpringBootApplication(exclude={ SecurityAutoConfiguration.class})
public class LkBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LkBackendApplication.class, args);
	}

}
