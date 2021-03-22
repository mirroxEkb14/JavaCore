package FunctionalProgrammingLambda.DefaultStaticMethods.DefaultMethods;

public interface MyInterface {

    // we have one abstract method
    void doTask();

    /*  For example, we enlarged our interface
        by adding one more method, so now
        we have to override this new method
        in all implementations what causes a problem
        but with "default" we do not need to override
        this new method in implementations but we can

        This method has a body because if we do not
        override this it in the implementation, we can still
        call this method and it will do what it is
        written in its body  */
    default void notOverridden() {
        System.out.println("body of 'notOverridden' method...");
    }

    default void overridden() {
        System.out.println("body of 'overridden' method...");
    }
}
