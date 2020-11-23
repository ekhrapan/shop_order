package academy.belhard.util;

import academy.belhard.entity.Address;

public class AddressUtil {

    public static Address toObject(String line) {
        String[] addressesArgs = line.split(";");

        int id = Integer.parseInt(addressesArgs[0]);
        String city = addressesArgs[1];
        String street = addressesArgs[2];
        int houseNumber = Integer.parseInt(addressesArgs[3]);

        return new Address(id, city, street, houseNumber);
    }
}
