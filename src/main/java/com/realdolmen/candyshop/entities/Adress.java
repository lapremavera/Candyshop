package com.realdolmen.candyshop.entities;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Adress {


    private String streetName;
    private String streetNameNumber;
    private String city;
    private String zipcode;
    private String country;

    public Adress(String streetName, String streetNameNumber, String city, String zipcode, String country) {
        this.streetName = streetName;
        this.streetNameNumber = streetNameNumber;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Adress() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNameNumber() {
        return streetNameNumber;
    }

    public void setStreetNameNumber(String streetNameNumber) {
        this.streetNameNumber = streetNameNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Adress{" +
                " streetName='" + streetName + '\'' +
                ", streetNameNumber='" + streetNameNumber + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
