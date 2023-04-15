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
            System.out.println("Выберите тип данных: \n1 - комплексные числа \n2 - рациональные числа");
            int dataType = scanner.nextInt();
            Calculator calculator;
            
            if (dataType == 1) {
                calculator = new Calculator(logger);
            } 
            else {
                calculator = new Calculator(logger);
            }

            System.out.println("Выберите операцию: \n1 - сложение \n2 - вычитание \n3 - умножение \n4 - деление \n5 - завершение работы");
            int operation = scanner.nextInt();
            if (operation == 5) {
                System.out.println("Завершение работы...");
                running = false;
            }
            double num1Real = 0, num1Imaginary = 0, num2Real = 0, num2Imaginary = 0;
            int num1Numerator = 0, num1Denominator = 0, num2Numerator = 0, num2Denominator = 0;
            Complex num1 = null;
            Complex num2 = null;
            Rational num1R = null;
            Rational num2R = null;

            if (dataType == 1) {
                System.out.println("Введите действительную часть первого числа:");
                num1Real = scanner.nextDouble();
                System.out.println("Введите мнимую часть первого числа:");
                num1Imaginary = scanner.nextDouble();
                System.out.println("Введите действительную часть второго числа:");
                num2Real = scanner.nextDouble();
                System.out.println("Введите мнимую часть второго числа:");
                num2Imaginary = scanner.nextDouble();
                num1 = new Complex(num1Real, num1Imaginary);
                num2 = new Complex(num2Real, num2Imaginary);
            } else {
                System.out.println("Введите числитель первого числа:");
                num1Numerator = scanner.nextInt();
                System.out.println("Введите знаменатель первого числа:");
                num1Denominator = scanner.nextInt();
                System.out.println("Введите числитель второго числа:");
                num2Numerator = scanner.nextInt();
                System.out.println("Введите знаменатель второго числа:");
                num2Denominator = scanner.nextInt();
                num1R = new Rational(num1Numerator, num1Denominator);
                num2R = new Rational(num2Numerator, num2Denominator);
            }

            String result = "";
            switch (operation) {
                case 1:
                    if (dataType == 1) {
                        Complex sum = calculator.sum(num1, num2);
                        result = sum.toString();
                    } else {
                        Rational sum = calculator.sum(num1R, num2R);
                        result = sum.toString();
                    }
                    break;
                case 2:
                    if (dataType == 1) {
                        Complex diff = calculator.diff(num1, num2);
                        result = diff.toString();
                    } else {
                        Rational diff = calculator.diff(num1R, num2R);
                        result = diff.toString();
                    }
                    break;
                case 3:
                    if (dataType == 1) {
                        Complex quotient = calculator.mult(num1, num2);
                        result = quotient.toString();
                    } else {
                        Rational quotient = calculator.mult(num1R, num2R);
                        result = quotient.toString();
                    }
                    break;
                case 4:
                    if (dataType == 1) {
                        Complex quotient = calculator.div(num1, num2);
                        result = quotient.toString();
                    } else {
                        Rational quotient = calculator.div(num1R, num2R);
                        result = quotient.toString();
                    }
                    break;

                default:
                    System.out.println("Неправильный выбор.");
                    continue;
            }
        }
    }
}
