package com.property.management.response;

import com.property.management.model.Property;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(builderMethodName = "internalBuilder")
public class PropertyListResponse {
   Property property;
}
