package net.klakegg.sortable;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadmeExample {

    // Implementation using annotation
    @Sort(1)
    class MyFirstClass {

    }

    // Implementation using interface
    class MySecondClass implements Sortable {

        @Override
        public int getOrder() {
            return 2;
        }
    }

    @Test
    public void test() {
        // Adding objects to a list:
        List<Object> list = new ArrayList<>();
        list.add(new MySecondClass());
        list.add(new MyFirstClass());
        list.add("String object.");

        // Sorting in Java 7:
        Sortables.sort(list);
        Collections.sort(list, Sortables.comparator());

        // Sorting in Java 8:
        // list.sort(Sortables.comparator());
        // list.sort(comparing(Sortables::extract));

        for (Object o : list)
            System.out.println(o);
    }
}
