import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.management.enums.ListingType;
import com.property.management.enums.PropertyStatus;
import com.property.management.enums.RoomType;
import com.property.management.model.Address;
import com.property.management.model.Price;
import com.property.management.model.Property;

public class PropertyTest {
    public static void main(String[] args) throws JsonProcessingException {
        Price price = new Price(65000,"INR");
        Address address = new Address("1432","BakerStreet","Bellandur","560999");
        Property property = new Property("12A5","Brigade",address);
        property.setPropertyType(ListingType.RENT);
        property.setroomType(RoomType.DOUBLEBHK);
        property.setPropertyStatus(PropertyStatus.AVAILABLE);
        property.setPrice(price);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(property));

        Price price1 = new Price(7500000,"INR");
        Address address1 = new Address("1532","AlamStreet","Hosur","560998");
        Property property1 = new Property("13A5","Brigade",address);
        property1.setPropertyType(ListingType.SELL);
        property1.setroomType(RoomType.THREEBHK);
        property1.setPropertyStatus(PropertyStatus.SOLD);
        property1.setPrice(price);
        ObjectMapper objectMapper1 = new ObjectMapper();
        System.out.println(objectMapper1.writeValueAsString(property1));

        Price price2 = new Price(9500000,"INR");
        Address address2 = new Address("1832","CareemStreet","Marathahalli","560987");
        Property property2 = new Property("19A6","Brigade",address);
        property2.setPropertyType(ListingType.SELL);
        property2.setroomType(RoomType.THREEBHK);
        property2.setPropertyStatus(PropertyStatus.AVAILABLE);
        property2.setPrice(price);
        ObjectMapper objectMapper2 = new ObjectMapper();
        System.out.println(objectMapper2.writeValueAsString(property2));

    }
}
