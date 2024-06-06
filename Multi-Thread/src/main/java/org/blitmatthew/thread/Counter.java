package org.blitmatthew.thread;

public class Counter {
    private int count;
    public Counter() {
        this.count = 0;
    }

    public synchronized void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
