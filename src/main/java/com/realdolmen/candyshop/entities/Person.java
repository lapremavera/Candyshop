package com.realdolmen.candyshop.entities;

import com.realdolmen.candyshop.util.Datebuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "FIND_BY_LAST_NAME",query = "select p from Person p where p.lastName = :lname")
//lname is een key die ik uitgevonden heb om de lastName te vinden
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(max = 200)
    private String firstName;
    @NotNull @Size(max = 200)
    private String lastName;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date birthdate;
    @Transient
    private Long age;
    @Embedded
    private Adress deliveryAdress;
    @CollectionTable(name = "candyPreference")
            @Column(name = "color")
            @ElementCollection
    List<Candycolor> candyPreference = new ArrayList<>();
    @OneToMany(mappedBy = "person")
    List<Order>orderHistory = new ArrayList<>();


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = Datebuilder.createDate(birthdate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Adress getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public List<Candycolor> getCandyPreference() {
        return candyPreference;
    }

    public void setCandyPreference(List<Candycolor> candyPreference) {
        this.candyPreference = candyPreference;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + Datebuilder.createString(birthdate) + '\'' +
                '}';
    }
    public void addOrderToHistory(Order candyOrderHistory){
        this.addOrderToHistory(candyOrderHistory);

    }
}
