package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionShuffleExample {

    public void perform() {
        String[] strArray = new String[]{"Java", "Perl", "Python", "Ruby",
                "PHP", "Rails"};

        List<String> l = Arrays.asList(strArray);
        System.out.println("Before shuffle: " + l);
        Collections.shuffle(l);
        System.out.println(" After shuffle: " + l);
    }

    public static void main(String args[]) {
        CollectionShuffleExample ace = new CollectionShuffleExample();
        ace.perform();
        System.exit(0);
    }
}
