package com.hillel.crm.config.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "material")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material extends BaseEntity {

    @Id
    @Column(name = "material_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "colour")
    private String colour;

    @Column(name = "density")
    private String density;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private int price;
}
