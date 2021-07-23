package com.hillel.crm.config.dao;

import com.hillel.crm.config.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
