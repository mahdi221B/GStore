/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.Entite;

/**
 *
 * @author mahdi
 */
public class Game {
    String name,img,Description,url;
    float price;

    public Game(String name, float price, String img, String Description, String url) {
        this.name = name;
        this.img = img;
        this.Description = Description;
        this.price = price;
        this.url = url;
    }
    
    public Game(String name, float price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return Description;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Game{" + "name=" + name + ", img=" + img + ", Description=" + Description + ", url=" + url + ", price=" + price + '}';
    }


}
