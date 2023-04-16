package PhoneBook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private static PhoneBook instance;
    private List<Contact> contacts;
    private File file;

    private PhoneBook() {
        contacts = new ArrayList<>();
        file = new File("contacts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла справочника.");
            }
        } else {
            loadContactsFromFile();
        }
    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContactsToFile();
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        saveContactsToFile();
    }

    public List<Contact> findContact(String name) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(name) || contact.getLastName().equals(name)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }

    private void loadContactsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] contactData = line.split(",");
                Contact contact = new Contact(contactData[0], contactData[1], contactData[2], contactData[3]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла справочника.");
        }
    }

    private void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contact contact : contacts) {
                writer.write(contact.getFirstName() + "," + contact.getLastName() + ","
                        + contact.getPhoneNumber() + "," + contact.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл справочника.");
        }
    }

    public static void setInstance(PhoneBook instance) {
        PhoneBook.instance = instance;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}