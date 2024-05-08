package com.example.codereviewnovaserve.dto;

public class CarDto {
    private int id;
    private String brand;

    private String model;

    private double weight;

    private double height;

    private double width;

    private String color;

    private double engineLiters;

    public CarDto() {
    }


    public CarDto(String brand, String model, double weight, double height, double width, String color, double engineLiters) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.color = color;
        this.engineLiters = engineLiters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
