package com.reporting.tool.ReportingTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.reporting.tool"})
@Configuration
@EnableJpaRepositories("com.reporting.tool.repository")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EntityScan("com.reporting.tool.entity")
public class ReportingToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingToolApplication.class, args);
	}

}
