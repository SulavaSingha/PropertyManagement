package com.property.management.model;

public class Address {
    private final String housenumber;
    private final String Street;
    private final String location;
    private final String pincode;

    public Address(String housenumber, String street, String location, String pincode) {
        this.housenumber = housenumber;
        Street = street;
        this.location = location;
        this.pincode = pincode;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getStreet() {
        return Street;
    }

    public String getLocation() {
        return location;
    }

    public String getPincode() {
        return pincode;
    }
}
