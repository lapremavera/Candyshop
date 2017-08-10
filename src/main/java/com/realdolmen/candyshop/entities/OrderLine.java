package com.realdolmen.candyshop.entities;


import com.sun.javafx.geom.transform.Identity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Candy candy;

    private double calculateSubTotal;

    public OrderLine(double calculateSubTotal) {
        this.calculateSubTotal = calculateSubTotal;
    }

    public OrderLine(int quantity, Candy candy) {
        this.quantity = quantity;
        this.candy = candy;
    }

    public OrderLine() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public double getCalculateSubTotal() {
        return calculateSubTotal;
    }

    public void setCalculateSubTotal(double calculateSubTotal) {
        this.calculateSubTotal = calculateSubTotal;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", candy=" + candy +
                ", calculateSubTotal=" + calculateSubTotal +
                '}';
    }
    public double calculateSubTotal() {

        return candy.getPrice() * quantity;
    }


}
