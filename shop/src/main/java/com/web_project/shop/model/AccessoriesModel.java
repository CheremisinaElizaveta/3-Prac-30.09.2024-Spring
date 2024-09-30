package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class AccessoriesModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "Название не менее трех символов")
    private String name;
    private String brand;
    private String category;
    private String material;
    private String color;
    private double price;

    public AccessoriesModel(){}

    public AccessoriesModel(Long id, String name, String brand, String category, String material, String color, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.material = material;
        this.color = color;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Название не менее трех символов") String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Название не менее трех символов") String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
