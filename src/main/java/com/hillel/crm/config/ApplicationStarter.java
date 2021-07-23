package com.hillel.crm.config;

import com.hillel.crm.config.dao.ClientDao;
import com.hillel.crm.config.dao.MaterialDao;
import com.hillel.crm.config.dao.ProductDao;
import com.hillel.crm.config.entity.Client;
import com.hillel.crm.config.entity.Material;
import com.hillel.crm.config.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
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
