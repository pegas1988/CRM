package config;

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
@ComponentScan (basePackages = {"dao", "controller", "service", "utility"})
@EnableJpaRepositories(basePackages = {"dao", "controller", "service", "utility", "entity"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() throws SQLException {
       PGSimpleDataSource ds = new PGSimpleDataSource();
       ds.setUser(environment.getProperty("spring.datasource.user"));
       ds.setPassword(environment.getProperty("spring.datasource.password"));
       ds.setURL(environment.getProperty("spring.datasource.url"));
        return ds.unwrap(DataSource.class);
    }
}
