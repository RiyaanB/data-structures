package com.company;

public class BinarySearchTree {
    class Node{
        Node left;
        Node right;
        int data;
        public Node(){}
        public Node(int d){
            data = d;
        }
    }
    Node root;
    public void insert(int data){
        if (root == null)
            root = new Node(data);
        else{
            Node current = root,prev = root;
            while(current != null){
                prev=current;
                current = data < current.data ? current.left : current.right;
            }
            if(prev.data > data)
                prev.left = new Node(data);
            else
                prev.right = new Node(data);
        }
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node parent){
        if (parent == null)
            return;
        System.out.println(parent.data);
        preOrder(parent.left);
        preOrder(parent.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node parent){
        if (parent == null)
            return;
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.println(parent.data);
    }

    public int largest(){
        Node n = root;
        while(n.right != null){
            n = n.right;
        }
        return n.data;
    }

    public boolean contains(int data){
        Node n = root;
        while(n != null){
            if(n.data == data)
                return true;
            n = data > n.data ? n.right : n.left;
        }
        return false;
    }

    public int smallest(){
        Node n = root;
        while(n.left!=null){
            n = n.left;
        }
        return n.data;
    }
    public boolean remove(int data){
        Node n = root,prev = root;
        while(n.data != data){
            if (n == null)
                return false;
            prev = n;
            n = data < n.data ? n.left : n.right;
        }
        if(n.right == null){

        }
        Node n2 = n.right, prev = n;
        while(n2.left != null){
            prev = n2;
            n2 = n2.left;
        }
        prev.left = null;
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node parent){
        if (parent == null)
            return;
        inOrder(parent.left);
        System.out.println(parent.data);
        inOrder(parent.right);
    }
    public String toString(){
        inOrder();
        return "";
    }
}
