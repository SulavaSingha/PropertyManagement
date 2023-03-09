package com.property.management.service.impl;

import com.property.management.dao.UserDao;
import com.property.management.enums.RoomType;
import com.property.management.exception.UserServiceException;
import com.property.management.model.Property;
import com.property.management.model.User;
import com.property.management.response.BulkUserResponse;
import com.property.management.response.UserPropertyListResponse;
import com.property.management.service.UserService;
import com.property.management.validator.UserValidator;
import com.property.management.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    List<Property> propertyList;
    List<Property> shortListedProperties;
    UserValidator validator ;
    public UserServiceImpl(){
        this.userDao = new UserDao();
        this.propertyList= new ArrayList<>();
        validator= new UserValidator();
    }

    public void registerUser(User user) throws UserServiceException {
        userDao.registerUser(user);
    }

    @Override
    public void listPropertiesToSell(final String userId,final Property property){
        this.propertyList.add(property);
        userDao.addProperties(userId,propertyList);
    }
    public List<Property> getPropertyList(){
        return this.propertyList;
    }
    public UserPropertyListResponse getPropertyList(String userId) throws UserServiceException {
        List<Property> propertyList = userDao.getListedProperty(userId);
        UserPropertyListResponse response = UserPropertyListResponse.internalBuilder().propertyList(propertyList).build();
        return response;
    }

    @Override
    public BulkUserResponse getBulkUsers() {
        BulkUserResponse bulkUserResponse ;
        List<User>users=userDao.getBulkUsers();
        bulkUserResponse = BulkUserResponse.internalBuilder().users(users).build();
        return bulkUserResponse;
    }

    @Override
    public UserPropertyListResponse getPropertyListofFavorites(String userId) throws UserServiceException {
        List<Property> ShortListedProperties=userDao.getPropertyListOfFavorites(userId);
        UserPropertyListResponse response =UserPropertyListResponse.internalBuilder().propertyList(shortListedProperties).build();
        return response;
    }

    @Override
    public void addShortlistedProperties(String userId, Property property) {
        this.shortListedProperties.add(property);
        userDao.addShortListedProperties(userId,shortListedProperties);
    }
    public boolean isValid(User user){
       return  this.validator.isValid(user);
    }

    public boolean isValid(String userId) {
        return validator.isValid(userId);
    }
}
