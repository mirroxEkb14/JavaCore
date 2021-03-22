package FunctionalProgrammingLambda.DefaultStaticMethods.DefaultMethods;

public class Demo {

    public static void main(String[] args) {
        MyInterfaceImpl example = new MyInterfaceImpl();
        example.doTask();
        example.notOverridden(); // default we didnt override
        example.overridden(); // default we overrode
    }
}
