package DSA;

//LinkedList
class LL {
    private int size;

    LL() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null; // First a node is made always, not a link
            size++;
        }
    }

    Node head;

    // Add - First/Last
    public void addfirst(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }

        newnode.next = head;
        head = newnode;
    }

    public void addlast(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }

        Node currNode = head; // For Traversing a linked list always a node is created
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newnode;
    }

    // Print
    public void print() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");

    }

    // Delete - First/Last
    public void delFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        size--;
        Node currNode = head;
        head = currNode.next;

        // OR simply "head = head.next"
    }

    public void delLast() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondlast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondlast = secondlast.next;
        }

        secondlast.next = null;

    }

    // Size
    public int getSize() {
        return size;
    }

    // How to Reverse a linked list
    // Iterable way
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // Updating
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    // Recursive way
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String args[]) {
        LL list = new LL();
        list.addfirst("a");
        list.addfirst("is");
        list.print();
        list.addlast("list");
        list.print();
        list.addfirst("This");
        list.print();
        list.delFirst();
        list.print();
        list.delLast();
        list.print();
        System.out.println(list.getSize());
        list.reverseList();
        list.print();
        list.head = list.reverseRecursive(list.head);
        list.print();
    }
}
