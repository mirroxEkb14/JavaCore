package Introduction.PrimitiveDataTypes;

public class DataTypesDemo {

    public static void main(String[] args) {
        // byte (-128 - 127), so 128 = -127
        byte b = (byte) 128;

        /* we need "L" because without "L" the numbers counts as
            int type (2_000_000_000_000)

            the same with float(3.4e308) - double(1.7e308) is default, so we need "f" */
        long l = 9_111_111_111_111_111_111L;
        float f = 22.7f;

        /* Unicode
        char c = '\u0041'; */
    }
}
