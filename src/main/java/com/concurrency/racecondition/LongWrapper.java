package com.concurrency.racecondition;

public class LongWrapper {
    private long l;
    private Object key = new Object();

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public void incrementValue() {
        // This operation is a read and write operation from different threads at the same time
        // This is a race condition
        synchronized (key) {
            l = l + 1;
        }
    }


}
