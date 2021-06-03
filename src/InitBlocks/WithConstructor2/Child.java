package InitBlocks.WithConstructor2;

/*
    When we refer to 'Child' class, firstly, we refer to 'Parent' class,
    parent static blocks are called,
    after that child static blocks,
    then we create child class instance,
    we call child class constructor,
    in child constructor parent constructor is called,
    in parent constructor, after 'super()' method('Parent' class does not extend any another class, so
        this method calls 'Object' class) usual blocks are called,
    then the following constructor code,
    after it, child constructor continues its implementation - child usual blocks are called,
    then the following child constructor code
 */

class Parent {

    static {
        System.out.println("parent class static block");
    }

    {
        System.out.println("parent class usual block");
    }

    Parent() {
        System.out.println("parent class constructor");
    }
}

public class Child extends Parent {

    static {
        System.out.println("child class static block");
    }

    {
        System.out.println("child class usual block");
    }

    public Child() {
        super();
        System.out.println("child class constructor");
    }

    public static void main(String[] args) {
        new Child();

        /*
            parent class static block
            child class static block
            parent class usual block
            parent class constructor
            child class usual block
            child class constructor
         */
    }
}
