package finalTask;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String occupation;
    
    public Person(String firstName, String lastName, int age, char gender, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }
    public void setAge(int age) {
        this.age = age;
    }    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    public String getOccupation() {
        return occupation;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + ", возраст " + age + ", " + gender + ", " + occupation;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && age == other.age
                && gender == other.gender
                && Objects.equals(occupation, other.occupation);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender, occupation);
    }
    public static void happyBirthday(Person person) {
        System.out.println("С днем Рождения, " + person.getFirstName() + "!");
        person.setAge(person.getAge() + 1);
    }
    
}