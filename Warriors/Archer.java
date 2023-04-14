package Warriors;
public class Archer extends Warrior<Throwing, Shield> {
    public Archer(String name, int hp, Throwing weapon, Shield shield) {
        super(name, hp, weapon, shield);
    }
    
    public int getDistance() {
        return random.nextInt(weapon.getDistance() + 1);
    }

    @Override
    public String toString() {
        return "Archer: " +
        super.toString();
    }

}
