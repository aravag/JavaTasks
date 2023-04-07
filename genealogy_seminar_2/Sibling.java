package genealogy_seminar_2;
public class Sibling extends Person {
    public Sibling(String name, int age) {
        super(name, age);
    }

    @Override
    public RelationshipType getRelationshipType(Person person) {
        if (person instanceof Child) {
            return RelationshipType.SIBLING;
        }
        return RelationshipType.NONE;
    }
}