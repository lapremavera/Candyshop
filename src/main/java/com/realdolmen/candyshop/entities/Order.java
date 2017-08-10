package com.realdolmen.candyshop.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person person;

    List<OrderLine> orderLines = new ArrayList<>();
    @Embedded
    private Adress deliveryAddress;

    private double calculateTotal;

    public Order(Long id, Person person, List<OrderLine> orderLines, Adress deliveryAddress, double calculateTotal) {
        this.id = id;
        this.person = person;
        this.orderLines = orderLines;
        this.deliveryAddress = deliveryAddress;
        this.calculateTotal = calculateTotal;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Adress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Adress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getCalculateTotal() {
        return calculateTotal;
    }

    public void setCalculateTotal(double calculateTotal) {
        this.calculateTotal = calculateTotal;
    }

    public double calculateTotal(){
        int total = 0;
        for(OrderLine l : orderLines) {
            total+= l.calculateSubTotal();
        }
        return total;

        //return orderLines.stream().mapToDouble(OrderLine::calculateSubTotal).sum();
    }


}
