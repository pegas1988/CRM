package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.ProductDao;
import com.hillel.crm.config.dto.ProductDto;
import com.hillel.crm.config.entity.Product;
import com.hillel.crm.config.service.rest.ProductServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceRestImpl implements ProductServiceRest {

    private final ProductDao productDao;

    @Override
    public Product getById(Long id) {
        Product product = productDao.findById(id)
                .orElseThrow(() -> new RuntimeException("не удалось найти Product с id " + id));
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public Product create(ProductDto productDto) {
        if (!Objects.isNull(productDto.getId())) {
            throw new IllegalArgumentException("Failed to create product. Product with such ID already exist.");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productDao.save(product);
    }

    @Override
    public void delete(Long id) {
        if (!productDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete product. Product with such ID doesnt exist.");
        }
        productDao.deleteById(id);
    }

    @Override
    public void update(Long id, ProductDto productDto) {
        if (!productDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to update product. Product with such ID doesnt exist.");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setId(id);
        productDao.save(product);
    }
}
