package academy.belhard.io;

import academy.belhard.entity.Person;
import academy.belhard.io.api.EntityFileReader;
import academy.belhard.util.PersonUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonFileReader implements EntityFileReader<Person> {
    private final String filepath;

    public PersonFileReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<Person> readItems() {
        List<Person> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Person person = PersonUtil.toObject(line);

                result.add(person);
            }

        } catch (IOException e) {
            System.out.println("Read file error");
        }

        return result;
    }
}
