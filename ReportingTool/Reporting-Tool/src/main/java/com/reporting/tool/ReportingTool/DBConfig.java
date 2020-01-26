package com.reporting.tool.ReportingTool;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

	@Bean
	public DataSource getDataSource() {
		System.out.println("--------DB Connection start--------");
		DataSourceBuilder<DataSource> dataSourceBuilder = (DataSourceBuilder<DataSource>) DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/reporting?autoReconnect=true&useSSL=false");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		System.out.println("--------DB Connected--------");
		return dataSourceBuilder.build();
	}
}
