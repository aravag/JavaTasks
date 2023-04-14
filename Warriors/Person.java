package Warriors;
public abstract class Person {
    private String name;
    private int hp;

    public Person (String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }
    public boolean isAlive() {
        return hp > 0;
    }

    public void reduceHP(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
}
