package DSA_Java;

//This is LinkedList Using Collection frameworks
import java.util.LinkedList;

public class LL_2 {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);
        list.addLast("list"); // add and addLast are the same functions
        list.addFirst("This");
        System.out.println(list);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        list.remove(0); // Index of the element you wanna remove from in between
        System.out.println(list);
    }

}
