package com.hillel.crm.config.dao;

import com.hillel.crm.config.entity.Material;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface MaterialDao extends JpaRepository<Material, Long> {

}
