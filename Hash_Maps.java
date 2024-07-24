//HashMaps are unordered Key-Value pairs
package DSA_Java;

import java.util.*;

public class Hash_Maps {
    public static void main(String args[]) {
        // Country - Key - (String)
        // Population - Value - (Integer)
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 150);
        map.put("China", 120);
        map.put("US", 30);

        System.out.println(map);
        map.put("China", 130); // Updates the value
        System.out.println(map);

        // Search
        if (map.containsKey("China")) {
            System.out.println("Key present in the map");
        }

        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

        // New way of writing a for loop
        // for(variable:collection){}
        int arr[] = { 12, 45, 23 };
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // For hashmaps
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //Removal
        map.remove("China");
        System.out.println(map);
    }
}
