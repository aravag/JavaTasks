package ConsoleAppRebuild;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.print("----------------------------");
            System.out.println("\n--Family Tree Console App--");
            System.out.println("----------------------------");
            System.out.println("1. Add Person");
            System.out.println("2. Delete Person");
            System.out.println("3. Display Person Details");
            System.out.println("4. Add Relatives");
            System.out.println("5. Find Relatives");
            System.out.println("6. Exit");
            System.out.println("----------------------------");
            System.out.println("Enter your choice:");
            System.out.println("----------------------------");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    deletePerson();
                    break;
                case 3:
                    displayPerson();
                    break;
                case 4:
                    addRelative();
                    break;
                case 5:
                    findRelative();
                    break;
                case 6:
                    exitProgram();
                    break;
            
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Would you like to continue?");
            System.out.println("----------------------------");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("----------------------------");
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    break;

                case 2:
                    exitProgram();
                    break;
            
                default:
                System.out.println("----------------------------");
                    System.out.println("Invalid choice");
                    System.out.println("----------------------------");
                    break;
            }
            
        }
    }

    private static void addPerson() {
        System.out.print("----------------------------");
        System.out.println("\n--Add a New Person--");
        System.out.println("----------------------------");
        System.out.println("Enter the name of the person:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("----------------------------");
        System.out.println("Enter the age of the person:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("----------------------------");
        System.out.println("Enter the gender of the person:");
        String gender = scanner.nextLine();
        Person person = new Person(name, age, gender);
        System.out.println("----------------------------");
        System.out.println("Does this person have any relatives?");
        System.out.println("----------------------------");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("----------------------------");
        int yesOrNo = scanner.nextInt();
        switch (yesOrNo) {
            case 1:
                Tree.writeFile(person);
                addRelative();
                break;

            case 2:
                Tree.writeFile(person);
                System.out.println("----------------------------");
                System.out.println("Person added successfully!");
                System.out.println("----------------------------");
                break;
        
            default:
            System.out.println("----------------------------");
            System.out.println("Invalid choice");
            System.out.println("----------------------------");
                break;
        }

    }

    private static void deletePerson() {
        System.out.print("----------------------------");
        System.out.println("\n--Delete a Person--");
        System.out.println("----------------------------");
        System.out.println("Enter the name of the person:");
        System.out.println("----------------------------");
        scanner.nextLine();
        String name = scanner.nextLine();
        Tree.deletePerson(name);
    }

    private static void displayPerson() {
        System.out.print("----------------------------");
        System.out.println("\n--Display a Person--");
        System.out.println("----------------------------");
        System.out.println("Enter the name of the person:");
        System.out.println("----------------------------");
        scanner.nextLine();
        String name = scanner.nextLine();
        Person person = Tree.findPersonByName(name);
        if (person == null) {
            System.out.println("----------------------------");
            System.out.println("Person not found!");
            System.out.println("----------------------------");
            return;
        }
        System.out.println("----------------------------");
        System.out.println(person);
        System.out.println("----------------------------");
    }

    private static void addRelative() {
        System.out.print("----------------------------");
        System.out.println("\n--Add Relative--");
        System.out.println("----------------------------");
        System.out.println("Enter the name of the person:");
        System.out.println("----------------------------");
        scanner.nextLine();
        String personName = scanner.nextLine();
        System.out.println("----------------------------");
        System.out.println("Enter the name of a relative:");
        System.out.println("----------------------------");
        String relativeName = scanner.nextLine();
        Tree.addRelative(personName, relativeName);
    }


    private static void findRelative() {
        System.out.print("----------------------------");
        System.out.println("\n--Find Relative--");
        System.out.println("----------------------------");
        System.out.println("Enter the name of the person:");
        System.out.println("----------------------------");
        scanner.nextLine();
        String personName = scanner.nextLine();
        Tree.findRelative(personName);
    }

    private static void exitProgram() {
        System.out.print("----------------------------");
        System.out.println("\nExiting Program...");
        System.out.println("----------------------------");
        System.exit(0);
    }

    
}
