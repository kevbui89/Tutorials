package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtilitiesExample {
    public void perform() {

        // Use Arrays algorithm to convert an array into an object that supports the List interface
        List<String> list = Arrays.asList("one Four five six Two three Four five six one".split(" "));
        System.out.println(list);
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));

        // Certain algorithms such as min and max require a comparator
        AlphabeticComparator comp = new AlphabeticComparator();
        System.out.println("max w/ comparator: " + Collections.max(list, comp));
        System.out.println("min w/ comparator: " + Collections.min(list, comp));

        // Searching for one list inside another
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSubList: "
                + Collections.indexOfSubList(list, sublist));
        System.out.println("lastIndexOfSubList: "
                + Collections.lastIndexOfSubList(list, sublist));

        // Replace algorithm thats searches for the object in the Collection and then replaces it
        Collections.replaceAll(list, "one", "Yo");
        System.out.println("replaceAll: " + list);

        // Reverse algorithm
        Collections.reverse(list);
        System.out.println("reverse: " + list);

        // Rotate algorithm, moves elements to the right and those that exceed
        // the length of the Collection move to the front. Creates a circular
        // structure
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);

        // Copy algorithm
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        System.out.println("copy: " + list);

        // Swap algorithm swaps elements in the collection
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);

        // Fill algorithm fills a collection with a specified object
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);

        // nCopies algorithm returns a collection with a specified object
        // repeated in the collection
        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups: " + dups);
    }

    public static void main(String args[]) {
        CollectionUtilitiesExample ace = new CollectionUtilitiesExample();
        ace.perform();
        System.exit(0);
    }
}

/**
 * A Comparator is an object that can compare objects. As it exists outside of
 * the objects you can have multiple comparators or rules for different
 * purposes. The alternative is to implement the Comparable interface in the
 * objects but this means there can only be a single rule for comparisons.
 *
 * @author Ken Fogel
 */
class AlphabeticComparator implements Comparator<Object> {

    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s1.toLowerCase().compareTo(s2.toLowerCase());
    }
}