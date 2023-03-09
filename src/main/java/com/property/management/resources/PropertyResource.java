package com.property.management.resources;

import com.property.management.exception.PropertyServiceException;
import com.property.management.model.Property;
import com.property.management.response.PropertyListResponse;
import com.property.management.response.UserPropertyListResponse;
import com.property.management.response.UserPropertySearchResponse;
import com.property.management.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("v1/property-management-service")
public class PropertyResource {

    private PropertyService propertyService;

public PropertyResource(PropertyService propertyService){
    this.propertyService=propertyService;
}
    @PostMapping(value="/add/properties")
    public ResponseEntity<Property> addProperty(@RequestBody final Property property){
      try{
          propertyService.addProperties(property);
      }catch(PropertyServiceException e){
          Logger.getLogger(e.getMessage(),HttpStatus.CONFLICT.toString());
      }
        return new ResponseEntity<Property>(property,HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="get/properties/{propertyIds}", method=RequestMethod.GET)
    public ResponseEntity<PropertyListResponse> listProperty(@PathVariable final String propertyids){
    PropertyListResponse response= propertyService.getProperties(propertyids);
    return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @RequestMapping(value="/list/properties/search")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<PropertyListResponse> getUserListedProperties(@RequestBody final Property property){
       PropertyListResponse response= propertyService.filterproperties(property);
       return  new ResponseEntity<>(response,HttpStatus.OK);
    }
}
