package com.property.management.model;

import com.property.management.enums.ListingType;
import com.property.management.enums.PropertyStatus;
import com.property.management.enums.RoomType;

public class Property {
    private final String id;
    private final String name;
    private final Address address;
    private Price price;
    private ListingType propertyType;
    private RoomType roomType;
    private PropertyStatus propertyStatus;

    public Property(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public void setPropertyType(ListingType type){
        this.propertyType=type;
    }
    public ListingType getPropertyType(){
        return this.propertyType;
    }
    public void setroomType(RoomType type){
        this.roomType =type;
    }
    public RoomType getRoomType(){
        return this.roomType;
    }
    public void setPrice(Price price){
        this.price=price;
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

    public Price getPrice() {
        return price;
    }

    public void setPropertyStatus(PropertyStatus sold) {
        this.propertyStatus=propertyStatus;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }
}
