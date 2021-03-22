package MethodOverloading;

public class Demo {
    /*  Method overloading is when you have
        two methods with the same name but
        with different argument lists  */

    public String showArgument(String argumentOne) {
        System.out.println(argumentOne);
        return null;
    }

    public String showArgument(String argumentOne, String argumentTwo) {
        System.out.println(argumentOne);
        System.out.println(argumentTwo);
        return null;
    }
}
