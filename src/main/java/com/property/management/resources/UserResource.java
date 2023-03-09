package com.property.management.resources;

import com.property.management.exception.UserServiceException;
import com.property.management.model.Property;
import com.property.management.model.User;
import com.property.management.response.BulkUserResponse;
import com.property.management.response.PropertyListResponse;
import com.property.management.response.UserPropertyListResponse;
import com.property.management.response.UserPropertySearchResponse;
import com.property.management.service.PropertyService;
import com.property.management.service.UserService;
import com.property.management.service.impl.PropertyServiceImpl;
import com.property.management.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("v1/property-management-service")
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService){
        this.userService=userService;
    }
    @PostMapping(value="/register/user", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<User> registerAnUser(@RequestBody final User user){
        if(!this.userService.isValid(user)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            userService.registerUser(user);
        }catch(UserServiceException exception){
            Logger.getLogger(exception.getMessage(),user.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="get/bulkUsers", method=RequestMethod.GET)
    public ResponseEntity<BulkUserResponse> listRegisterUsers(){
        BulkUserResponse response= userService.getBulkUsers();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping(value="/add/properties/{userId}")
    public ResponseEntity<Property> addproperty(@PathVariable final String userId,@RequestBody final Property property){
        userService.listPropertiesToSell(userId,property);
        return new ResponseEntity<Property>(property,HttpStatus.ACCEPTED);
    }
    @PostMapping(value="/add/properties/favroite/{userId}")
    public ResponseEntity<Property> addpropertyShortlisted(@PathVariable final String userId,@RequestBody final Property property){
        userService.addShortlistedProperties(userId,property);
        return new ResponseEntity<Property>(property,HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="/list/properties/{userId}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserPropertyListResponse> getUserListedProperties(@PathVariable  final String  userId){
        UserPropertyListResponse response;
        if(!userService.isValid(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            response=userService.getPropertyList(userId);
        }catch (UserServiceException exception){
            Logger.getLogger(exception.getMessage(),userId);
            return new ResponseEntity<UserPropertyListResponse>(HttpStatus.CONFLICT);
        }
       return new ResponseEntity<UserPropertyListResponse>(response,HttpStatus.OK);
    }
    @RequestMapping(value="/list/properties/view/shortlisted/{userId}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserPropertyListResponse> getUserInterestedProperties(@PathVariable  final String  userId){
        UserPropertyListResponse response;
        if(!userService.isValid(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            response=userService.getPropertyListofFavorites(userId);
        }catch (UserServiceException exception){
            Logger.getLogger(exception.getMessage(),userId);
            return new ResponseEntity<UserPropertyListResponse>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<UserPropertyListResponse>(response,HttpStatus.OK);
    }

}
