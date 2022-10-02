package com.collections.stackshuffle;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class StackShuffle {

    public static void main(String[] args) {

        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);

        System.out.println("Unshuffled Stack: " + Arrays.asList(intStack));

        intStack = shuffle(intStack);

        System.out.println("Shuffled Stack: " + Arrays.asList(intStack));

    }

    public static Stack<Integer> shuffle(Stack<Integer> stackToShuffle) {

        Random rand = new Random();

        for (int i = 0; i < stackToShuffle.size(); i++) {
            int indexToSwap = rand.nextInt(stackToShuffle.size());
            Integer temp = stackToShuffle.get(indexToSwap);
            stackToShuffle.set(indexToSwap, stackToShuffle.get(i));
            stackToShuffle.set(i, temp);
        }
        return stackToShuffle;
    }
}
