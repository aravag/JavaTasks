package genealogy_seminar_2;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Parent("John", 50);
        Person person2 = new Parent("Mary", 45);
        Person person3 = new Child("Peter", 20);
        Person person4 = new Child("Sarah", 18);
        Person person5 = new Sibling("Tom", 25);
        Person person6 = new Sibling("Linda", 23);
        MyGenealogyTree myTree = new MyGenealogyTree(person1);
        myTree.addRelative(person2, RelationshipType.SPOUSE);
        myTree.addRelative(person3, RelationshipType.CHILD);
        myTree.addRelative(person4, RelationshipType.CHILD);
        myTree.addRelative(person5, RelationshipType.SIBLING);
        myTree.addRelative(person6, RelationshipType.SIBLING);

        List<Person> relatives = myTree.getRelatives(person3, RelationshipType.PARENT);

        System.out.println("Список всех родителей: ");
        for (Person relative : relatives) {
            System.out.println(relative.getName());
        }

        List<Person> children = myTree.getRelatives(person1, RelationshipType.CHILD);

        System.out.println("Список детей: ");
        for (Person child : children) {
            System.out.println(child.getName());
        }

        List<Person> siblings = myTree.getRelatives(person5, RelationshipType.SIBLING);

        System.out.println("Список братьев и сестер: ");
        for (Person sibling : siblings) {
            System.out.println(sibling.getName());
        }
    }
}