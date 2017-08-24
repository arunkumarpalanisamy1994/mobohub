package com.myproject;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
public class AppConfig {
	@Bean(name = "dataSource")
    public DataSource getDataSource()
    {
		System.out.println("1");
    	BasicDataSource dataSource = new BasicDataSource();
    	System.out.println("1");
    	dataSource.setDriverClassName("org.h2.Driver");
    	System.out.println("1");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	System.out.println("1");
    	dataSource.setUsername("sa");
    	System.out.println("1");
    	dataSource.setPassword("");
    	return dataSource;
    }
	@Autowired
	@Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
		System.out.println("2");
    	LocalSessionFactoryBuilder sessionBuilder = 
    		new LocalSessionFactoryBuilder(dataSource);
    	System.out.println("2");
    	sessionBuilder.scanPackages("com.myproject.model");
    	System.out.println("2");
    	sessionBuilder.setProperty("hibernate.show_sql", "true");
    	System.out.println("2");
    	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	System.out.println("2");
    	sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
    	
    	return sessionBuilder.buildSessionFactory();
    }

}





