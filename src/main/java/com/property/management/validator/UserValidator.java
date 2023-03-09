package com.property.management.validator;

import com.property.management.model.User;

public class UserValidator implements Validator {
    public  boolean isValid(User user){
        if(user.getId()==null ||user.getPhoneNumber()==null){
            return false;
        }
        return true;
    }

    public boolean isValid(String userId) {
        if(userId==null) return false;
        return true;
    }
}
