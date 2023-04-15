package ComplexRationalCalculator;

public class Main {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger("log.txt");
        Menu menu = new Menu(logger);
        menu.start();
    }
}