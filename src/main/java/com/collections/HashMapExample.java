package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public void perform() {
        Map<String, String> map = new HashMap<>();

        map.put("Alpha", "Terra");
        map.put("Beta", "Sherlock");
        map.put("Gamma", "Guinness");

        // Old fashioned (up to Java 1.7) loop
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
        }

        // New functional stream notation
        map.entrySet().forEach((entry) -> {
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
        });


        // The toString of a map prints inorder
        System.out.println("Map = " + map);

        // The HashCode values used by the HashMap
        System.out.println("Hash of Alpha: " + "Alpha".hashCode());
        System.out.println(" Hash of Beta: " + "Beta".hashCode());
        System.out.println("Hash of Gamma: " + "Gamma".hashCode());

        // Retrieve a value using the key
        String name = map.get("Beta");
        System.out.println("Value Beta = " + name);
    }

    public static void main(String args[]) throws Exception {
        HashMapExample ace = new HashMapExample();
        ace.perform();
        System.exit(0);
    }
}
