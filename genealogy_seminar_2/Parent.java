package genealogy_seminar_2;
public class Parent extends Person {
    public Parent(String name, int age) {
        super(name, age);
    }

    @Override
    public RelationshipType getRelationshipType(Person person) {
        if (person instanceof Child) {
            return RelationshipType.CHILD;
        } else {
            return RelationshipType.NONE;
        }
    }
}
