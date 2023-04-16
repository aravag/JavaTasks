package PhoneBook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFileFormat {
    private static final String delimiter = ",";

    public static void exportContacts(List<Contact> contacts, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Contact contact : contacts) {
            writer.write(contact.getFirstName() + delimiter);
            writer.write(contact.getLastName() + delimiter);
            writer.write(contact.getPhoneNumber() + delimiter);
            writer.write(contact.getEmail() + "\n");
        }
        writer.close();
    }

    public static List<Contact> importContacts(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Contact> contacts = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(delimiter);
            if (parts.length == 4) {
                contacts.add(new Contact(parts[0], parts[1], parts[2], parts[3]));
            }
        }
        reader.close();
        return contacts;
    }
}
