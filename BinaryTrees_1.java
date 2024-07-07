package DSA_Java;

import java.util.*;

//Binary Tree is a tree in which each parent node can have only 2 children nodes
//Root --> Starting Node
//Leaf --> Node without any children nodes
public class BinaryTrees_1 {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; // This'll be the root node
        }
    }

    // Printing the order of a tree
    // PreOrder Traversal- Root first,then left & then right subtree
    public static void preOrder(Node root) {
        if (root == null) {
            // If you want to print -1 here you can
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // InOrder Traversal - First left subtree, then root & then right subtree
    public static void inOrder(Node root) {
        if (root == null) {
            // If you want to print -1 here you can
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // PostOrder Traversal - First left then right subtree and then root
    public static void postOrder(Node root) {
        if (root == null) {
            // If you want to print -1 here you can
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // # LevelOrder Traversal - Level wise printing of tree (important)
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Null is added as and indicator for next line

        while (q.isEmpty() == false) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty() == true) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }; // Here 1 is the root node,2 is its left child,
                                                                        // 4 is left child of 2 and 4 is a leaf
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        System.out.println(root.data); // 1 should be printed as it is the root node
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
    }
}