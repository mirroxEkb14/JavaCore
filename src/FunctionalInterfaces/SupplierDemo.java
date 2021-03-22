package FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        /*  takes nothing and returns the result  */

        Supplier<Integer> supplier = () -> 5;
        System.out.println(supplier.get());
    }
}
