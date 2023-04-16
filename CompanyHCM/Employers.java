package CompanyHCM;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Employers {

    private FileWriter fileWriter;

    public Employers(String filePath) {
        try {
            fileWriter = new FileWriter(filePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Person person) {
        try {
            fileWriter.write(person.getDepartment() + "," + 
            person.getName() + "," + 
            person.getAge() + "," +
            person.getJobTitle() + "," + 
            person.getPhone() + "," + 
            person.getEmail() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person readFile(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader("db.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String personName = parts[1];
                if (personName.equals(name)) {
                    String department = parts[0];
                    String age = parts[2];
                    String jobTitle = parts[3];
                    String phone = parts[4];
                    String email = parts[5];
                    return new Person(department, name, age, jobTitle, phone, email);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No person with this name");
        return null; 
    }

    public void deletePerson(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader("db.txt"))) {
            String line;
            StringBuilder sb = new StringBuilder();
            boolean personFound = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String personName = parts[1];
                if (personName.equals(name)) {
                    personFound = true;
                } else {
                    sb.append(line).append("\n");
                }
            }
            if (personFound) {
                try (FileWriter fw = new FileWriter("db.txt")) {
                    fw.write(sb.toString());
                    fw.flush();
                }
                System.out.println("Person with name " + name + " deleted from the file");
            } else {
                System.out.println("No person with name " + name + " found in the file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
