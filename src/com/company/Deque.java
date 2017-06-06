package com.company;

public class Deque<E> {
    class Node{
        E data;
        Node next;
        Node prev;
        public Node(){}
        public Node(E d){
            data = d;}
    }

    Node rear, front;

    public void addFirst(E data){
        if(rear == null){
            rear = new Node(data);
            front = rear;
        }
        else{
            front.next = new Node(data);
            front.next.prev = front;
            front = front.next;
        }
    }
    public void addLast(E data){
        if(rear == null){
            rear = new Node(data);
            front = rear;
        }
        else{
            rear.prev = new Node(data);
            rear.prev.next = rear;
            rear = rear.prev;
        }
    }
    public void clear(){
        front = null;
        rear = null;
    }
    public E peakFirst(){
        return front.data;
    }
    public E peakLast(){
        return rear.data;
    }
    public boolean contains(E data){
        Node temp = rear;
        while(temp != null){
            if(temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public E getFirst(){
        return front.data;
    }
    public E getLast(){
        return rear.data;
    }
    public boolean isEmpty(){
        return front.data == null;
    }
    public E pollFirst(){
        Node temp = front;
        front = temp.prev;
        temp.prev.next = null;
        if(front == null)
            rear = null;
        return temp.data;
    }
    public E pollLast(){
        Node temp = rear;
        rear = rear.next;
        temp.next.prev = null;
        if(rear == null)
            front = null;
        return temp.data;
    }
    public E pop(){
        return pollFirst();
    }
    public void push(E data){
        addFirst(data);
    }
    public E remove(){
        return pollFirst();
    }
    public boolean remove(E data){
        Node temp = rear;
        while(temp != null){
            if(temp.data.equals(data)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return true;
            }
        }
        return false;
    }
    public int size(){
        int i = 0;
        Node temp = rear;
        while(temp != null){
            temp = temp.next;
            i++;
        }
        return i;
    }
    public String toString(){
        String s = "[";
        Node temp = front;
        while(temp != null){
            s += temp.data + ",";
            temp = temp.prev;
        }
        return s + "]";
    }
}
