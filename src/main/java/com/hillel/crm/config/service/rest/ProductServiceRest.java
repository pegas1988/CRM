package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.ProductDto;
import com.hillel.crm.config.entity.Product;

import java.util.List;

public interface ProductServiceRest {
    public Product getById(Long id);

    List<Product> findAll();

    Product create(ProductDto productDto);

    public void delete(Long id);

    public void update(Long id, ProductDto productDto);
}
