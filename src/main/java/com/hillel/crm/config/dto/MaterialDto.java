package com.hillel.crm.config.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {

    private Long ID;
    private String materialName;
    private int quantity;
    private String colour;
    private String density;
    private String type;
    private int price;
}
