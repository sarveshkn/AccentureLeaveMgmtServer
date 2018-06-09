package com.leavemgmt.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan ( { "com.leavemgmt.controller" })
public class LeaveManagementApplication extends SpringBootServletInitializer {

	public static void main(String args[]) {
		SpringApplication.run(LeaveManagementApplication.class, args);
	}
}
