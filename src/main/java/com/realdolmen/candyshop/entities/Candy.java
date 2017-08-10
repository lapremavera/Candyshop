package com.realdolmen.candyshop.entities;

import javax.persistence.*;

@Entity
public class Candy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Candycolor candyColor;
    private int price;



    public void setPrice(int price) {
        this.price = price;
    }

    public Candy(String name, Candycolor candyColor) {
        this.name = name;
        this.candyColor = candyColor;
    }

    public Candy() {
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

    public Candycolor getCandyColor() {
        return candyColor;
    }

    public void setCandyColor(Candycolor candyColor) {
        this.candyColor = candyColor;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", candyColor=" + candyColor +
                '}';
    }
}
