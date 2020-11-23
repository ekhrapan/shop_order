package academy.belhard.io;

import academy.belhard.entity.Address;
import academy.belhard.util.AddressUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressFileReader {
    private final String filepath;

    public AddressFileReader(String filepath) {
        this.filepath = filepath;
    }

    public List<Address> readItems() {
        List<Address> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Address address = AddressUtil.toObject(line);

                result.add(address);
            }

        } catch (IOException e) {
            System.out.println("Read file error");
        }

        return result;
    }
}
