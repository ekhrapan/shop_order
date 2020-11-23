package academy.belhard;

import academy.belhard.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonConnector {

    private Connection connection;

    private static final String ADD = "INSERT INTO persons (first_name, last_name, email, age, city) VALUES(?, ?, ?, ?, ?)";
    private static final String REQUEST = "SELECT * FROM persons";

    public PersonConnector(Connection connection) {
        this.connection = connection;
    }

//    public List<Person> readAll() {
//        List<Person> res = new ArrayList<>();
//
//        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {
//
//            ResultSet result = statement.executeQuery();
//
//            while (result.next()) {
//                int id = result.getInt("id");
//                String firstName = result.getString("first_name");
//                String lastName = result.getString("last_name");
//                String email = result.getString("email");
//                String city = result.getString("city");
//                int age = result.getInt("age");
//
//                Person p = new Person(id, firstName, lastName, email, age, city);
//
//                res.add(p);
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return res;
//    }
//
//    public void add(Person person) {
//        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
//            statement.setString(1, person.getFirstName());
//            statement.setString(2, person.getLastName());
//            statement.setString(3, person.getEmail());
//            statement.setInt(4, person.getAge());
//            statement.setString(5, person.getCity());
//
//            int res = statement.executeUpdate();
//
//            System.out.println(res);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
