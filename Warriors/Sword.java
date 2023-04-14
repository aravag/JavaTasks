package Warriors;
public class Sword implements Weapon {

    @Override
    public int damage() {
        return 5;
    }

    @Override
    public String toString() {
        return "Sword: " + 
        "\ndamage: " + damage();
    }
    
}
