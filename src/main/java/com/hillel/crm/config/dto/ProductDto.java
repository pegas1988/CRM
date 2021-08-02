package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ProductDto {

    private Long Id;
    private String productName;
    private int priceOfAllMaterials;
    private int timeToProduce;
}
