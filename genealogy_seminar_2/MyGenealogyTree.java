package genealogy_seminar_2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGenealogyTree implements GenealogyTree {
    private Map<String, Person> people;

    public MyGenealogyTree(Person person) {
        people = new HashMap<>();
        people.put(person.getId(), person);
    }

    public void addRelative(Person person, RelationshipType relationshipType) {
        if (people.containsKey(person.getId())) {
            Person existingPerson = people.get(person.getId());
            existingPerson.addRelative(person);
            existingPerson.addRelationship(relationshipType, person);
            person.addRelative(existingPerson);
            person.addRelationship(relationshipType, existingPerson);
            people.put(person.getId(), person);
        } else {
            addPerson(person);
        }
    }

    @Override
    public void addPerson(Person person) {
        people.put(person.getId(), person);
    }

    @Override
    public List<Person> getRelatives(Person person, RelationshipType relationshipType) {
        return person.getRelativesByType(relationshipType);
    }

    @Override
    public Person getPerson(String id) {
        return people.get(id);
    }
}
