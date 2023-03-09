package com.property.management.model;

public class User {
    private final String id;
    private final String name;
    private final Address address;
    private final String phoneNumber;

    public User(String emailId, String name, String phoneNumber, Address address) {
        this.id = emailId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
