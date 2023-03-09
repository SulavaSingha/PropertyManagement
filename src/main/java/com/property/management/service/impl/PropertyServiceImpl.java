package com.property.management.service.impl;

import com.property.management.dao.PropertyDao;
import com.property.management.enums.RoomType;
import com.property.management.exception.PropertyServiceException;
import com.property.management.model.Property;
import com.property.management.response.PropertyListResponse;
import com.property.management.service.PropertyService;

import java.util.List;
import java.util.Optional;


public class PropertyServiceImpl implements PropertyService {
    private PropertyDao propertyDao;
    public PropertyServiceImpl(){
        this.propertyDao = new PropertyDao();
    }

    @Override
    public void addProperties(Property property) throws PropertyServiceException {
        propertyDao.addProperty(property);
    }

    @Override
    public PropertyListResponse getProperties(String propertyId) {
        PropertyListResponse response;
        Property property=propertyDao.getProperties(propertyId);
        response=PropertyListResponse.internalBuilder().property(property).build();
        return response;
    }
    @Override
    public PropertyListResponse filterproperties(Property property) {
        final String id = property.getId();
        final String location = property.getAddress().getLocation();
        final double amount = property.getPrice().getAmount();
        final RoomType roomType = property.getRoomType();
        Optional<Property> properties=propertyDao.getListedProperty(id,location,amount,roomType);
        PropertyListResponse response = PropertyListResponse.internalBuilder().property(properties.get()).build();
        return response;
    }
}
