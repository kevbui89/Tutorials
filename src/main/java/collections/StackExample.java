package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackExample {

    public void perform() {

        // This is the stack class that has been part of Java since V1.0
        // It is based on a vector
        // Though not deprecated, you are advised to not use it
        Stack stack1 = new Stack();

        // The generic version, available since Java 1.5,
        // is always the preferred version
        Stack<Integer> stack2 = new Stack<>();

        // The preferred way to implement a stack before Java 1.6 was released
        // uses a linkedlist
        LinkedList stack3 = new LinkedList();

        // The generic version, available since Java 1.5,
        // is always the preferred version
        LinkedList<Integer> stack4 = new LinkedList<>();

        // The preferred way to implement a stack in Java 1.6
        // uses an ArrayDeque
        Deque<Integer> stack5 = new ArrayDeque<>();

        // Add two elements to the stack
        stack1.push(5);
        stack1.push(27);

        stack2.push(6);
        stack2.push(28);

        stack3.push(7);
        stack3.push(29);

        stack4.push(8);
        stack4.push(30);

        stack5.push(9);
        stack5.push(31);

        System.out.println("stack1 peek: " + stack1.peek());
        System.out.println("stack2 peek: " + stack2.peek());
        System.out.println("stack3 peek: " + stack3.peek());
        System.out.println("stack4 peek: " + stack4.peek());
        System.out.println("stack5 peek: " + stack5.peek());

        System.out.println("stack1 empty before pop: " + stack1.empty());
        int x = (Integer) stack1.pop();
        int y = (Integer) stack1.pop();
        System.out.println("stack1 empty after pop: " + stack1.empty());

        System.out.println("stack2 empty before pop: " + stack2.empty());
        x = stack2.pop();
        y = stack2.pop();
        System.out.println("stack2 empty after pop: " + stack2.empty());

        System.out.println("stack3 empty before pop: " + stack3.isEmpty());
        x = (Integer) stack3.pop();
        y = (Integer) stack3.pop();
        System.out.println("stack3 empty after pop: " + stack3.isEmpty());

        System.out.println("stack4 empty before pop: " + stack4.isEmpty());
        x = stack4.pop();
        y = stack4.pop();
        System.out.println("stack4 empty after pop: " + stack4.isEmpty());

        System.out.println("stack5 empty before pop: " + stack5.isEmpty());
        while (!stack5.isEmpty()) {
            x = stack5.pop();
        }
        System.out.println("stack5 empty after pop: " + stack5.isEmpty());

        System.out.println("Pop an empty stack");
        System.out.println("stack5");
        x = stack5.pop();
        // Always check if a stack is empty before you pop
    }

    public static void main(String args[]) throws Exception {
        StackExample ace = new StackExample();
        ace.perform();
        System.exit(0);
    }
}
