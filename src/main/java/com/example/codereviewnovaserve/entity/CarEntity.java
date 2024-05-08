package com.example.codereviewnovaserve.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review_cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @Column(name = "width")
    private double width;

    @Column(name = "color")
    private String color;

    @Column(name = "engine_capacity")
    private double engineLiters;

    public CarEntity() {
    }

    public CarEntity(String brand, String model, double weight, double height, double width, String color, double engineLiters) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.color = color;
        this.engineLiters = engineLiters;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineLiters() {
        return engineLiters;
    }

    public void setEngineLiters(double engineLiters) {
        this.engineLiters = engineLiters;
    }


}
