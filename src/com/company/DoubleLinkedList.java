package com.company;



public class DoubleLinkedList
{
    class Node
    {
        Node nextNode;
        Node prevNode;
        int data;

        public Node getNextNode() {
            return nextNode;
        }
        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
        public Node getPrevNode() {
            return prevNode;
        }
        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
    }
    public Node first;
    public boolean add(int data)
    {
        Node newnode = new Node();
        newnode.setData(data);
        newnode.setNextNode(null);
        if(first == null)
        {
            first = newnode;
            first.setPrevNode(null);
            return false;
        }
        Node temp = first;
        while(temp.getNextNode() != null)
        {
            temp = temp.getNextNode();
        }
        temp.setNextNode(newnode);
        newnode.setPrevNode(temp);
        return true;
    }
    public boolean remove(int index)
    {
        int i = 0;
        Node temp = first;
        while(i < index-1 && temp != null)
        {
            temp = temp.getNextNode();
            i++;
        }
        if(temp == null)
        {
            return false;
        }
        temp.getPrevNode().setNextNode(temp.getNextNode());
        temp.getNextNode().setPrevNode(temp.getPrevNode());
        return true;
    }
    public int get(int index)
    {
        int i = 0;
        Node temp = first;
        while(i < index && temp != null)
        {
            temp = temp.getNextNode();
            i++;
        }
        if(temp == null)
        {
            return -1;
        }
        return temp.getData();
    }
    public String toString()
    {
        String s = "";
        Node temp = first;
        while(temp != null)
        {
            s += temp.getData() + " ";
            temp = temp.getNextNode();
        }
        return s;
    }
    public int size()
    {
        Node temp = first;
        int c = 0;
        while(temp != null)
        {
            temp = temp.getNextNode();
            c++;
        }
        return c;
    }
    public boolean insertAt(int index, int data)
    {
        int i = 0;
        Node temp = first;
        Node n = new Node();
        if(index == 0)
        {
            n.setData(data);
            n.setNextNode(first);
            first = n;
            if(first.getNextNode()!=null)
                first.getNextNode().setPrevNode(first);
            return true;
        }
        while(i < index-1 && temp != null)
        {
            temp = temp.getNextNode();
            i++;
        }
        if(temp == null)
        {
            return false;
        }

        n.setNextNode(temp);
        n.setPrevNode(temp.getPrevNode());
        temp.setPrevNode(n);
        n.getPrevNode().setNextNode(n);
        return true;
    }
    public boolean insertAfter(int data, int newData)
    {
        Node temp = first;
        while(temp.data != data && temp != null)
        {
            temp = temp.getNextNode();
        }
        if(temp == null)
        {
            return false;
        }
        return true;
    }
}