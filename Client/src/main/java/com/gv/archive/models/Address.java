package com.gv.archive.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Address{

    @XStreamAlias("country")
    private String country;

    @XStreamAlias("city")
    private String city;

    @XStreamAlias("street")
    private String street;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
