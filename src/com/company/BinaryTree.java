package com.company;
import java.util.Scanner;
public class BinaryTree {
    public static Scanner sc = new Scanner(System.in);
    class Node {
        int data;
        Node left;
        Node right;
        public Node() {
        }
        public Node(int d) {
            data = d;
        }
    }
    Node root;
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

    public String toString(){
        preOrder();
        return "";
    }

    public void insert(int data){
        Node n = root, prev = null;
        String s = "";
        while(n != null){
            s = sc.next();
            prev = n;
            if(s == "l")
                n = n.left;
            else if(s == "r")
                n = n.right;
        }
        if(prev == null)
            root = new Node(data);
        else{
            if(s == "l")
                prev.left = new Node(data);
            else
                prev.right = new Node(data);
        }
    }

    public int largest(){
        return largest(root);
    }
    private int largest(Node n){
        if(n == null)
            return 0;
        int left = largest(n.left);
        int right = largest(n.right);
        if(n.data > left && n.data > right)
            return n.data;
        return left > right ? left : right;
    }

    public boolean contains(int data){
        return contains(root,data);
    }
    private boolean contains(Node n,int data){
        if(n == null)
            return false;
        if(n.data == data)
            return true;
        return contains(n.left,data) || contains(n.right,data);
    }
}
