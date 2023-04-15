package ComplexRationalCalculator;
public interface CalculatorOperations<N> {
    N sum(N other);

    N diff(N other);

    N mult(N other);

    N div(N other);
}
