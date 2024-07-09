//Binary Search Trees are special binary trees used for optimized searching
//In them,the values at left subtrees are always lesser than the root nodes
//And the values at right subtrees are always greater than the root nodes
package DSA_Java;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insertion in BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // Left Subtree
            root.left = insert(root.left, val);
        } else {
            // Right Subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal of BST's always results in a sorted sequence (To be
    // Remembered)
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Searching in BST - Time Complexity O(h) where h is the height
    public static boolean binSearch(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            // Search in Left Subtree
            return binSearch(root.left, key);
        } else {
            // Search in Right Subtree
            return binSearch(root.right, key);
        }
    }

    // Deletion in BST
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else { // root.data==val
                 // Case 1. Value is at a leaf Node (No child)
            if (root.left == null && root.right == null) {
                return null; // Returning null instead of the Node
            }
            // Case 2. Node has one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3. Node has two children
            Node IS = inOrderSuccessor(root.right); // Finding the inOrderSuccessor of the value in the rightSubtree
            root.data = IS.data; // Copying it in the original place of the value
            root.right = delete(root.right, IS.data); // Returning a tree by deleting the inOrderSuccessor in the right
                                                      // subtree
        }
        return root; // Returning the tree with deleted Node
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Function to print all the nodes in between a given range
    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        } else if (root.data >= y) {
            printInRange(root.left, x, y);
        } else {
            printInRange(root.right, x, y);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }

        inOrder(root);
        System.out.println();
        boolean res = binSearch(root, 1);
        System.out.println(res);

        delete(root, 4);
        inOrder(root);
        System.out.println();

        printInRange(root, 2, 5);
    }
}
