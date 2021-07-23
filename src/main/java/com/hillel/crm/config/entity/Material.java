package com.hillel.crm.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material extends BaseEntity{

    @Id
    @Column(name = "material_id")
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

    public Material() {
    }

    public Material(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
