package academy.belhard.io;

import academy.belhard.entity.Address;
import academy.belhard.util.AddressUtil;
import academy.belhard.util.DbConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullInfoDbReader {
    private static final String SELECT_ALL = "SELECT p.id, p.first_name, p.last_name, a.city, a.street, a.house_number FROM persons p INNER JOIN addresses a ON p.address_id = a.id;";

    public void readAll() {
        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("p.id");
                String firstName = result.getString("p.first_name");
                String lastName = result.getString("p.last_name");
                String city = result.getString("a.city");
                String street = result.getString("a.street");
                int houseNumber = result.getInt("house_number");

                System.out.println(id + " - " + firstName + " - " + lastName + " - " + city + " - " + street + " - " + houseNumber);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
