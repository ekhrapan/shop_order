package academy.belhard.io;

import academy.belhard.entity.Address;
import academy.belhard.entity.Person;
import academy.belhard.util.DbConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressesDbReader {
    private static final String SELECT_ALL = "SELECT * FROM addresses";

    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String city = result.getString("city");
                String street = result.getString("street");
                int houseNumber = result.getInt("house_number");

                Address address = new Address(id, city, street, houseNumber);

                res.add(address);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
}
