package com.hillel.crm.config.utility;

import com.hillel.crm.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class)
        ) {
            final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));
        }
    }
}
