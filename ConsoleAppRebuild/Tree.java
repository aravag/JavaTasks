package ConsoleAppRebuild;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Tree {
    public static Person findPersonByName(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                String personName = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];
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

    public static void addRelative(String personName, String relativeName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            boolean foundPerson = false;
            while (line != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                if (name.equalsIgnoreCase(personName)) {
                    foundPerson = true;
                    String relatives = tokens.length > 3 ? tokens[3] : "";
                    if (relatives.isEmpty()) {
                        relatives = relativeName;
                    } else {
                        relatives += "," + relativeName;
                    }
                    line = name + "," + tokens[1] + "," + tokens[2] + "," + relatives;
                }
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
            reader.close();
    
            if (!foundPerson) {
                System.out.println("----------------------------");
                System.out.println("Person not found");
                System.out.println("----------------------------");
                return;
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("People.txt"));
            writer.write(sb.toString());
            writer.close();
            System.out.println("----------------------------");
            System.out.println("Added successfully!");
            System.out.println("----------------------------");
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(Person person) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("People.txt", true));
            writer.write(person.getName() + "," + person.getAge() + "," + person.getGender() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(String name) {
        try {
            File inputFile = new File("People.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            boolean found = false;
            while ((currentLine = reader.readLine()) != null) {
                String[] personData = currentLine.split(",");
                if (!personData[0].equals(name)) {
                    writer.write(currentLine + "\n");
                } else {
                    found = true;
                }
            }
            writer.close();
            reader.close();
            if (!found) {
                System.out.println("----------------------------");
                System.out.println("Person " + name + " not found in a tree..");
                System.out.println("----------------------------");
            } else {
                if (!inputFile.delete()) {
                    System.out.println("Error.");
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Error.");
                    return;
                }
                System.out.println("----------------------------");
                System.out.println("Person " + name + " successfully deleted from the tree!");
                System.out.println("----------------------------");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void findRelative(String personName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
            String line = reader.readLine();
            boolean foundPerson = false;
            while (line != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                if (name.equalsIgnoreCase(personName)) {
                    foundPerson = true;
                    if (tokens.length > 3) {
                        String[] relatives = Arrays.copyOfRange(tokens, 3, tokens.length);
                        System.out.println("----------------------------");
                        System.out.println("Relatives of " + personName + ": " + String.join(", ", relatives));
                        System.out.println("----------------------------");
                    } else {
                        System.out.println(personName + " has no relatives.");
                    }
                }
                line = reader.readLine();
            }
            reader.close();
    
            if (!foundPerson) {
                System.out.println("----------------------------");
                System.out.println("Person not found");
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
