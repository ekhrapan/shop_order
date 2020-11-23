package academy.belhard;

import academy.belhard.entity.Address;
import academy.belhard.io.AddressFileReader;
import academy.belhard.io.AddressesDbReader;
import academy.belhard.io.AddressesDbWriter;

import java.util.List;

import static academy.belhard.io.FilePathConstants.ADDRESSES_SOURCE_FILE;

public class Main {



    public static void main(String[] args) {
//        AddressFileReader reader = new AddressFileReader(ADDRESSES_SOURCE_FILE);
//        List<Address> addresses = reader.readItems();
//
//        AddressesDbWriter writer = new AddressesDbWriter(addresses);
//        writer.saveAll();


        for (Address address : (new AddressesDbReader()).readAll()) {
            System.out.println(address);
        }
    }
}
