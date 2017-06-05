package com.company;

public class NewLinkedList <E>{
    class Node{
        Node next;
        E data;
        public Node(){}
        public Node(E d, Node n){
            next = n;
            data = d;
        }
    }
    Node head;
    public void add(E data){
        if(head == null){
            head = new Node();
            head.data = data;
            return;
        }
        Node t = head;
        while(t.next != null){
            t = t.next;
        }
        t.next = new Node();
        t.next.data = data;
    }
    public E get(int index) {
        Node t = head;
        while(index > 0) {
            if(t == null)
                throw new ArrayIndexOutOfBoundsException();
            t = t.next;
            index--;
        }
        return t.data;
    }
    public boolean insert(E data, int index) {
        Node t = head;
        if(t == null)
            return false;
        while(t != null && index > 0){
            t = t.next;
            index--;
        }
        t.next = new Node(data, t.next);
        return true;
    }
    public String toString(){
        Node t = head;
        String s = "[";
        while(t != null){
            s += t.data + ",";
        }
        return s + "]";
    }
}
