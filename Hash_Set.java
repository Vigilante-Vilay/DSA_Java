//HashSets are unordered - Elements are not in any specific order
package DSA_Java;

import java.util.HashSet;
import java.util.Iterator; //For iterator
//HashSet does not contain duplicate elements

public class Hash_Set {
    public static void main(String args[]) {
        // Creating
        HashSet<Integer> set = new HashSet<>();

        // Adding
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // 1 will be added only once

        // Searching - contain() function
        if (set.contains(1)) {
            System.out.println("1 is present");
        }

        // Delete
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("1 is not present");
        }
        set.add(1);
        // Size
        System.out.println("Size of the set is " + set.size());

        // Printing all elements
        System.out.println(set);

        // Iterating
        Iterator it = set.iterator();
        // next() returns the next element
        // hasNext() returns true if there is a next element remaining
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
