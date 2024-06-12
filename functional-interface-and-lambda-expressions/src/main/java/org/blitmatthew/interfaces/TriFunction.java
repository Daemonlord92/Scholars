package org.blitmatthew.interfaces;
@FunctionalInterface
public interface TriFunction <T, U, Z, R> {
    R apply(T a, U b, Z z);
}
