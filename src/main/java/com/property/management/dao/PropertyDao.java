package com.property.management.dao;

import com.property.management.enums.RoomType;
import com.property.management.exception.PropertyServiceException;
import com.property.management.model.Property;

import java.util.*;

public class PropertyDao {
    private Map<String, Property> propertyMap;
    public PropertyDao(){
        this.propertyMap = new HashMap<>();
    }
    public void addProperty(Property property) throws  PropertyServiceException {
        if(propertyMap.containsKey(property.getId())){
            throw new PropertyServiceException("property cannot be added as it already exists");
        }
        else {
            propertyMap.put(property.getId(),property);
        }
    }

    public Property getProperties(String propertyId) {

        return this.propertyMap.get(propertyId);
    }

    public Optional<Property> getListedProperty(String id, String location, double amount, RoomType roomType) {
        Optional<Property> properties=this.propertyMap.values().stream().filter(p->p.getAddress().getLocation().equals(location)).findAny().filter(p->p.getPrice().getAmount()==amount).filter(p->p.getRoomType().equals(roomType));
        return properties;
    }
}
