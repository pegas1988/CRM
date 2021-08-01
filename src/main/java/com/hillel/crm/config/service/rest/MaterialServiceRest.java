package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.MaterialDto;
import com.hillel.crm.config.entity.Material;

import java.util.List;

public interface MaterialServiceRest {
    public Material getById(Long id);

    List<Material> findAll();

    Material create(MaterialDto materialDto);

    public void delete(Long id);

    public void update(Long id, MaterialDto materialDto);
}
