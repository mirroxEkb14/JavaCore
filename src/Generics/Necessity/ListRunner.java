package Generics.Necessity;

public class ListRunner {
    public static void main(String[] args) {
        List withoutGeneric = new List(5);
        withoutGeneric.add("String1");
        withoutGeneric.add(1);
        withoutGeneric.add("String2");
        withoutGeneric.add(8d);
        withoutGeneric.add("String3");

        /*  When we try to get an element from the list, we do not know in advance
            what the type of the element is, so Java considers it to be 'Object' type;

            If we use 'Object' type, we cannot use the methods of other types,
            for instance: 'substring' - String and etc.  */

        Object returnedValue = withoutGeneric.get(0);


        /*  However we can make it the type we want but there are different types in our list,
            so we do not know either it returns the type we need or not  */

        String unreturnedString = (String) withoutGeneric.get(1); // index 1 - element '1' that is 'int' type

        ListGeneric<String> withGeneric = new ListGeneric<>(5);
        withGeneric.add("String1");
//        withGeneric.add(2); // Exception, only strings
        withGeneric.add("String2");

        /*  now we know what types the list contains  */

        String returnedString = withGeneric.get(0);

//        int unreturnedInt = withGeneric.get(0); // Exception, the list contains only strings
    }
}
