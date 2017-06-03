package com.company;

public class Stack <E> {
    class Node
    {
        Node pre;
        E data;
        public Node(E d)
        {
            data = d;
        }
        public Node(){}
    }
    Node top;
    public Stack()
    {}
    public void push(E data)
    {
        if(top == null)
            top = new Node(data);
        Node temp = new Node(data);
        temp.pre = top;
        top = temp;
    }
    public E peak()
    {
        if (top == null)
            return null;
        return top.data;
    }
    public E pop()
    {
        Node temp = top;
        top = temp.pre;
        return temp.data;
    }
    public String toString()
    {
        String s = "";
        Node temp = top;
        while(temp.pre != null) {
            s += temp.data + " ";
            temp = temp.pre;
        }
        return s;
    }
    public int size()
    {
        int c = 0;
        Node temp = top;
        if (temp == null)
            return 0;
        while(temp.pre != null) {
            c++;
            temp = temp.pre;
        }
        return c;
    }
}
