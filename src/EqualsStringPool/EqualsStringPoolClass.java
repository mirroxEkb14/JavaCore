package EqualsStringPool;

public class EqualsStringPoolClass {
    public static void main(String[] args) {
        /*  'animal1' and 'animal2' are memory areas, they link to value '1',
            and because memory areas are different, they are not equal  */

        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);

        System.out.println(animal1 == animal2); // false
        System.out.println(animal1.equals(animal2)); // true

        /*  Java allocates memory space for 'dog', 'string1' links to 'dog';
            when we create 'string2', 'dog' in the right side is not created,
            'string2' just links to 'dog', so we save memory  */
        String string1 = "dog";
        String string2 = "dog";
        System.out.println(string1 == string2); // true
        System.out.println(string1.equals(string2)); // true

        /*  with 'new' operator Java allocates new memory space for "cat", so
            'string4' does not link to 'cat', it links to a new memory space  */
        String string3 = new String("cat");
        String string4 = new String("cat");
        System.out.println(string3 == string4); // false
        System.out.println(string3.equals(string4)); // true
    }
}

class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        // compare by 'id'
        Animal anotherAnimal = (Animal) obj;
        return this.id == anotherAnimal.id;
    }
}