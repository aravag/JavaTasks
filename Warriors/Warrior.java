package Warriors;
import java.util.Random;

public class Warrior<TypeWeapon extends Weapon, TypeShield extends Shield> extends Person {
    protected TypeWeapon weapon;
    protected TypeShield shield;
    protected static Random random = new Random();

    public Warrior(String name, int hp, TypeWeapon weapon, TypeShield shield) {
        super(name, hp);
        this.weapon = weapon;
        if (shield != null) {
            this.shield = shield;
        } else {
            this.shield = (TypeShield) new NoShield();
        }
    }

    public int harm() {
        boolean isHit = random.nextBoolean();
        int damageCount = 0;
        if (isHit) {
            damageCount = random.nextInt(weapon.damage() + 1);
        }
        return damageCount;
    }

    public int getShield() {
        return shield.getSP();
    }

    public void setShield(TypeShield shield) {
        if (shield != null) {
            this.shield = shield;
        } else {
            this.shield = (TypeShield) new NoShield();
        }
    }

    public boolean isShield() {
        return shield.getSP() > 0;
    }

    public void reduceShield(int attack) {
        shield.reduceShield(attack);
    }

    @Override
    public String toString() {
        return "Warrior: " + "\nname: " + getName() +
                "\nhp: " + getHP() +
                "\nweapon: " + weapon +
                "\nshield: " + shield;
    }

}