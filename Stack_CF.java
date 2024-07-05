//Stack implementation using collection frameworks
package DSA_Java;

import java.util.*;

public class Stack_CF {
    // Add an element on the bottom of the stack
    public static void pushatbottom(int data, Stack<Integer> s) {
        if (s.isEmpty()) { // Add the given element
            s.push(data);
            return;
        }
        int top = s.pop(); // Removes the top element
        pushatbottom(data, s); // Keeps on removing the top element until the stack is empty
        s.push(top); // Adds the removed element again
    }

    // Reverse a Stack
    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s); // Keeps on decreasing the size of the stack until its empty
        pushatbottom(top, s); // Push the elements in reverse order that is starting at the bottom
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushatbottom(4, s);
        reverse(s);
        while (s.isEmpty() == false) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
