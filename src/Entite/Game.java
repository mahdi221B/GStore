/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author mahdi
 */
public class Game {
    String name,img,Description;
    float price;

    public Game(String name, float price, String img, String Description) {
        this.name = name;
        this.img = img;
        this.Description = Description;
        this.price = price;
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

    @Override
    public String toString() {
        return "Game{" + "name=" + name + ", img=" + img + ", Description=" + Description + ", price=" + price + '}';
    }
}
