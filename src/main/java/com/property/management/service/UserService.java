package com.property.management.service;

import com.property.management.exception.UserServiceException;
import com.property.management.model.Property;
import com.property.management.model.User;
import com.property.management.response.BulkUserResponse;
import com.property.management.response.UserPropertyListResponse;

public interface UserService {
     void registerUser(User user) throws UserServiceException;
     void listPropertiesToSell(String userId,Property property);
     boolean isValid(User user);
     boolean isValid(String userId);
     UserPropertyListResponse getPropertyList(String userId) throws UserServiceException;

     BulkUserResponse getBulkUsers();

     UserPropertyListResponse getPropertyListofFavorites(String userId) throws UserServiceException;

     void addShortlistedProperties(String userId, Property property);

    // void filterproperties(Property property);
}
