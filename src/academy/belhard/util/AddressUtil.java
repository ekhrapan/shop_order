package academy.belhard.util;

import academy.belhard.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUtil {

    public static Address toObject(String line) {
        String[] addressesArgs = line.split(";");

        int id = Integer.parseInt(addressesArgs[0]);
        String city = addressesArgs[1];
        String street = addressesArgs[2];
        int houseNumber = Integer.parseInt(addressesArgs[3]);

        return new Address(id, city, street, houseNumber);
    }

    public static Address toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int houseNumber = resultSet.getInt("house_number");

        return new Address(id, city, street, houseNumber);
    }
}
