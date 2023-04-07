package GenealogyConsoleApp;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private Integer age;
    private String gender;
    private Map<RelationshipType, Person> relatives;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.relatives = new HashMap<>();
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
    
    public Person getRelative(RelationshipType relationshipType) {
        if (this.relatives.containsKey(relationshipType)) {
            return this.relatives.get(relationshipType);
        }
        return null;
    }
    

    public void addRelative(Person relative, RelationshipType relationshipType) {
        if (relatives.containsKey(relationshipType) && relatives.get(relationshipType).equals(relative)) {
            return;
        }
        relatives.put(relationshipType, relative);
        if (relationshipType == RelationshipType.PARENT) {
            relative.addRelative(this, RelationshipType.CHILD);
        } else if (relationshipType == RelationshipType.CHILD) {
            relative.addRelative(this, RelationshipType.PARENT);
        } else if (relationshipType == RelationshipType.SIBLING) {
            for (Person sibling : relatives.values()) {
                if (!sibling.equals(relative)) {
                    sibling.addRelative(relative, RelationshipType.SIBLING);
                    relative.addRelative(sibling, RelationshipType.SIBLING);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                '}';
    }
}
