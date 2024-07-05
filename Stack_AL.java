//Stack implementation using ArrayList
package DSA_Java;

import java.util.ArrayList;

public class Stack_AL {
    static class StackClass {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            if (list.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        // Push
        public static void push(int data) {
            list.add(data);
        }

        // Pop
        public static int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peek
        public static int peek() {
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        StackClass s = new StackClass();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (s.isEmpty() == false) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
