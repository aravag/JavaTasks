package genealogy_seminar_2;
import java.util.List;

public interface GenealogyTree {
    void addPerson(Person person);

    Person getPerson(String name);

    List<Person> getRelatives(Person person, RelationshipType relationshipType);
}