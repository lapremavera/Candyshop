package com.realdolmen.candyshop.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candy_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Person person;

    @OneToMany
    @JoinColumn(name = "Orderline_fk")
    List<OrderLine> orderLines = new ArrayList<>();
    @Embedded
    private Adress deliveryAddress;

    private double calculateTotal;

    public Order(Person person, Adress deliveryAddress) {
        this.person = person;
        this.deliveryAddress = deliveryAddress;

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
    public void addOrderLine(OrderLine CandyOrder){
        this.addOrderLine(CandyOrder);
    }


}
