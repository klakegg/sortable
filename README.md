# Sortable

[![Build Status](https://travis-ci.org/klakegg/sortable.svg?branch=master)](https://travis-ci.org/klakegg/sortable)

This project aims to solve my tiny itch of sorting in Java. Sorting i Java is not hard, but now and then I find myself sorting object in a list where a uniform implementation of Comparable is not enough.


## Using Sortables

```java
// Using the annotation
@Sort(1)
class MyFirst {

}

// Using the interface
class MySecondClass implements Sortable {

    @Override
    public int getOrder() {
        return 2;
    }
}

// Putting them in a list:
List<Object> list = new ArrayList<>();
list.add(new MySecondClass());
list.add(new MyFirstClass());

// Sorting in Java 6-7:
Sortables.sort(list);
Collections.sort(list, Sortables.comparator());

// Sorting in Java 8:
list.sort(Sortables.comparator());
list.sort(comparing(Sortables::extract));
```