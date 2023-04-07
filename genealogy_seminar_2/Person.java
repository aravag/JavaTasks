package genealogy_seminar_2;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Person {
    private String id;
    private String name;
    private int age;
    private List<Person> relatives;

    public Person(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.relatives = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addRelative(Person person) {
        RelationshipType relationshipType = this.getRelationshipType(person);
        this.addRelationship(relationshipType, person);
        person.addRelationship(relationshipType, this);
    }
    

    public List<Person> getRelatives(RelationshipType relationshipType) {
        List<Person> result = new ArrayList<>();
        for (Person relative : relatives) {
            if (relative != null && relative.getRelationshipType(this) == relationshipType) {
                result.add(relative);
            }
        }
        return result;
    }

    public abstract RelationshipType getRelationshipType(Person person);

    public void addRelationship(RelationshipType relationshipType, Person person) {
        person.addRelative(this);
        this.addRelative(person);
    }

    public List<Person> getRelativesByType(RelationshipType relationshipType) {
        List<Person> result = new ArrayList<>();
        for (Person relative : relatives) {
            if (relative != null && relative.getRelationshipType(this) == relationshipType) {
                result.add(relative);
            }
        }
        return result;
    }
}
