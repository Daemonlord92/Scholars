package org.blitmatthew.interfaces;
//Single Abstract Method Interface
@FunctionalInterface
public interface SingleMathOperation<T> {
    T operation(T a);
    default void add(int a, int b) {
        System.out.println(a+b);
    }
}
