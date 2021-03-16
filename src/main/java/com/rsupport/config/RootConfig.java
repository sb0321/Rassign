package com.rsupport.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		
	    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    EmbeddedDatabase db = builder
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("classpath:db/init.sql")
	    		.addScript("classpath:db/addParameters.sql")
	    		.build();
		
		return db;
	}

}
