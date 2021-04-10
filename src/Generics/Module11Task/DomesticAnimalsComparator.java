package Module11Task;

import java.util.Comparator;

public class DomesticAnimalsComparator implements Comparator<DomesticAnimals> {

    @Override
    public int compare(DomesticAnimals o1, DomesticAnimals o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
