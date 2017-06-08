package com.company;

public class BinarySearchTree {
    Node root;

    public void insert(int data) {
        if (root == null)
            root = new Node(data);
        else {
            Node current = root, prev = root;
            while (current != null) {
                prev = current;
                current = data < current.data ? current.left : current.right;
            }
            if (prev.data > data)
                prev.left = new Node(data);
            else
                prev.right = new Node(data);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node parent) {
        if (parent == null)
            return;
        System.out.println(parent.data);
        preOrder(parent.left);
        preOrder(parent.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node parent) {
        if (parent == null)
            return;
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.println(parent.data);
    }

    public int largest() {
        Node n = root;
        while (n.right != null) {
            n = n.right;
        }
        return n.data;
    }

    public boolean contains(int data) {
        Node n = root;
        while (n != null) {
            if (n.data == data)
                return true;
            n = data > n.data ? n.right : n.left;
        }
        return false;
    }

    public int smallest() {
        Node n = root;
        while (n.left != null) {
            n = n.left;
        }
        return n.data;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node parent) {
        if (parent == null)
            return;
        inOrder(parent.left);
        System.out.println(parent.data);
        inOrder(parent.right);
    }

    public String toString() {
        preOrder();
        return "";
    }

    public int heightOf(int data) {
        Node n = root;
        while (n != null) {
            if (n.data == data)
                break;
            n = data > n.data ? n.right : n.left;
        }
        if (n == null)
            return -1;
        return height(n);
    }

    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null) {
            return -1;
        }
        int left = height(n.left);
        int right = height(n.right);
        return (left > right ? left : right) + 1;
    }

    public boolean strictlyBinary() {
        return strictlyBinary(root);
    }

    private boolean strictlyBinary(Node n) {
        if (n == null)
            return false;
        if (n.right == null && n.left == null)
            return true;
        return strictlyBinary(n.left) && strictlyBinary(n.right);
    }

    public boolean complete() {
        return complete(root) != -1;
    }

    private int complete(Node n) {
        if (n == null)
            return 1;
        int left = complete(n.left);
        int right = complete(n.right);
        if (left == 0 || right == 0)
            return 0;
        return left == right ? left + 1 : -1;
    }

    public int depth(int data) {
        int c = 0;
        Node n = root;
        while (n != null) {
            if (n.data == data)
                return c;
            c++;
            n = data > n.data ? n.right : n.left;
        }
        return -1;
    }

    public boolean remove(int data) {
        Node n = root, prev = null;
        while (n != null) {
            if (n.data == data)
                break;
            prev = n;
            n = data > n.data ? n.right : n.left;
        }
        if (n == null)
            return false;

        if (n.left != null && n.right != null) {
            Node succ = n.right;
            prev = succ;
            while (succ.left != null) {
                prev = succ;
                succ = succ.left;
            }
            n.data = succ.data;
            n = succ;
            data = succ.data;

        }

        if (n == root) {
            if (n.left != null)
                root = n.left;
            else
                root = n.right;
        } else if (n.left == null && n.right != null) {
            if (data > prev.data)
                prev.right = n.right;
            else
                prev.left = n.right;
        } else if (n.left != null && n.right == null) {
            if (data > prev.data)
                prev.right = n.left;
            else
                prev.left = n.left;
        } else if (n.left == null && n.right == null) {
            if (data > prev.data)
                prev.right = null;
            else
                prev.left = null;
        }
        return true;
    }

    class Node {
        Node left;
        Node right;
        int data;

        public Node() {
        }

        public Node(int d) {
            data = d;
        }
    }

}
