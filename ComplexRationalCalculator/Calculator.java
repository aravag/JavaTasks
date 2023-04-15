package ComplexRationalCalculator;
public class Calculator {
    private Logger logger;

    public Calculator(Logger logger) {
        this.logger = logger;
    }

    public Complex sum(Complex c1, Complex c2) {
        Complex result = c1.sum(c2);
        logger.log("Сумма " + c1 + " и " + c2 + " равняется " + result);
        return result;
    }

    public Rational sum(Rational r1, Rational r2) {
        Rational result = r1.sum(r2);
        logger.log("Сумма " + r1 + " и " + r2 + " равняется " + result);
        return result;
    }

    public Complex diff(Complex c1, Complex c2) {
        Complex result = c1.diff(c2);
        logger.log("Разница между " + c1 + " и " + c2 + " равняется " + result);
        return result;
    }

    public Rational diff(Rational r1, Rational r2) {
        Rational result = r1.diff(r2);
        logger.log("Разница между " + r1 + " и " + r2 + " равняется " + result);
        return result;
    }

    public Complex mult(Complex c1, Complex c2) {
        Complex result = c1.mult(c2);
        logger.log("Умножение " + c1 + " и " + c2 + " равняется " + result);
        return result;
    }

    public Rational mult(Rational r1, Rational r2) {
        Rational result = r1.mult(r2);
        logger.log("Умножение " + r1 + " и " + r2 + " равняется " + result);
        return result;
    }

    public Complex div(Complex c1, Complex c2) {
        Complex result = c1.div(c2);
        logger.log("Деление " + c1 + " и " + c2 + " равняется " + result);
        return result;
    }

    public Rational div(Rational r1, Rational r2) {
        Rational result = r1.div(r2);
        logger.log("Деление " + r1 + " и " + r2 + " равняется " + result);
        return result;
    }

    public Complex simplify(Complex num) {
        double real = num.getReal();
        double imaginary = num.getImaginary();
        double abs = Math.sqrt(real * real + imaginary * imaginary);
    
        if (abs == 0) {
            return new Complex(0, 0);
        }
    
        real /= abs;
        imaginary /= abs;
    
        if (imaginary == 1) {
            return new Complex(0, 1);
        } else if (imaginary == -1) {
            return new Complex(0, -1);
        }
    
        return new Complex(real, imaginary);
    }

    public Rational simplify(Rational num) {
        int numerator = num.getNumerator();
        int denominator = num.getDenominator();
    
        if (numerator == 0) {
            return new Rational(0, 1);
        }
    
        int gcd = findGcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    
        return new Rational(numerator, denominator);
    }
    
    private int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }
    
    
}
