package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplyCollectionAlgorithmsToArray {
    public void perform() {
        String n[] = new String[]{"John", "Lennon", "Karl", "Marx",
                "Groucho", "Marx", "Oscar", "Grouch"};

        // Arrays algorithm to implement a List interface from a simple array
        List<String> l = Arrays.asList(n);
        //l.add("Ken"); // fails because array is fixed length

        // Collections algorithm to sort a collection
        Collections.sort(l);
        System.out.println(l);
    }

    public static void main(String args[]) {
        ApplyCollectionAlgorithmsToArray ace = new ApplyCollectionAlgorithmsToArray();
        ace.perform();
        System.exit(0);
    }
}
