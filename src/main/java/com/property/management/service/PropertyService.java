package com.property.management.service;

import com.property.management.exception.PropertyServiceException;
import com.property.management.model.Property;
import com.property.management.response.PropertyListResponse;

public interface PropertyService {
     void addProperties(Property property) throws PropertyServiceException;


     PropertyListResponse getProperties(String propertyId);
     PropertyListResponse filterproperties(Property property);
}
