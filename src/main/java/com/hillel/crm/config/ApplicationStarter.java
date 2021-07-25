package com.hillel.crm.config;

import com.hillel.crm.config.dao.MaterialDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Optional;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)){
//            final ProductDao bean = (ProductDao) ctx.getBean("productDao");
//            final List<Product> products = bean.findAll();
            final MaterialDao bean = (MaterialDao) ctx.getBean("materialDao");
            final Optional products = bean.findById(13l);
            System.out.println(products.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
