package org.blitmatthew.linkedlist;

public class LList {
    private int value;
    private LList prev;
    private LList next;

    public LList(int value, LList prev, LList next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LList getPrev() {
        return prev;
    }

    public void setPrev(LList prev) {
        this.prev = prev;
    }

    public LList getNext() {
        return next;
    }

    public void setNext(LList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LList{" +
                "value=" + value +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
