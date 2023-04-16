package CompanyHCM;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private boolean running;
    private Employers employers;


    public Menu(Employers employers) {
        this.scanner = new Scanner(System.in);
        this.employers = employers;
        this.running = true;
    }
    public void start() {
        while (running) {
            System.out.println(
                    "Choose: \n1 - Add Person\n2 - Delete Person \n3 - Persons Details \n4 - End of work");
            int operation = scanner.nextInt();
            if (operation == 4) {
                System.out.println("End of work...");
                running = false;
                break;
            }
            String department = "";
            String name = "";
            String age = "";
            String jobTitle = "";
            String phone = "";
            String email = "";

            switch (operation) {
                case 1:

                System.out.println("Choose Department: \n1 - Web Design\n2 - Frontend Development\n3 - Backend Development\n4 - Development");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        department = "Web Design";
                        break;
                    case 2:
                        department = "Frontend Development";
                        break;
                    case 3:
                        department = "Backend Development";
                        break;
                    case 4:
                        department = "Development";
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                System.out.println("Write Person's first name and second name (Example: Ivan Ivanov)");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Write Person's age (just number)");
                int ageInt;
                ageInt = scanner.nextInt();
                scanner.nextLine();
                age = ageInt + " years";
                System.out.println("Write Person's Job Title");
                jobTitle = scanner.nextLine();
                System.out.println("Write Person's phone number starting with +");
                phone = scanner.nextLine();
                System.out.println("Write Person's email");
                email = scanner.nextLine();
                System.out.println("Person successfully added");
                employers.writeFile(new Person(department, name, age, jobTitle, phone, email));
                    break;
                case 2:
                    System.out.println("Write Person's first and second name to delete (Example: Ivan Ivanov)");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    employers.deletePerson(name);
                    break;
                case 3:
                    System.out.println("Write Person's first and second name to show details (Example: Ivan Ivanov)");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.println(employers.readFile(name));
                    break;
                
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
