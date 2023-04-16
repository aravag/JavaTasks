package PhoneBook;
// import java.io.IOException;
// import java.util.List;

// public class Main {
//     public static void main(String[] args) {
//         PhoneBook phoneBook = PhoneBook.getInstance();
//         phoneBook.addContact(new Contact("Ivan", "Ivanov", "+7-123-456-7890", "ivan.ivanov@example.com"));
//         phoneBook.addContact(new Contact("Maria", "Ivanova", "+7-234-567-8901", "maria.ivanova@example.com"));
//         phoneBook.addContact(new Contact("Boris", "Andreev", "+7-345-678-9012", "boris.anfreev@example.com"));

//         // Экспорт контактов в файл contacts.txt в формате
//         try {
//             ContactFileFormat.exportContacts(phoneBook.getContacts(), "contacts.txt");
//             System.out.println("Контакты успешно экспортированы в файл contacts.txt");
//         } catch (IOException e) {
//             System.err.println("Ошибка при экспорте контактов: " + e.getMessage());
//         }

//         // Импорт контактов из файла contacts.txt в формате
//         try {
//             List<Contact> importedContacts = ContactFileFormat.importContacts("contacts.txt");
//             phoneBook.getContacts().addAll(importedContacts);
//             System.out.println("Контакты успешно импортированы из файла contacts.txt");
//         } catch (IOException e) {
//             System.err.println("Ошибка при импорте контактов: " + e.getMessage());
//         }
//     }

// }

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = PhoneBook.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить человека в справочник(файл)");
            System.out.println("2. Удалить человека из справочника(файл)");
            System.out.println("3. Вывести информацию о человеке в консоль");
            System.out.println("4. Экспортировать справочник");
            System.out.println("5. Импортировать справочник");
            System.out.println("0. Выйти из программы");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("До свидания!");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Введите данные нового контакта:");
                    System.out.print("Имя: ");
                    String firstName = scanner.next();
                    System.out.print("Фамилия: ");
                    String lastName = scanner.next();
                    System.out.print("Телефон: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
                    phoneBook.addContact(newContact);
                    System.out.println("Контакт добавлен в справочник");
                    break;
                case 2:
                    System.out.println("Введите данные контакта, который нужно удалить:");
                    System.out.print("Имя: ");
                    String firstNameToDelete = scanner.next();
                    System.out.print("Фамилия: ");
                    String lastNameToDelete = scanner.next();
                    for (Contact contact : phoneBook.getContacts()) {
                        if (contact.getFirstName().equals(firstNameToDelete)
                                && contact.getLastName().equals(lastNameToDelete)) {
                            phoneBook.removeContact(contact);
                            System.out.println("Контакт удален из справочника");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите данные контакта, информацию о котором нужно вывести:");
                    System.out.print("Имя: ");
                    String firstNameToPrint = scanner.next();
                    System.out.print("Фамилия: ");
                    String lastNameToPrint = scanner.next();
                    for (Contact contact : phoneBook.getContacts()) {
                        if (contact.getFirstName().equals(firstNameToPrint)
                                && contact.getLastName().equals(lastNameToPrint)) {
                            System.out.println("Имя: " + contact.getFirstName());
                            System.out.println("Фамилия: " + contact.getLastName());
                            System.out.println("Телефон: " + contact.getPhoneNumber());
                            System.out.println("Email: " + contact.getEmail());
                            break;
                        } else {
                            System.out.println("Контакт не найден");
                        }
                    }
                    break;
                case 4:
                    try {
                        ContactFileFormat.exportContacts(phoneBook.getContacts(), "contacts_exported.txt");
                        System.out.println("Контакты успешно экспортированы в файл contacts_exported.txt");
                    } catch (IOException e) {
                        System.err.println("Ошибка при экспорте контактов: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Введите название файла с расширением");
                    scanner.nextLine();
                    String fileName = scanner.nextLine();
                    try {
                        List<Contact> importedContacts = ContactFileFormat.importContacts(fileName);
                        phoneBook.getContacts().addAll(importedContacts);
                        System.out.println("Контакты успешно импортированы из файла " + fileName);
                    } catch (IOException e) {
                        System.err.println("Ошибка при импорте контактов: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        } while (choice != 0);
    }
}