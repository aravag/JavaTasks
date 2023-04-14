package Warriors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team<Type extends Warrior> implements Iterable<Type> {

    List<Type> persons = new ArrayList<>();

    public Team<Type> addPerson(Type person) {
        persons.add(person);
        return this;
    }

    public int maxDistance() {
        int max = 0;
        for (Type person : this) {
            if (person instanceof Archer) {
                Archer archer = (Archer) person;
                if(archer.getDistance() > max) {
                    max = archer.getDistance();
                }
            }
        }
        return max;
    }

    public List<Type> getTeam() {
        return persons;
    }
    
    public Shield getMinShield() {
        Shield minShield = null;
        for (Type person : this) {
            if (person instanceof Warrior) {
                Warrior<?, Shield> warrior = (Warrior<?, Shield>) person;
                if (minShield == null || warrior.shield.getSP() < minShield.getSP()) {
                    minShield = warrior.shield;
                }
            }
        }
        return minShield;
    }
    
    @Override
    public Iterator<Type> iterator() {
        return persons.iterator();
    }

    @Override
    public String toString() {
        return "Team: " + persons;
    }
    
}
