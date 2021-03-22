package FunctionalProgrammingLambda.DefaultStaticMethods.MultipleInheritance;

public interface Walk {

    default int getSpeed() {
        return 8;
    }
}
