import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.management.model.Address;
import com.property.management.model.User;

public class UserTest {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User("jack@gmail.com","jack","999999987",
                new Address("111, xyz apartment","baker street","bellandur","560099"));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));

        User user1 = new User("mike@gmail.com","mike","777999987",
                new Address("113, plazza apartment","Alam street","Hosur","560097"));
        ObjectMapper objectMapper1 = new ObjectMapper();
        System.out.println(objectMapper1.writeValueAsString(user1));

        User user2 = new User("black@gmail.com","black","99977766",
                new Address("119, plz apartment","careem street","marathahalli","560090"));
        ObjectMapper objectMapper2 = new ObjectMapper();
        System.out.println(objectMapper2.writeValueAsString(user2));
    }
/*
curl --location --request POST 'https://localhost:8081/v1/property-management-service/register/user' \
--data-raw ' {"id":"jack@gmail.com","name":"jack","address":{"housenumber":"111, xyz apartment","location":"bellandur","pincode":"560099","street":"baker street"},"phoneNumber":"999999987"}'
{"id":"jack@gmail.com","name":"jack","address":{"housenumber":"111, xyz apartment","location":"bellandur","pincode":"560099","street":"baker street"},"phoneNumber":"999999987"}
 */
}
