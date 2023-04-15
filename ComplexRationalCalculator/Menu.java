package ComplexRationalCalculator;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Logger logger;
    private boolean running;

    public Menu(Logger logger) {
        this.scanner = new Scanner(System.in);
        this.logger = logger;
        this.running = true;
    }

    public void start() {
        while (running) {
            System.out.println("Выберите тип данных: 1 - комплексные числа, 2 - рациональные числа");
            int dataType = scanner.nextInt();
            Calculator calculator;
            if (dataType == 1) {
                calculator = new Calculator(logger);
            } else {
                calculator = new Calculator(logger);
            }

            System.out.println("Выберите операцию: 1 - сложение, 2 - вычитание, 3 - умножение, 4 - деление");
            int operation = scanner.nextInt();
            double num1Real, num1Imaginary, num2Real, num2Imaginary;
            int num1Numerator, num1Denominator, num2Numerator, num2Denominator;

            if (dataType == 1) {
                System.out.println("Введите действительную и мнимую части первого числа:");
                num1Real = scanner.nextDouble();
                num1Imaginary = scanner.nextDouble();
                System.out.println("Введите действительную и мнимую части второго числа:");
                num2Real = scanner.nextDouble();
                num2Imaginary = scanner.nextDouble();
            } else {
                System.out.println("Введите числитель и знаменатель первого числа:");
                num1Numerator = scanner.nextInt();
                num1Denominator = scanner.nextInt();
                System.out.println("Введите числитель и знаменатель второго числа:");
                num2Numerator = scanner.nextInt();
                num2Denominator = scanner.nextInt();
            }

            String result = "";
            switch (operation) {
                case 1:
                    if (dataType == 1) {
                        Complex num1 = new Complex(num1Real, num1Imaginary);
                        Complex num2 = new Complex(num2Real, num2Imaginary);
                        Complex sum = calculator.sum(num1, num2);
                        result = sum.toString();
                    } else {
                        Rational num1 = new Rational(num1Numerator, num1Denominator);
                        Rational num2 = new Rational(num2Numerator, num2Denominator);
                        Rational sum = calculator.sum(num1, num2);
                        result = sum.toString();
                    }
                    break;
                case 2:
                    if (dataType == 1) {
                        Complex num1 = new Complex(num1Real, num1Imaginary);
                        Complex num2 = new Complex(num2Real, num2Imaginary);
                        Complex diff = calculator.diff(num1, num2);
                        result = diff.toString();
                    } else {
                        Rational num1 = new Rational(num1Numerator, num1Denominator);
                        Rational num2 = new Rational(num2Numerator, num2Denominator);
                        Rational diff = calculator.diff(num1, num2);
                        result = diff.toString();
                    }
                    break;
                case 3:
                    if (dataType == 1) {
                        Complex num1 = new Complex(num1Real, num1Imaginary);
                        Complex num2 = new Complex(num2Real, num2Imaginary);
                        Complex result1;
                        switch (operation) {
                            case 1:
                                result1 = calculator.sum(num1, num2);
                                break;
                            case 2:
                                result1 = calculator.diff(num1, num2);
                                break;
                            case 3:
                                result1 = calculator.mult(num1, num2);
                                break;
                            case 4:
                                result1 = calculator.div(num1, num2);
                                break;
                            default:
                                System.out.println("Invalid operation.");
                                continue;
                        }
                        result1 = calculator.simplify(result1);
                        logger.log(result1.toString());
                    } else if (dataType == 2) {
                        Rational num1 = new Rational(num1Numerator, num1Denominator);
                        Rational num2 = new Rational(num2Numerator, num2Denominator);
                        Rational result2;
                        switch (operation) {
                            case 1:
                                result2 = calculator.sum(num1, num2);
                                break;
                            case 2:
                                result2 = calculator.diff(num1, num2);
                                break;
                            case 3:
                                result2 = calculator.mult(num1, num2);
                                break;
                            case 4:
                                result2 = calculator.div(num1, num2);
                                break;
                            default:
                                System.out.println("Invalid operation.");
                                continue;
                        }
                        result2 = calculator.simplify(result2);
                        logger.log(result2.toString());
                    } else {
                        System.out.println("Invalid data type.");
                        continue;
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
        }
    }
}
