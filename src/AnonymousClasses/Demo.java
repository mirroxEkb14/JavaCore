package AnonymousClasses;

public class Demo {

    public static void main(String[] args) {
        /*  Functional programming is programming where functions are objects,
                where you can assign them to variables, pass them as arguments
                to other functions  */

        // anonymous function
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer from) {
                return from.toString();
            }
        };

        System.out.println(function.apply(9000));
    }
}
