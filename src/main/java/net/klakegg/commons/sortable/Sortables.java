package net.klakegg.commons.sortable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class containing methods to make Sortable interface and Sort annotation useful.
 */
public class Sortables {

    /**
     * Method extracting order value from a given object.
     *
     * Priority:
     * <ul>
     *  <li>Implementation of Sortable if value higher than Integer.MIN_VALUE.</li>
     *  <li>Annotation of Sort.</li>
     *  <li>Returns 0.</li>
     * </ul>
     */
    public static <T> int extract(T o) {
        if (o instanceof Sortable) {
            int r = ((Sortable) o).getOrder();
            if (r != Integer.MIN_VALUE)
                return ((Sortable) o).getOrder();
        }

        if (o.getClass().isAnnotationPresent(Sort.class))
            return o.getClass().getAnnotation(Sort.class).value();

        return 0;
    }

    /**
     * Returns a comparator.
     */
    public static <T> Comparator<T> comparator() {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(extract(o1), extract(o2));
            }
        };
    }

    /**
     * Sorts list of object using Sortable interface and Sort annotation.
     */
    public static <T> void sort(List<T> list) {
        Collections.sort(list, comparator());
    }
}