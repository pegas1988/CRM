package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    private Integer Id;
    private String productName;
    private int priceOfAllMaterials;
    private int timeToProduce;
}
