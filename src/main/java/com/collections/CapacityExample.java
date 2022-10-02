package com.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

public class CapacityExample {

    public void perform() throws Exception {

        // The Vector
        Vector<String> data1 = new Vector<>();
        System.out.println("Vector initial capacity=" + data1.capacity());
        data1.add("hello");
        data1.add("goodbye");
        for (int x = 0; x < 100; ++x) {
            data1.add("hello");
            // Built in capacity method
            System.out.println("Vector capacity=" + data1.capacity());
        }

        // This ArrayList of the same data set
        ArrayList<String> data2 = new ArrayList<>();
        System.out.println("ArrayList initial capacity=" + data2.size());
        data2.add("hello");
        for (int x = 0; x < 100; ++x) {
            data2.add("hello");
            // Use an external method to retrieve the capacity
            System.out.println("ArrayList capacity=" + findCapacity(data2));
        }

    }

    /**
     * ArrayList uses an internal array buffer (Object elementData[]) to store
     * the elements. The capacity of the ArrayLength is the length of this array
     * which can be returned by length property of an array. elementData[] is a
     * private array field in the ArrayList. To access the private field and
     * find the length we use the reflection feature of Java.
     */
    private int findCapacity(ArrayList<?> al) throws Exception {
        // The name elementData comes from reading the source code
        // for an ArrayList as this is a private variable not normally exposed
        // Field is a class used to hold data retrieved from a class using reflection
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(al)).length;
    }

    public static void main(String args[]) throws Exception {
        CapacityExample ace = new CapacityExample();
        ace.perform();
        System.exit(0);
    }
}
