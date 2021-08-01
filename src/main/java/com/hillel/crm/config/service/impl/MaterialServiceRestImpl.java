package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.MaterialDao;
import com.hillel.crm.config.dto.MaterialDto;
import com.hillel.crm.config.entity.Material;
import com.hillel.crm.config.service.rest.MaterialServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MaterialServiceRestImpl implements MaterialServiceRest {

    private final MaterialDao materialDao;

    @Override
    public Material getById(Long id) {
        Material material = materialDao.findById(id)
                .orElseThrow(() -> new RuntimeException("не удалось найти Material с id " + id));
        return material;
    }

    @Override
    public List<Material> findAll() {
        return materialDao.findAll();
    }

    @Override
    @Transactional
    public Material create(MaterialDto materialDto) {
        if (!Objects.isNull(materialDto.getID())) {
            throw new IllegalArgumentException("Failed to create Material. Material with such ID already exist.");
        }
        Material material = new Material();
        BeanUtils.copyProperties(materialDto, material);
        return materialDao.save(material);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!materialDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete material. Material with such ID doesnt exist.");
        }
        materialDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, MaterialDto materialDto) {
        if (!materialDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete material. Material with such ID doesnt exist.");
        }
        Material material = new Material();
        BeanUtils.copyProperties(materialDto, material);
        material.setID(id);
        materialDao.save(material);
    }
}
