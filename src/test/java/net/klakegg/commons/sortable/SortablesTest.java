package net.klakegg.commons.sortable;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortablesTest {

    @Test
    public void simple() {
        List<Object> list = new ArrayList<>();
        list.add(new Order2());
        list.add(new OrderX(3));
        list.add(new OrderY());
        list.add(new OrderUnknown());
        list.add(new Order1());

        Sortables.sort(list);

        Assert.assertTrue(list.get(0) instanceof OrderUnknown);
        Assert.assertTrue(list.get(1) instanceof Order1);
        Assert.assertTrue(list.get(2) instanceof Order2);
        Assert.assertTrue(list.get(3) instanceof OrderX);
        Assert.assertTrue(list.get(4) instanceof OrderY);
    }

    @Test
    public void simpleContructor() {
        new Sortables();
    }

    class OrderUnknown {

    }

    @Sort(1)
    class Order1 {

    }

    class Order2 implements Sortable {
        @Override
        public int getOrder() {
            return 2;
        }
    }

    class OrderX implements Sortable {
        private int order;

        public OrderX(int order) {
            this.order = order;
        }

        @Override
        public int getOrder() {
            return order;
        }
    }

    @Sort(4)
    class OrderY implements Sortable {
        @Override
        public int getOrder() {
            return Integer.MIN_VALUE;
        }
    }
}
