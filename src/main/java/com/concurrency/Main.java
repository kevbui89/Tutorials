package com.concurrency;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Runnable runnable = () -> {
            System.out.println("I am running in " + Thread.currentThread().getName());
        };

        Thread t = new Thread(runnable);
        t.setName("1st Thread");
        t.start();
        // This is the thread execution the main method.
        // This should not be launched if we want to run a new thread.
        //t.run();
    }
}