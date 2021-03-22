package Exceptions.CreateException;

public class Demo {
    public static void main(String[] args) {
        PerimeterSquare perimeterSquare = new PerimeterSquare();

        try {
            perimeterSquare.getPerimeter("g");
        } catch (SideException e) {
            e.printStackTrace();
        }
    }
}
