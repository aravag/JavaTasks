package ConsoleAppRebuild;

public class Person {
    private String name;
    private Integer age;
    private String gender;
    public Person(String name, Integer age, String gender) {
        this.name = name;
        this. age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;        
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", gender: " + gender;
    }
}
