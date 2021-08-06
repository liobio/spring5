package com.liobio.bean;

public class Car {
    private String carname;
    private String color;
    private Integer price;

    @Override
    public String toString() {
        return "Car{" +
                "carname='" + carname + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public Car() {
    }

    public Car(String carname, String color, Integer price) {
        this.carname = carname;
        this.color = color;
        this.price = price;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
