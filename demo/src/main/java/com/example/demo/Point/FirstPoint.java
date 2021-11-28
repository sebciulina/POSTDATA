package com.example.demo.Point;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirstPoint {
    @JsonProperty("StreetNumber")
    String StreetNumber;
    @JsonProperty("Street")
    String Street;
    @JsonProperty("PostalCode")
    String PostalCode;
    @JsonProperty("City")
    String City;
    @JsonProperty("IsNormalized")
    boolean IsNormalized;

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public boolean isNormalized() {
        return IsNormalized;
    }

    public void setNormalized(boolean normalized) {
        IsNormalized = normalized;
    }

    @Override
    public String toString() {
        return "FirstPoint{" +
                "StreetNumber='" + StreetNumber + '\'' +
                ", Street='" + Street + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", City='" + City + '\'' +
                ", IsNormalized=" + IsNormalized +
                '}';
    }
}
