package com.hillel.crm.config.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long Id;
    private String productName;
    private int priceOfAllMaterials;
    private int timeToProduce;
}
