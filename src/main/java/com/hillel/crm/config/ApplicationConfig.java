package com.hillel.crm.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan (basePackages = {"com.hillel.crm.config"})
@EnableJpaRepositories(basePackages = {"com.hillel.crm.config.dao"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
