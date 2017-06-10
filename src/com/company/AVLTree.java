package com.company;

public class AVLTree {
    class Node{
        Node left;
        Node right;
        int data;
        int balance;
        public Node(){}
        public Node(int d){data = d;}
    }
    Node root;

    public Node rotateLeft(Node a){
        Node b = a.left;
        a.left = b.right;
        b.right = a;
        return b;
    }
    public Node rotateRight(Node a){
        Node b = a.right;
        a.right = b.left;
        b.left = a;
        return b;
    }
    public Node rotateLeftRight(Node n){
        Node b = n.left;
        Node c = b.right;
        b.right = c.left;
        n.left = c;
        c.left = b;
        return rotateLeft(n);
    }

    public Node rotateRightLeft(Node n){
        Node b = n.right;
        Node c = n.left;
        b.left = c.right;
        n.right = c;
        c.right = b;
        return rotateRight(n);
    }
    public void insert(int data){
        root = insert(root,data);
    }
    private Node insert(Node p, int data){
        if(p == null){
            Node newNode = new Node(data);
            return newNode;
        }
        else{
            if(p.data > data)
                p.left = insert(p.left, data);
            else
                p.right = insert(p.right, data);
        }
        int left = height(p.left);
        int right = height(p.right);
        int balance = left - right;
        if(Math.abs(balance) > 1) {
            if (balance == 2)
                if(height(p.left.left) - height(p.left.right) == -1)
                    p = rotateLeftRight(p);
                else
                    p = rotateLeft(p);
            else if (balance == -2){
                if(height(p.right.left) - height(p.right.right) == 1)
                    p = rotateRightLeft(p);
                else
                    p = rotateRight(p);
            }
        }
        return p;
    }
    private int height(Node n){
        if (n == null) {
            return -1;
        }
        int left = height(n.left);
        int right = height(n.right);
        n.balance = left - right;
        return (left > right ? left : right) + 1;
    }

    private void preOrder(Node parent) {
        if (parent == null)
            return;
        System.out.println(parent.data);
        preOrder(parent.left);
        preOrder(parent.right);
    }
    public String toString(){
        preOrder(root);
        return "";
    }
    public Node remove(int data) {
        return null;
    }
}
