package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {

    public void perform() {

        // Creating a Queue in Java version 1.0 till 1.4
        Deque deque1 = new LinkedList();

        // Creating a Queue in Java version 1.5
        Deque<Integer> deque2 = new LinkedList<>();

        // Creating a queue in Java 1.6
        Deque<Integer> deque3 = new ArrayDeque<>();

        // Add six elements to the deque
        deque1.addFirst(1);
        deque1.addFirst(2);
        deque1.addFirst(3);
        deque1.addLast(1);
        deque1.addLast(2);
        deque1.addLast(3);

        deque2.addFirst(4);
        deque2.addFirst(5);
        deque2.addFirst(6);
        deque2.addLast(4);
        deque2.addLast(5);
        deque2.addLast(6);

        deque3.offerFirst(7);
        deque3.offerFirst(8);
        deque3.offerFirst(9);
        deque3.offerLast(7);
        deque3.offerLast(8);
        deque3.offerLast(9);

        // Use isEmpty() to loop thru deque
        while (!deque1.isEmpty()) {
            System.out.println("deque1 removeFirst: " + deque1.removeFirst());
        }

        while (!deque2.isEmpty()) {
            System.out.println("deque2 pollFirst: " + deque2.pollFirst());
        }

        while (!deque3.isEmpty()) {
            System.out.println("deque3 pollLast: " + deque3.pollLast());
        }

        System.out.println("remove and poll an empty deque");
        //Remove one more element
        System.out.println("deque1 remove: " + deque1.removeLast());
        //System.out.println("deque3 poll: " + deque3.pollLast());
    }

    public static void main(String args[]) throws Exception {
        DequeExample ace = new DequeExample();
        ace.perform();
        System.exit(0);
    }
}
