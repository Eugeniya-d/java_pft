package ru.stqa.pft.addressbook.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GeneratorContactDataJson {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);
        saveAsJson(contacts, file);
    }

    private static void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }



    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withName(String.format("Ivan"))
                    .withSurname(String.format("Ivanov%s", i))
                    .withMobilePhone(String.format("+7999999999%s", i)).withEmail(String.format("%s7999999999@mail.ru", i)));
        }
        return contacts;
    }
}

