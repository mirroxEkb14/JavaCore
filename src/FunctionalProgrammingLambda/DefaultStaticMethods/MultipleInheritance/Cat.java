package FunctionalProgrammingLambda.DefaultStaticMethods.MultipleInheritance;

public class Cat implements Walk, Run {
    /*  Without override method this class
        does not compile  */

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed()); // 8
    }

    @Override
    public int getSpeed() {
        return 8;
    }
}
