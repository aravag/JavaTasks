package genealogy_seminar_2;
public class Relationship {
    private Person person1;
    private Person person2;
    private RelationshipType relationshipType;

    public Relationship(Person person1, Person person2, RelationshipType relationshipType) {
        this.person1 = person1;
        this.person2 = person2;
        this.relationshipType = relationshipType;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}
