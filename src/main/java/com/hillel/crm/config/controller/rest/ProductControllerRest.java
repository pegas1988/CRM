package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.ProductDto;
import com.hillel.crm.config.entity.Product;
import com.hillel.crm.config.service.impl.ProductServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/product")
public class ProductControllerRest {
    final ProductServiceRestImpl productServiceRest;

    @GetMapping(value = "/find-by-id/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        final Product product = productServiceRest.getById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<ProductDto>> findAll() {
        List<Product> productList = productServiceRest.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto();
                    BeanUtils.copyProperties(product, productDto);
                    return productDto;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productServiceRest.delete(id);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        final Product product = productServiceRest.create(productDto);
        productDto.setId(product.getId());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productServiceRest.update(id, productDto);
    }
}
