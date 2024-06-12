package org.blitmatthew.classes;

import java.util.List;

public class FloatArray<T>{
    private List<T> array;

    public FloatArray(List<T> array) {
        this.array = array;
    }

    public List<T> getArray() {
        return array;
    }

    public void setArray(List<T> array) {
        this.array = array;
    }

    public static void addFloatToList(List<? super Float> list) {
        list.add(1.0f);
        list.add(3.5f);
    }
}
