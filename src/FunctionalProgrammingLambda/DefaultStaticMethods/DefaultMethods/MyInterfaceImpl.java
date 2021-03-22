package FunctionalProgrammingLambda.DefaultStaticMethods.DefaultMethods;

public class MyInterfaceImpl implements MyInterface {

    @Override
    public void doTask() {
        System.out.println("doing task...");
    }

//    @Override
//    public void doSpecialTask() {
//        System.out.println("doing special task in implementation (overridden)");
//    }

    @Override
    public void overridden() {
        System.out.println("this method is overridden in the implementation");
    }
}
