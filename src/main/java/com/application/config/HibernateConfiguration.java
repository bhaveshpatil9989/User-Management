package com.application.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Value("${driver.class}")
	private  String DRIVER_CLASS;
	
	@Value("${db.url}")
	private  String DB_URL;
	
	@Value("${hibernate.dialect}")
	private  String DIALECT;
	
	
	@Bean
    public DataSource dataSource() {
		System.out.println("DRIVER_CLASS : "+DRIVER_CLASS);
		System.out.println("DB_URL : "+DB_URL);
		System.out.println("DIALECT : "+DIALECT);
		ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");
		try {
			dataSource.setDriverClass(DRIVER_CLASS);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
        dataSource.setJdbcUrl(DB_URL);
        dataSource.setUser("root");
        
        dataSource.setPassword("root");
 
        return dataSource;
    }
	
	@Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("com.application.entity");
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }
	  
	  @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {
	        HibernateTransactionManager transactionManager
	          = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	  
	  private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        hibernateProperties.setProperty("show_sql", "true");
	        hibernateProperties.setProperty("format_sql", "true");
	        hibernateProperties.setProperty("use_sql_comments", "true");
	        return hibernateProperties;
	    }

}
