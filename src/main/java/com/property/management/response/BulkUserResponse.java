package com.property.management.response;

import com.property.management.model.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(builderMethodName = "internalBuilder")
public class BulkUserResponse {
    List<User> users;
}
