package AbstractClass.BasisConcepts;

public abstract class Constructor {

    /**
     * Abstract classes have constructors
     * You cannot create instance of abstract class
     * Then what`s the point of using? To set class fields
     *
     * Even if you do not create constructor by yourself,
     * the compiler creates it without arguments because
     * without doing it class will not compile
     *
     * If you create constructor with arguments, you also
     * need to create constructor without arguments
     */

    private long id;

    public Constructor(long id) {
        this.id = id;
    }

    public Constructor() {};
}

class SubClass extends Constructor {

    public SubClass(long id) {
        super(1L);
    }
}