package academy.belhard;

import academy.belhard.entity.Person;
import academy.belhard.io.*;
import academy.belhard.io.api.EntityFileReader;

import java.util.List;

import static academy.belhard.io.FilePathConstants.PERSONS_SOURCE_FILE;

public class Main {



    public static void main(String[] args) {
//        AddressFileReader reader = new AddressFileReader(ADDRESSES_SOURCE_FILE);
//        List<Address> addresses = reader.readItems();
//
//        AddressesDbWriter writer = new AddressesDbWriter(addresses);
//        writer.saveAll();


//        for (Address address : (new AddressesDbReader()).readAll()) {
//            System.out.println(address);
//        }

        EntityFileReader<Person> fileReader = new PersonFileReader(PERSONS_SOURCE_FILE);
        List<Person> persons = fileReader.readItems();

        PersonsDbWriter personsDbWriter = new PersonsDbWriter(persons);
        personsDbWriter.saveAll();
    }
}
