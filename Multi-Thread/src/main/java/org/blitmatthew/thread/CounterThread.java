package org.blitmatthew.thread;

public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
            System.out.println(this.getName() + " " + counter.getCount());
        }
    }
}
