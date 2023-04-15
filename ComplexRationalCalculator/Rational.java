package ComplexRationalCalculator;
public class Rational implements CalculatorOperations<Rational> {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public Rational sum(Rational other) {
        int commonDenominator = lcm(this.denominator, other.getDenominator());
        int commonNumerator = this.numerator * (commonDenominator / this.denominator)
                + other.getNumerator() * (commonDenominator / other.getDenominator());
        int gcd = gcd(commonNumerator, commonDenominator);
        return new Rational(commonNumerator / gcd, commonDenominator / gcd);
    }

    @Override
    public Rational diff(Rational other) {
        int commonDenominator = lcm(this.denominator, other.getDenominator());
        int commonNumerator = this.numerator * (commonDenominator / this.denominator)
                - other.getNumerator() * (commonDenominator / other.getDenominator());
        int gcd = gcd(commonNumerator, commonDenominator);
        return new Rational(commonNumerator / gcd, commonDenominator / gcd);
    }

    @Override
    public Rational mult(Rational other) {
        int numerator = this.numerator * other.getNumerator();
        int denominator = this.denominator * other.getDenominator();
        int gcd = gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    @Override
    public Rational div(Rational other) {
        int numerator = this.numerator * other.getDenominator();
        int denominator = this.denominator * other.getNumerator();
        int gcd = gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // helper methods for finding gcd and lcm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
