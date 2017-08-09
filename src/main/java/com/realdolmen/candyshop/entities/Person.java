package com.realdolmen.candyshop.entities;

import com.realdolmen.candyshop.util.Datebuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
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
    private Adress adress;
    @CollectionTable(name = "candyPreference")
            @Column(name = "color")
    List<Candycolor> candyPreference = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + Datebuilder.createString(birthdate) + '\'' +
                '}';
    }
}
