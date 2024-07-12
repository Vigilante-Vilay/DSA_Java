package DSA_Java;

// Queue using Java Collection Frameworks
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList; // Everything imported

public class Queue_frameWork {
    // Queues using two stacks
    public static class Queue_Stacks {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            if (s1.isEmpty() == true) {
                return true;
            } else {
                return false;
            }
        }

        public static void add(int data) {
            while (s1.isEmpty() == false) {
                s2.push(s1.pop()); // Transferring elements from one stack to another
            }

            s1.push(data);

            while (s2.isEmpty() == false) {
                s1.push(s2.pop()); // Transferring the elements back
            }
        }

        public static int remove() {
            if (s1.isEmpty() == true) {
                System.out.println("Empty Queue");
                return -1;
            }
            return s1.pop(); // Pop is a stack function
        }

        public static int peek() { // This "peek" is a Queue function
            if (s1.isEmpty() == true) {
                System.out.println("Empty Queue");
                return -1;
            }
            return s1.peek(); // Here peek is a stack operation
        }

    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        // Queue is an interface, not a class
        // Interfaces cannot have objects of thier own, only classes can
        // So queue are made using two classes
        // Either "LinkedList" or "ArrayDeque"

        // Queue<Integer> q = new ArrayDeque<>() makes a double ended queue
        // Usually Queue is preferred using ArrayDeque
        // Because of time complexity reasons
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (q.isEmpty() == false) {
            System.out.println(q.peek());
            q.remove();
        }

        // Queue using two stacks
        Queue_Stacks q1 = new Queue_Stacks();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        while (q1.isEmpty() == false) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
