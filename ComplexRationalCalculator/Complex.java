package ComplexRationalCalculator;
public class Complex implements CalculatorOperations<Complex> {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public Complex sum(Complex other) {
        return new Complex(real + other.getReal(), imaginary + other.getImaginary());
    }

    @Override
    public Complex diff(Complex other) {
        return new Complex(real - other.getReal(), imaginary - other.getImaginary());
    }

    @Override
    public Complex mult(Complex other) {
        double newReal = real * other.getReal() - imaginary * other.getImaginary();
        double newImaginary = real * other.getImaginary() + imaginary * other.getReal();
        return new Complex(newReal, newImaginary);
    }

    @Override
    public Complex div(Complex other) {
        double otherReal = other.getReal();
        double otherImaginary = other.getImaginary();
        double denominator = otherReal * otherReal + otherImaginary * otherImaginary;
        double newReal = (real * otherReal + imaginary * otherImaginary) / denominator;
        double newImaginary = (imaginary * otherReal - real * otherImaginary) / denominator;
        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + (imaginary >= 0 ? " + " : " - ") + Math.abs(imaginary) + "i";
    }
}
