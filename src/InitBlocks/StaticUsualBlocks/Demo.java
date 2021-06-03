package InitBlocks.StaticUsualBlocks;

public class Demo {

    /**
     * There are usual and static init blocks
     *
     * static blocks run when accessing to the class
     * usual blocks run when the class is instantiated
     */

    static {
        System.out.println("hello from static block");
    }

    {
        System.out.println("hello from usual block");
    }

    public static void main(String[] args) {
        // As 'main' method is in this class,
        // the static block will run

        // if we create a class instance, after
        // static block, usual block will run
        new Demo();
    }
}
