package FunctionalProgrammingLambda.Necessity;

public class NecessityRunner {

    public static void main(String[] args) {
        int value = 70;
        /*  we want to validate our value, there are 2 ways (before java 8)  */

        // first -> create a class that implements "Validator" interface (ValidatorImpl)
        validate(value, new ValidatorImpl());

        // second -> anonymous class
        validate(value, new Validator() {
            @Override
            public boolean validate(int value) {
                return value >= 80;
            }
        });


        /* with lambda expressions (since java 8)  */
        validate(value, value1 -> value >= 70);
    }

    public static void validate(int value, Validator validator) {
        boolean isValid = validator.validate(value);
        if (isValid) {
            System.out.println("The value is correct");
        } else {
            System.out.println("The value is incorrect");
        }
    }
}
