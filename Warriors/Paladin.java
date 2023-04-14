package Warriors;
public class Paladin extends Warrior<Sword, Shield> {

    public Paladin(String name, int hp, Sword weapon, Shield shield) {
        super(name, hp, weapon, shield);
    }

    @Override
    public String toString() {
        return "Paladin: " + 
        super.toString();
    }
    
}
