package ComplexRationalCalculator;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(String filePath) {
        super(filePath);
    }

    @Override
    public void log(String message) {
        super.log(message);
        System.out.print(message);
    }
}
