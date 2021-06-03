package AbstractClass.BasisConcepts;

public abstract class AbstractMethods {

    /**
     * Abstract methods is a method with no body.
     * You must extend abstract class and override
     * abstract method, adding the body
     */

    public abstract void printToConsole(String text);
}

class NonAbstract extends AbstractMethods {

    @Override
    public void printToConsole(String text) {
        System.out.println(text);
    }
}