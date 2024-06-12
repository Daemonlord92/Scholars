package org.blitmatthew.classes;

import java.util.List;

public class NumberArray<T extends Number> {
    List<T> array;

    public NumberArray(List<T> array) {
        this.array = array;
    }

    public List<T> getArray() {
        return array;
    }

    public void setArray(List<T> array) {
        this.array = array;
    }

    public void add(T arg) {
        array.add(arg);
    }

    public void removeFirst() {
        array.remove(0);
    }
}
