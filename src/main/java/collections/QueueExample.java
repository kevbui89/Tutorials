package collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public void perform() {

        // Creating a Queue in Java version 1.0 till 1.4
        Queue queue1 = new LinkedList();

        // Creating a Queue in Java version 1.5
        Queue<Integer> queue2 = new LinkedList<>();

        // Creating a queue in Java 1.6
        Queue<Integer> queue3 = new ArrayDeque<>();

        // Add three elements to the queue
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        queue3.offer(7);
        queue3.offer(8);
        queue3.offer(9);

        // Remove three elements
        System.out.println("queue1 remove: " + queue1.remove());
        System.out.println("queue1 remove: " + queue1.remove());
        System.out.println("queue1 remove: " + queue1.remove());

        System.out.println("queue2 poll: " + queue2.poll());
        System.out.println("queue2 poll: " + queue2.poll());
        System.out.println("queue2 poll: " + queue2.poll());

        // Use isEmpty() to loop thru queue
        while (!queue3.isEmpty()) {
            System.out.println("queue3 poll: " + queue3.poll());
        }

        System.out.println("remove and poll an empty queue");
        // Remove one more element
        //System.out.println("queue1 remove: " + queue1.remove());
        System.out.println("queue3 poll: " + queue3.poll());
    }

    public static void main(String args[]) throws Exception {
        QueueExample ace = new QueueExample();
        ace.perform();
        System.exit(0);
    }
}
