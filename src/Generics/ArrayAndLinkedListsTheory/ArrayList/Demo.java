package Generics.ArrayAndLinkedListsTheory.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        /* .get(int index) - O(1) ->                 because arrayList
           .add() at the end of the list - O(1) ->   is based on array

           .add() to the center of the list - O(n) -> because
                we need to move all the elements from the passed index to right

           .remove() from the center of the list - 0(n) -> because
                we need to move all the elements from the passed index to left
         */

        /* 'ArrayList' is just an array that contains all the data;

         *  The initial size of the array is '10', but we can pass
                an argument 'initialCapacity' in the class constructor; */

        List<Integer> integers = new ArrayList<>(3);


         /*  'ArrayList<Car> cars = new ArrayList<>();' - creates
                an array: [null, null, null, ...]; */

        List<Car> cars = new ArrayList<>(); // [null, null, null, null, null, null, null, null, null, null] - 10


         /*   When we want to add some elements in the end,
                firstly, the array size is checked: either the array is full or not
                ('in the end' means the cell following the last element:
                ["some string", "string number 2", null, null, ...] -> the element
                will be added instead of the first 'null', other nulls remain) */

        cars.add(new Car("Ferrari")); // [new Car("Ferrari"), null, null, null, null, null, null, null, null, null]
        cars.add(new Car("Bugatti")); // [new Car("Ferrari"), new Car("Bugatti"), null, null, null, null, null, null, null, null]


        /*  What if we add a value in the center? Firstly, the array size is checked,
                if there is space, we shift all the elements(from necessary elements)
                to the right. The elements from the second cell(1 index) copies to
                the third cell(2 index), now we have two same elements:
                [new Car("Ferrari"), new Car("Bugatti"), new Car("Bugatti"), null, null, null, null, null, null, null].
                Then we paste 'new Car("Ford")' instead of 'new Car("Bugatti")'(1 index) */

        cars.add(1, new Car("Ford")); // [new Car("Ferrari"), new Car("Ford"), new Car("Bugatti"), null, null, null, null, null, null, null]

        /* If there is no space(10/10 cells), a new array is created using mathematical
               formula: size of old array * 3/2 + 1 (firstly 10, then 16, 25, ...), after
               that all the elements from old array are copied to a new one, then a new
               elements is added, the old array will be removed by garbage collector */

        // now the array is full(10/10 elements)
        cars.add(new Car("Toyota"));
        cars.add(new Car("Lambo"));
        cars.add(new Car("Volvo"));
        cars.add(new Car("Maserati"));
        cars.add(new Car("Honda"));
        cars.add(new Car("Kia"));
        cars.add(new Car("Fiat"));

        // creates a new array(16 cells), the old one is copied to the new, this element is added to a new array
        cars.add(new Car("One more car"));


        /* When removing the element is just removed and all the elements
               after deleted one move left */

        /* 'new Car("Ford")' needs to be deleted
         *  Our list -> [new Car("Ferrari"), new Car("Ford"), new Car("Bugatti"), new Car("Toyota"), ...]
         *  Just remove the necessary element: [new Car("Ferrari"), null, new Car("Bugatti"), new Car("Toyota"), ...]
         *  And move other elements to left: [new Car("Ferrari"), new Car("Bugatti"), new Car("Toyota"), ...]*/
        cars.remove(1);


        /* For example, we have a list of 88 elements, we need to delete 77 elements,
               after this, we have 11 elements and 77 empty cells(memory is allocated for them),
               but there is method 'trimToSize' that will reduce the size of the list size
               to 11(how many elements are in list)  */

        ArrayList<Car> cars1 = new ArrayList<>();
        cars1.trimToSize();
    }
}
