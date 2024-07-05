//Stack implementation using Linked List
package DSA_Java;

public class Stack_LL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    static class StackClass {

        public static boolean isEmpty() {
            if (head == null) {
                return true;
            } else {
                return false;
            }
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
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
