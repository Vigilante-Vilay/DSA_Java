package DSA_Java;

public class BinTrees_2 {
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

    // Function to count the number of nodes
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = count(root.left);
        int rightNodes = count(root.right);

        return leftNodes + rightNodes + 1;
    }

    // Function to return the sum of nodes
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return leftsum + rightsum + (root.data);
    }

    // Function to calculate height of the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHieght = height(root.left);
        int rightHieght = height(root.right);
        int myHieght = Math.max(leftHieght, rightHieght) + 1;
        return myHieght;
    }

    // Approach 1 to calculate diameter of the tree (Time complexity O(n^2))
    // Diameter is the longest distance betweeen two nodes
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    // Approach 2 to calculate diameter (Time complexity O(n))
    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    // We'll be calculating height and diameter together this time in same calls
    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTree = diameter2(root.left);
        TreeInfo rightTree = diameter2(root.right);

        int myHieght = Math.max(leftTree.ht, rightTree.ht) + 1;

        int diam1 = leftTree.diam;
        int diam2 = rightTree.diam;
        int diam3 = leftTree.ht + rightTree.ht + 1;

        int myDiam = Math.max(diam3, Math.max(diam1, diam2));

        TreeInfo myInfo = new TreeInfo(myHieght, myDiam);

        return myInfo;
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);
    }
}
