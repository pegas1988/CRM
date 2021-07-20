package config;

import dao.ClientDao;
import entity.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)){
            final ClientDao bean = ctx.getBean(ClientDao.class);
            final List<Client> clientList = bean.findAll();
            clientList.forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
