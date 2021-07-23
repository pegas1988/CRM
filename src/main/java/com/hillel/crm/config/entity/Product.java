package com.hillel.crm.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private Integer Id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "material_price")
    private int priceOfAllMaterials;

    @Column(name = "production_time")
    private int timeToProduce;

    public String getProductName() {
        return productName;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPriceOfAllMaterials() {
        return priceOfAllMaterials;
    }

    public void setPriceOfAllMaterials(int priceOfAllMaterials) {
        this.priceOfAllMaterials = priceOfAllMaterials;
    }

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public void setTimeToProduce(int timeToProduce) {
        this.timeToProduce = timeToProduce;
    }
}

