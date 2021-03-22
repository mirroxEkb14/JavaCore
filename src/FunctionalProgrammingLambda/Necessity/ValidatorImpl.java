package FunctionalProgrammingLambda.Necessity;

public class ValidatorImpl implements Validator{

    public boolean validate(int value) {
        return value >= 60;
    }
}
