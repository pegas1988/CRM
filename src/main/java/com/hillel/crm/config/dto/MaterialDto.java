package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class MaterialDto {

    private Long ID;
    private String materialName;
    private int quantity;
    private String colour;
    private String density;
    private String type;
    private int price;
}
