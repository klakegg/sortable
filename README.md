# Sortable

[![Build Status](https://travis-ci.org/klakegg/sortable.svg?branch=master)](https://travis-ci.org/klakegg/sortable)
[![Codecov](https://codecov.io/gh/klakegg/sortable/branch/master/graph/badge.svg)](https://codecov.io/gh/klakegg/sortable)
[![JitPack](https://jitpack.io/v/klakegg/sortable.svg)](https://jitpack.io/#klakegg/sortable)

This project aims to solve my tiny itch of sorting in Java. Sorting i Java is not hard, but now and then I find myself sorting objects in a list where a uniform implementation of Comparable is not enough.


## Using Sortable

```java
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

// Creating a list of objects
List<Object> list = new ArrayList<>();
list.add(new MySecondClass());
list.add(new MyFirstClass());
list.add("String object.");

// Sorting in Java 7
Sortables.sort(list);
Collections.sort(list, Sortables.comparator());

// Sorting in Java 8
list.sort(Sortables.comparator());
list.sort(comparing(Sortables::extract));

// Writing result of sort
for (Object o : list)
    System.out.println(o);

// Output:
// String object.
// MyFirstClass@1b0375b3
// MySecondClass@2f7c7260
```
