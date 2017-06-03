package com.company;

public class Queue<E>
{
    class Node
    {
        Node next;
        E data;
        public Node(){}
        public Node(E d){data=d;}
    }
    Node front,rear;
    public Queue(){}
    public void insert(E data)
    {
        if (front == null && rear == null) {
            front = new Node(data);
            rear = front;
            return;
        }
        rear.next = new Node(data);
        rear = rear.next;
    }
    public E delete()
    {
        if (front == null)
            throw new ArrayIndexOutOfBoundsException();
        Node temp = front;
        front = front.next;
        if(front == null)
            rear = null;
        return temp.data;
    }
}