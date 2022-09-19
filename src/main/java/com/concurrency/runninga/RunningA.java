package com.concurrency.runninga;

public class RunningA {
    public static void main (String[] args) throws InterruptedException {
        A a = new A();

        //This is an example of a deadlock
        //a() has key1 and calls b()
        //b() has key 2 and runs c() which needs key1
        //c() needs key1, but it is waiting on a() to release key1

        Runnable r1 = () -> a.a();
        Runnable r2 = () -> a.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}
