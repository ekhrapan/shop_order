package academy.belhard.io;

import academy.belhard.entity.Address;
import academy.belhard.io.api.EntityDbWriter;
import academy.belhard.util.DbConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddressesDbWriter implements EntityDbWriter {
    private List<Address> addresses;

    private static final String ADD = "INSERT INTO addresses (id, city, street, house_number) VALUES(?, ?, ?, ?)";

    public AddressesDbWriter(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public void saveAll() {
        for (Address address : addresses) {
            save(address);
        }
    }

    private void save(Address address) {
        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouseNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
