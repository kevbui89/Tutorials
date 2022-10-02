package com.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsExample {

    public void perform() {

        // Most efficient implentation is the HashSet
        Set<String> hs = new HashSet<>();

        hs.add("one");
        hs.add("two");
        hs.add("three");

        System.out.println("Here is the HashSet: " + hs);

        if (!hs.add("three")) {
            System.out.println("Attempt to add duplicate. " + "Set is unchanged: " + hs);
        }

        // The TreeSet uses the object rather than the hashcode to determine if
        // the object already exists in the set.
        Set<String> ts = new TreeSet<>();

        ts.add("one");
        ts.add("two");
        ts.add("three");

        System.out.println("Here is the TreeSet: " + ts);

        if (!ts.add("three")) {
            System.out.println("Attempt to add duplicate. " + "Set is unchanged: " + ts);
        }

    }

    public static void main(String args[]) throws Exception {
        SetsExample ace = new SetsExample();
        ace.perform();
        System.exit(0);
    }
}
