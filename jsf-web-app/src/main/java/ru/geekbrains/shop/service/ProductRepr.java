package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Boxing;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProductRepr implements Serializable {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String description;

    @NotNull
    private BigDecimal cost;

    private Long boxingId;

    private String boxingName;

    public ProductRepr() {
    }

    public ProductRepr(Long id, @NotEmpty String name, @NotEmpty String brand, @NotEmpty String description, @NotNull BigDecimal cost, Boxing boxing) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.cost = cost;
        this.boxingId = boxing != null ? boxing.getId() : null;
        this.boxingName = boxing != null ? boxing.getName() : null;
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

    public Long getBoxingId() {
        return boxingId;
    }

    public void setBoxingId(Long boxingId) {
        this.boxingId = boxingId;
    }

    public String getBoxingName() {
        return boxingName;
    }

    public void setBoxingName(String boxingName) {
        this.boxingName = boxingName;
    }
}
