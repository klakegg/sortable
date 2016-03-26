package net.klakegg.util.sortable;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sortables {

    public static int getOrder(Object o) {
        if (o instanceof Sortable)
            return ((Sortable) o).getOrder();
        if (o.getClass().isAnnotationPresent(Sort.class))
            return o.getClass().getAnnotation(Sort.class).value();
        return 0;
    }

    public static <T> Comparator<T> comparator() {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(getOrder(o1), getOrder(o2));
            }
        };
    }

    public static <T> void sort(List<T> list) {
        Collections.sort(list, comparator());
    }
}