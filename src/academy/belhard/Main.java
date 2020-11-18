package academy.belhard;

import java.sql.*;

public class Main {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PersonConnector connector = new PersonConnector(connection);

        for (Person p : connector.readAll()) {
            System.out.println(p);
        }

        Person person = new Person(100, "Name", "Last name", "sadfa@mail", 47, "Varshava");
        connector.add(person);

        System.out.println();

        for (Person p : connector.readAll()) {
            System.out.println(p);
        }

    }
}
