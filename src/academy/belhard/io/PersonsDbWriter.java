package academy.belhard.io;

import academy.belhard.entity.Person;
import academy.belhard.io.api.EntityDbWriter;
import academy.belhard.util.DbConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonsDbWriter implements EntityDbWriter {
    private List<Person> persons;

    private static final String ADD = "INSERT INTO persons (first_name, last_name, email, age, address_id) VALUES(?, ?, ?, ?, ?)";

    public PersonsDbWriter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void saveAll() {
        for (Person person : persons) {
            save(person);
        }
    }

    private void save(Person person) {
        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getAge());
            statement.setInt(5, person.getAddressId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
