package com.pta.flowers;
public class flowers {
    int image;
    String name;
    String description;
    int price;

    public flowers() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public flowers(int image, String name, String description, int price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
