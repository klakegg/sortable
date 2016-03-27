package net.klakegg.commons.sortable;

/**
 * Interface for returning a value used for comparison.
 */
public interface Sortable {

    /**
     * Return value used to compare, return Integer.MIN_VALUE to ignore returned value.
     *
     * @return Value used to compare.
     */
    int getOrder();
}
