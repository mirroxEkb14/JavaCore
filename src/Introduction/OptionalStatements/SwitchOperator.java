package Introduction.OptionalStatements;

public class SwitchOperator {

    public static void main(String[] args) {
        int num1 = 1; // 1, 2, 3, default, needed 'break;'
        switch (num1) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            default:
                System.out.println("default");
        }

        int num2 = 1;
        switch (num2) {
            case 1:
            case 2:
                System.out.println("1 or 2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
                break;
        }

        int counter = 10;
        int num3 = switch (counter) { // 'default' is necessary
            case 1, 2, 3 -> 4;
            case 10, 20, 30 -> 5;
            default -> 40;
        };
        System.out.println(num3);
    }
}
