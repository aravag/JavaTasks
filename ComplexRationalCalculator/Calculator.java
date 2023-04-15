package ComplexRationalCalculator;
public class Calculator {
    private Logger logger;

    public Calculator(Logger logger) {
        this.logger = logger;
    }

    public Complex sum(Complex c1, Complex c2) {
        Complex result = c1.sum(c2);
        logger.log("Sum of " + c1 + " and " + c2 + " is " + result);
        return result;
    }

    public Rational sum(Rational r1, Rational r2) {
        Rational result = r1.sum(r2);
        logger.log("Sum of " + r1 + " and " + r2 + " is " + result);
        return result;
    }

    public Complex diff(Complex c1, Complex c2) {
        Complex result = c1.diff(c2);
        logger.log("Difference between " + c1 + " and " + c2 + " is " + result);
        return result;
    }

    public Rational diff(Rational r1, Rational r2) {
        Rational result = r1.diff(r2);
        logger.log("Difference between " + r1 + " and " + r2 + " is " + result);
        return result;
    }

    public Complex mult(Complex c1, Complex c2) {
        Complex result = c1.mult(c2);
        logger.log("Multiplication of " + c1 + " and " + c2 + " is " + result);
        return result;
    }

    public Rational mult(Rational r1, Rational r2) {
        Rational result = r1.mult(r2);
        logger.log("Multiplication of " + r1 + " and " + r2 + " is " + result);
        return result;
    }

    public Complex div(Complex c1, Complex c2) {
        Complex result = c1.div(c2);
        logger.log("Division of " + c1 + " and " + c2 + " is " + result);
        return result;
    }

    public Rational div(Rational r1, Rational r2) {
        Rational result = r1.div(r2);
        logger.log("Division of " + r1 + " and " + r2 + " is " + result);
        return result;
    }
}
