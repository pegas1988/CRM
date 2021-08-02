package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.MaterialDto;
import com.hillel.crm.config.entity.Material;
import com.hillel.crm.config.service.impl.MaterialServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/material")
@RequiredArgsConstructor
public class MaterialControllerRest {
    private final MaterialServiceRestImpl materialServiceRest;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<MaterialDto> findById(@PathVariable Long id) {
        final Material material = materialServiceRest.getById(id);
        MaterialDto materialDto = new MaterialDto();
        BeanUtils.copyProperties(material, materialDto);
        return new ResponseEntity<>(materialDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MaterialDto>> findAll() {
        List<Material> materialList = materialServiceRest.findAll();
        List<MaterialDto> materialDtoList = materialList.stream()
                .map(material -> {
                    MaterialDto materialDto = new MaterialDto();
                    BeanUtils.copyProperties(material, materialDto);
                    return materialDto;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(materialDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MaterialDto> create(@RequestBody MaterialDto materialDto) {
        final Material material = materialServiceRest.create(materialDto);
        materialDto.setID(material.getID());
        return new ResponseEntity<>(materialDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        materialServiceRest.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody MaterialDto materialDto) {
        materialServiceRest.update(id, materialDto);
    }
}

