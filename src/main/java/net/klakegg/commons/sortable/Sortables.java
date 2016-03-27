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
     * <p>
     * Priority:
     * <ul>
     *  <li>Implementation of Sortable if value higher than Integer.MIN_VALUE is returned.</li>
     *  <li>Annotation of Sort.</li>
     *  <li>Returns 0.</li>
     * </ul>
     *
     * @param <T> The type of the elements to be sorted.
     * @param o Object to extract value for comparison.
     * @return Value used to compare.
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
     *
     * @param <T> The type of the elements to be sorted.
     * @return Comparator to be used for sorting.
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
     *
     * @param <T> The type of the elements to be sorted.
     * @param list List to be sorted.
     */
    public static <T> void sort(List<T> list) {
        Collections.sort(list, comparator());
    }
}