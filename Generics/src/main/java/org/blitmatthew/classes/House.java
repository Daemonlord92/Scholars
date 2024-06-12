package org.blitmatthew.classes;

public class House <T> {
    private T data;

    public House(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
