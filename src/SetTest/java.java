package SetTest;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

/**
 * Created by Rainicy on 6/2/14.
 */
import java.text.*;
import java.util.*;
public class java {
    public static void main(String args[]) {
        Collator collator = Collator.getInstance();
        CollationKey key1 = collator.getCollationKey("Tom");
        CollationKey key2 = collator.getCollationKey("tom");
        CollationKey key3 = collator.getCollationKey("thom");
        CollationKey key4 = collator.getCollationKey("Thom");
        CollationKey key5 = collator.getCollationKey("Thomas");
        Set set = new TreeSet();
        set.add(key1);
        set.add(key2);
        set.add(key3);
        set.add(key4);
        set.add(key5);
        printCollection(set);
    }
    static private void printCollection(
            Collection collection) {
        boolean first = true;
        Iterator iterator = collection.iterator();
        System.out.print("[");
        while (iterator.hasNext()) {
            if (first) {
                first = false;
            } else {
                System.out.print(", ");
            }
            CollationKey key = (CollationKey)iterator.next();
            System.out.print(key.getSourceString());
        }
        System.out.println("]");
    }
}