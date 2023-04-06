package GenealogyConsoleApp;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenealogyTree {
private static List<Person> people = new ArrayList<Person>();
public static Person findPersonByName(String name) {
    if (people == null) {
        return null;
    }
    try {
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] tokens = line.split(",");
            String personName = tokens[0];
            String gender = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            if (personName.equalsIgnoreCase(name)) {
                reader.close();
                return new Person(personName, age, gender);
            }
            line = reader.readLine();
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}


public static void addPerson(Person person) {
    if (people == null) {
        people = new ArrayList<>();
    }
    people.add(person);
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("People.txt", true));
        writer.write(person.getName() + "," + person.getGender() + "," + person.getAge() + "\n");
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}