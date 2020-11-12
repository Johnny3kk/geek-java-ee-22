package ru.geekbrains.shop.persist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal cost;

    public Product() {
    }

    public Product(Long id, String name, String brand, String description, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
