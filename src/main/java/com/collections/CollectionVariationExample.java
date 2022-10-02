package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionVariationExample {
    public void perform() {

        Collection<String> list1 = new LinkedList<>();
        list1.add("Animal");
        list1.add("Cougar");
        list1.add("Basket");
        list1.add("Cougar");
        traverse("List/LinkedList", list1);

        Collection<String> list2 = new ArrayList<>();
        list2.add("Animal");
        list2.add("Cougar");
        list2.add("Basket");
        list2.add("Cougar");
        traverse("List/ArrayList", list2);

        Collection<String> set1 = new HashSet<>();
        set1.add("Animal");
        set1.add("Cougar");
        set1.add("Basket");
        set1.add("Cougar");
        traverse("Set/HashSet", set1);

        Collection<String> set2 = new TreeSet<>();
        set2.add("Animal");
        set2.add("Cougar");
        set2.add("Basket");
        set2.add("Cougar");
        traverse("SortedSet/TreeSet", set2);

        Collection<String> set3 = new LinkedHashSet<>();
        set3.add("Animal");
        set3.add("Cougar");
        set3.add("Basket");
        set3.add("Cougar");
        traverse("LinkedHashSet", set3);

        // Maps do not implement the Collections interface. Retrieving just the
        // keys or just the values returns a data structure that implements the
        // Collection interface.
        Map<String, String> m1 = new HashMap<>();
        m1.put("Animal", "Java");
        m1.put("Cougar", "Perl");
        m1.put("Basket", "Python");
        m1.put("Cougar", "Ruby");
        traverse("Map/HashMap:keys", m1.keySet());
        traverse("Map/HashMap:values", m1.values());

        Map<String, String> m2 = new TreeMap<>();
        m2.put("Animal", "Java");
        m2.put("Cougar", "Perl");
        m2.put("Basket", "Python");
        m2.put("Cougar", "Ruby");
        traverse("Map/TreeMap:keys", m2.keySet());
        traverse("Map/TreeMap:values", m2.values());

        Map<String, String> m3 = new LinkedHashMap<>();
        m3.put("Animal", "Java");
        m3.put("Cougar", "Perl");
        m3.put("Basket", "Python");
        m3.put("Cougar", "Ruby");
        traverse("Map/LinkedHashMap:keys", m3.keySet());
        traverse("Map/LinkedHashMap:values", m3.values());
    }

    /**
     * Display every element in a collection using an iterator
     *
     * @param collectionName
     * @param coll
     */
    private void traverse(String collectionName, Collection<String> coll) {
        System.out.println("Collection: " + collectionName);
        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            String elem = iter.next();
            System.out.print(elem + " ");
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {
        CollectionVariationExample ace = new CollectionVariationExample();
        ace.perform();
        System.exit(0);
    }
}
