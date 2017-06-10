package com.company;

public class ExpressionTree {
    class Node{
        char c;
        Node left;
        Node right;
        public Node(){}
        public Node(char ch){c = ch;}
    }
    Node root;
    public ExpressionTree(String x){
        root = get(new StringBuffer(x));
    }
    private Node get(StringBuffer x){
        if(x.length() == 0)
            return null;
        else if(Character.isDigit(x.charAt(0))){
            return new Node(x.charAt(0));
        }
        else{
            Node n = new Node(x.charAt(0));
            x = x.delete(0,1);
            n.left = get(x);
            x = x.delete(0,1);
            n.right = get(x);
            return n;
        }
    }

    public int evaluate(){
        return evaluate(root);
    }
    private int evaluate(Node n){
        if(Character.isDigit(n.c))
            return n.c - 48;
        switch (n.c){
            case '+':
                return evaluate(n.left) + evaluate(n.right);
            case '-':
                return evaluate(n.left) - evaluate(n.right);
            case '*':
                return evaluate(n.left) * evaluate(n.right);
            case '/':
                return evaluate(n.left) / evaluate(n.right);
        }
        return -1;
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node parent) {
        if (parent == null)
            return;
        System.out.println(parent.c);
        preOrder(parent.left);
        preOrder(parent.right);
    }

    public String toString(){
        preOrder();
        return "";
    }
}
