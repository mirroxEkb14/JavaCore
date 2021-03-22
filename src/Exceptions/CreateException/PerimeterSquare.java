package Exceptions.CreateException;

public class PerimeterSquare {
    public void getPerimeter(String data) throws SideException {
        Square square = new Square();

        try {
            double side = Double.parseDouble(data);
            square.setSide(side);

        } catch (NumberFormatException e) { // if data is correct
            throw new SideException("String is incorrect", e);
        }
    }
}