package com.concurrency.waitnotify;

public class ProducerConsumer {

    private static final Object lock = new Object();

    private static int[] buffer;
    private static int count;

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String... strings) throws InterruptedException {
        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer: " + count);
    }

    static class Producer {
        void produce() {
            // synchronized marks a block that only allows one thread to execute at any given time
            synchronized (lock) {
                if (isFull(buffer)) {
                    try {
                        // wait() forces a thread to wait until some other thread invokes notify()
                        // on the same object
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[count++] = 1;
                // notifies any threads waiting on this object's monitor
                // called when all wanted logic is done
                lock.notify();
            }
        }
    }

    static class Consumer {
        void consume() {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }
}
