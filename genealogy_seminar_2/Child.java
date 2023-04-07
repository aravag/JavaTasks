package genealogy_seminar_2;
public class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public RelationshipType getRelationshipType(Person person) {
        if (person instanceof Parent) {
            return RelationshipType.PARENT;
        } else {
            return RelationshipType.NONE;
        }
    }
}
