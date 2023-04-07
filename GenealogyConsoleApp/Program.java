package GenealogyConsoleApp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    startProgram();
}

private static void startProgram() {
    while (true) {
        System.out.println("\n--Family Tree Console App--");
        System.out.println("1. Add Person");
        System.out.println("2. Display Person Details");
        System.out.println("3. Find Relatives");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addPerson();
                break;
            case 2:
                displayPerson();
                break;
            case 3:
                findRelatives();
                break;
            case 4:
                exitProgram();
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
}

private static void addPerson() {
    System.out.println("\n--Add a New Person--");
    System.out.println("Enter the name of the person:");
    scanner.nextLine();
    String name = scanner.nextLine();
    System.out.println("Enter the age of the person:");
    int age = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter the gender of the person:");
    String gender = scanner.nextLine();
    System.out.println("Does this person have any relatives? (y/n)");
    String answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")) {
        System.out.println("Enter the name of the relative:");
        String relativeName = scanner.nextLine();
        System.out.println("What is the relationship to the relative? (parent/child/sibling)");
        String relation = scanner.nextLine();
        RelationshipType relationshipType = RelationshipType.valueOf(relation.toUpperCase());
        Person person = GenealogyTree.findPersonByName(name);
        if (person == null) {
            System.out.println("Person not found!");
            GenealogyTree.addPerson(new Person(name, age, gender));
            System.out.println("Person added successfully!");
            return;
        }
        Person relative = new Person(relativeName, 0, "");
        person.addRelative(relative, relationshipType);
        GenealogyTree.addPerson(relative);
    } else {
        GenealogyTree.addPerson(new Person(name, age, gender));
    }
    System.out.println("Person added successfully!");
}

private static void displayPerson() {
    System.out.println("\n--Display Person Details--");
    System.out.println("Enter the name of the person to display:");
    scanner.nextLine();
    String name = scanner.nextLine();
    Person person = GenealogyTree.findPersonByName(name);
    if (person == null) {
        System.out.println("Person not found!");
        return;
    }
    System.out.println(person);
}

private static void findRelatives() {
    System.out.println("\n--Find Relatives--");
    System.out.println("Enter the name of the person to find relatives for:");
    scanner.nextLine();
    String name = scanner.nextLine();
    Person person = GenealogyTree.findPersonByName(name);
    if (person == null) {
        System.out.println("Person not found!");
        return;
    }
    System.out.println("Relatives of " + name + ":");
    for (RelationshipType relationshipType : RelationshipType.values()) {
        Person relative = person.getRelative(relationshipType);
        if (relative != null) {
            System.out.println(relationshipType.toString().toLowerCase() + ": " + relative.getName());
        }
    }
}

public static void addRelative(String name, String relativeName, RelationshipType relationshipType) {
    Person person = GenealogyTree.findPersonByName(name);
    if (person == null) {
        System.out.println("Person not found!");
        return;
    }

    Person relative = GenealogyTree.findPersonByName(relativeName);
    if (relative == null) {
        GenealogyTree.addPerson(new Person(relativeName, 0, ""));
    }

    person.addRelative(relative, relationshipType);
    try {
        FileWriter fw = new FileWriter("People.txt", true);
        fw.write(person.getName() + "," + person.getAge() + "," + person.getGender() + "," + relationshipType.toString() + "," + relative.getName() + "\n");
        fw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void exitProgram() {
    System.out.println("\nExiting Program...");
    System.exit(0);
}
}