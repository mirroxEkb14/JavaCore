package FunctionalProgrammingLambda.DefaultStaticMethods.MultipleInheritance;

public interface Run {

    default int getSpeed() {
        return 10;
    }
}
