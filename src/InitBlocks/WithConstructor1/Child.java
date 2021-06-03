package InitBlocks.WithConstructor1;

class Parent {

    Parent() {
        System.out.println("parent class constructor");
    }
}

public class Child extends Parent {

    static {
        System.out.println("static block");
    }

    {
        System.out.println("usual block");
    }

    Child() {
        /* When instantiating a class, parent class constructor is called (super()) method
           as all classes inherit from 'Object' class, constructor of 'Object' class in called

           In any constructor there is an invisible 'super()', and usual blocks are called between
           the word 'super()' and the following code after it

           So, for example, we have 'Parent' class with constructor, when the program starts,
           'static block' is printed because we access to the 'Child' class('main' method is here),
           then 'parent class constructor' is printed because we create an instance of 'Child' class,
           after that in 'Child' class constructor 'super()' method is called('Child' extends 'Parent'),
           then 'usual block' is printed because, as it is already been said, usual blocks are called
           between the 'super()' method and the following constructor code, then 'child class constructor'
           is printed*/
        System.out.println("child class constructor");
    }

    public static void main(String[] args) {
        new Child();
    }
}
