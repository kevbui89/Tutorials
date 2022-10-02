package com.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public void perform() {
        String names[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter",
                "Saturn", "Uranus", "Neptune", "Pluto"};

        Collection<String> planets = new ArrayList<>();

        for (int i = 0, n = names.length; i < n; i++) {
            planets.add(names[i]);
        }

        String s[] = planets.toArray(new String[0]);

        for (int i = 0, n = s.length; i < n; i++) {
            System.out.println(s[i]);
        }

        planets.remove(names[3]);

        System.out.println(names[1] + " " + planets.contains(names[1]));
        System.out.println(names[3] + " " + planets.contains(names[3]));

    }

    public static void main(String args[]) {
        CollectionExample ace = new CollectionExample();
        ace.perform();
        System.exit(0);
    }
}
