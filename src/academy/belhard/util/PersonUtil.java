package academy.belhard.util;

import academy.belhard.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonUtil {

    public static Person toObject(String line) {
        String[] addressesArgs = line.split(";");

        String firstName = addressesArgs[0];
        String lastName = addressesArgs[1];
        String email = addressesArgs[2];
        int age = Integer.parseInt(addressesArgs[3]);
        int addressId = Integer.parseInt(addressesArgs[4]);

        return new Person(firstName, lastName, email, age, addressId);
    }

    public static Person toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        int age = resultSet.getInt("age");
        int addressId = resultSet.getInt("address_id");

        return new Person(id, firstName, lastName, email, age, addressId);
    }
}
