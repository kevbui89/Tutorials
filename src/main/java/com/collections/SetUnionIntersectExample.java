package com.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetUnionIntersectExample {

    public void perform() {

        // Create two sets.
        Set<String> s1 = new HashSet<>();
        s1.add("Sherlock Holmes");
        s1.add("Doctor Watson");
        s1.add("Inspector Lestrad");

        Set<String> s2 = new HashSet<>();
        s2.add("Sherlock Holmes");
        s2.add("Mycroft Holmes");

        Set<String> union = new TreeSet<>(s1);
        union.addAll(s2);    // now contains the union

        print("union", union);

        Set<String> intersect = new TreeSet<>(s1);
        intersect.retainAll(s2);

        print("intersection", intersect);

    }

    /**
     * Display the set
     * @param label
     * @param data
     */
    private void print(String label, Collection<String> data) {

        System.out.println("--------------" + label + "--------------");

        Iterator<String> it = data.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String args[]) throws Exception {
        SetUnionIntersectExample ace = new SetUnionIntersectExample();
        ace.perform();
        System.exit(0);
    }
}
