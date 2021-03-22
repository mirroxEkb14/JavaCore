package FunctionalProgrammingLambda.DefaultStaticMethods.StaticMethods;

public interface Hop {

    // we assign to the interface type(Hop) to call this method
    static int getJumpHeight() {
        return 8;
    }
}
