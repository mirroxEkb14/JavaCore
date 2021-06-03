package AbstractClass.BasisConcepts;

public abstract class NecessityOfAbstractMethods {

    /**
     * Abstract class can have no abstract methods
     * Word 'abstract' in signature of class imposes
     * restrictions, for instance, ban on creating
     * instances of class
     *
     * Abstract methods cannot have a body, realization
     * of such methods is set by overridden methods in
     * descendant class
     *
     * Descendant class must either be declared abstract
     * or implement methods of parent class
     */

    public void nonAbstractMethod() {
        System.out.println("A am not abstract");
    };

    public abstract void abstractMethod();
}

class Child extends NecessityOfAbstractMethods {

    @Override
    public void abstractMethod() {};
}