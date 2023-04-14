package Warriors;
public class Battle {
    private Warrior attacker;
    private Warrior defender;

    public Battle(Warrior attacker, Warrior defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Warrior run() {
        while (true) {
            System.out.println("----------------------------------");
            System.out.println();
            int attack = attacker.harm();
            if (attack != 0) {
                if (defender.isShield()) {
                    defender.reduceShield(attack);
                    System.out.printf("Warrior %s deals damage %d,\nWarrior %s have %d points of shield. His HP is full", attacker.getName(),attack, defender.getName(), defender.getShield());
                } else {
                    defender.reduceHP(attack);
                    System.out.printf("Warrior %s deals damage %d,\nWarrior %s have %d HP", attacker.getName(), attack,defender.getName(), defender.getHP());
                }
            } else {
                System.out.printf("Warrior %s not deals damage,\nWarrior %s have %d HP", attacker.getName(),defender.getName(), defender.getHP());
            }
            if (!defender.isAlive()) {
                System.out.printf("\nWarrior %s is dead, %s is a winner", defender.getName(), attacker.getName());
                System.out.println();
                System.out.println();
                System.out.println("----------------------------------");
                return attacker;
            }
            ;
            System.out.println();
            System.out.println();
            System.out.println("----------------------------------");
            attack = defender.harm();
            if (attack != 0) {
                if (attacker.isShield()) {
                    attacker.reduceShield(attack);
                    System.out.printf("Warrior %s deals damage %d,\nWarrior %s have %d points of shield. His HP is full", defender.getName(), attack, attacker.getName(), attacker.getShield());
                } else {
                    attacker.reduceHP(attack);
                    System.out.printf("Warrior %s deals damage %d,\nWarrior %s have %d HP", defender.getName(), attack, attacker.getName(), attacker.getHP());
                }
            } else {
                System.out.printf("Warrior %s not deals damage,\nWarrior %s have %d HP", defender.getName(), attacker.getName(), attacker.getHP());
            }

            if (!attacker.isAlive()) {
                System.out.printf("\nWarrior %s is dead, %s is a winner", attacker.getName(), defender.getName());
                System.out.println();
                System.out.println();
                System.out.println("----------------------------------");
                return defender;
            }
            ;
            System.out.println();
            System.out.println();
            System.out.println("----------------------------------");
        }
    }
}
