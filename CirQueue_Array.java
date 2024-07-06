//Circular queues are just like the name suggests, "Circular" in shape
//The rear circles behind the front.
//When elements are removed from the front, front moves forward instead of elements moving backwards
//When the queue is full from the behind, rear moves towards the start of the array
//Queue would be full when (rear+1)%size is equal front
package DSA_Java;

public class CirQueue_Array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1; // Since front is also changing this time

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty() {
            if (rear == -1 && front == -1) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean isFull() {
            if ((rear + 1) % size == front) {
                return true;
            } else {
                return false;
            }
        }

        // Enqueue
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Full Queue");
                return;
            }
            // 1st element add
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size; // This is the way rear is incremented in circular queue
            arr[rear] = data;
        }

        // Dequeue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int res = arr[front];
            // Single element condition
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return res;
        }

        // Peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove()); // 1 removed
        q.add(6); // 6 added in the place of 1
        System.out.println(q.remove()); // 2 removed as front was at index 1 this time
        q.add(7); // 7 added in place of 2
        while (q.isEmpty() == false) {
            System.out.println(q.peek()); // Since the front is at index 2 now, 3 will be printed first
            q.remove(); // after reaching 5, then 6 and 7 will be printed
        }
    }

}
