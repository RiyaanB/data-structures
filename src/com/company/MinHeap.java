package com.company;

public class MinHeap {

    class Node {
        int data;
        Node left;
        Node right;
        public Node(int d) {
            data = d;
        }
    }
    Node root;
    public MinHeap() {
    }

    public void insert(int data)
    {
        if (root == null)
        {
            root = new Node(data);
            return;
        }
        insert(data,root);
    }

    private Node insert(int data, Node r) {
        if (r == null)
        {
            return new Node(data);
        }
        if (data > r.data)
            r.right = insert(data,r.right);
        else if (data < r.data)
            r.left = insert(data,r.left);
        return r;
    }
}
