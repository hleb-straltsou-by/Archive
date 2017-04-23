package com.gv.archive.xml.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * represents address model
 */
public class Address{

    @XStreamAlias("country")
    /** country property */
    private String country;

    @XStreamAlias("city")
    /** city property */
    private String city;

    @XStreamAlias("street")
    /** street property */
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
