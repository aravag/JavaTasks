package Warriors;
public class Bow extends Throwing{
    private String name;

    public Bow(int distance) {
        super(distance);
        this.name = "Bow";
    }

    @Override
    public int damage() {
        return 5 * 2;
    }

    public String toString() {
        return "Bow: " + "\nname: " + name + 
        super.toString();
    }
    
}
