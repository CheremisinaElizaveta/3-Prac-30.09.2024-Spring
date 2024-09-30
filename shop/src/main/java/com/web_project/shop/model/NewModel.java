package com.web_project.shop.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class NewModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Size(min = 3, message = "Название не менее трех символов")
    private String name;
    private String brand;
    private String category;
    @Nullable
    private String size;
    @Nullable
    private double price;

    public NewModel(){}

    public NewModel(Long id, String name, String brand, String category, @Nullable String size, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.size = size;
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

    @Nullable
    public String getSize() {
        return size;
    }

    public void setSize(@Nullable String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
