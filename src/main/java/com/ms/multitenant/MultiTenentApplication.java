package com.ms.multitenant;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.ms.multitenant.configs.DatabaseConfigurations;
import com.ms.multitenant.configs.TenantRoutingDataSource;



@SpringBootApplication
@EnableConfigurationProperties(DatabaseConfigurations.class)
public class MultiTenentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenentApplication.class, args);
	}

	 @Autowired
	    DatabaseConfigurations databaseConfigurations;

	    @Bean
	    public DataSource dataSource() {
	    	TenantRoutingDataSource dataSource = new TenantRoutingDataSource();
	        dataSource.setTargetDataSources(databaseConfigurations.createTargetDataSources());
	        return dataSource;
	    }
	    
}
