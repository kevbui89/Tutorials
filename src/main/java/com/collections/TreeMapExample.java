package com.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public void perform() {
        Map<Integer, String> map = new TreeMap<>();

        // Add Items to the TreeMap
        map.put(6, "Six");
        map.put(1, "One");
        map.put(4, "Four");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(5, "Five");
        map.put(2, "Two");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(3, "Three");

        System.out.println("Before: Iterator");
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
        }

        // New functional stream notation
        System.out.println("\nBefore: Stream");
        map.entrySet().forEach((entry) -> {
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
        });

        // Remove the entry with key 6
        System.out.println("\nRemove element with key 6");
        map.remove(6);

        // New functional stream notation
        System.out.println("\nAfter: Stream");
        map.entrySet().forEach((entry) -> {
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
        });

    }

    public static void main(String args[]) throws Exception {
        TreeMapExample ace = new TreeMapExample();
        ace.perform();
        System.exit(0);
    }
}
