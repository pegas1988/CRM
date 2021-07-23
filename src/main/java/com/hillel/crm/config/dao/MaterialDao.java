package com.hillel.crm.config.dao;

import com.hillel.crm.config.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDao extends JpaRepository<Material, Long> {

}
