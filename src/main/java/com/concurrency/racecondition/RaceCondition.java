package com.concurrency.racecondition;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable r = () -> {
            for (int i = 0; i < 1_00; i++) {
                longWrapper.incrementValue();
            }
        };

        Thread[] threads = new Thread[1_00];
        for (int i = 0; i < threads.length; i++) {
            // The threads
            threads[i] = new Thread(r);
            threads[i].start();
            // when we invoke the join(), the calling thread goes into a waiting state
            // it will remain in a waiting state until the referenced thread terminates
            threads[i].join();
        }

        System.out.println("Value = " + longWrapper.getValue());
    }
}
