package com.property.management.dao;

import com.property.management.enums.RoomType;
import com.property.management.exception.UserServiceException;
import com.property.management.model.Property;
import com.property.management.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private Map<String,User> userMap;
    private Map<String,List<Property>> userProperties;
    private Map<String,List<Property>> userShorlistedproperties;
    public UserDao(){
        this.userMap = new HashMap<>();
        this.userProperties = new HashMap<>();
    }
    public void registerUser(User user) throws UserServiceException {
        if(userMap.containsKey(user.getId())){
            throw new UserServiceException("user is already registerd with the emailId: "+user.getId() );
        }
       else {
           userMap.put(user.getId(),user);
        }
    }

    public void saveProperties(Property property) {

    }
    public void addProperties(String userId,List<Property> properties){
        this.userProperties.put(userId,properties);
    }
    public List<Property> getListedProperty(String userId) throws UserServiceException {
        User user = userMap.get(userId);
        if(user==null){
            throw new UserServiceException("User doesn't exists");
        }
        if(userProperties.get(userId)==null){
            throw new UserServiceException("No property listed for this user");
        }
        return this.userProperties.get(userId);
    }

    public List<User> getBulkUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(this.userMap.values());
        return users;
    }

    public void addShortListedProperties(String userId, List<Property> properties) {
        this.userShorlistedproperties.put(userId,properties);
    }

    public List<Property> getPropertyListOfFavorites(String userId) throws UserServiceException {
        User user = userMap.get(userId);
        if(user==null){
            throw new UserServiceException("User doesn't exists");
        }
        if(userShorlistedproperties.get(userId)==null){
            throw new UserServiceException("No property listed for this user");
        }
        return this.userShorlistedproperties.get(userId);
    }


}
