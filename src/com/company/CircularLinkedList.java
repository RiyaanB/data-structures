package com.company;

public class CircularLinkedList<E> {
    private Node last;
    public void add(E val) {
        Node newnode = new Node();
        newnode.setData(val);
        if (last == null) {
            last = newnode;
            last.setNext(last);
            return;
        }
        newnode.setNext(last.getNext());
        last.setNext(newnode);
        last = newnode;
    }
    public String toString() {
        if (last == null)
            return "null";
        String s = "";
        Node temp = last.getNext();
        do {
            s += temp.getData() + " ";
            temp = temp.getNext();
        }
        while (temp != last.getNext());
        return s;
    }
    public int count() {
        if (last == null) {
            return 0;
        }
        int c = 0;
        Node temp = last.getNext();
        do {
            temp = temp.getNext();
            c++;
        }
        while (temp != last.getNext());
        return c;
    }
    public E get(int index) {
        if (last == null)
            throw new ArrayIndexOutOfBoundsException();
        Node temp = last.getNext();
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
            if (temp == last.getNext())
                throw new ArrayIndexOutOfBoundsException();
        }
        return temp.getData();
    }
    public void remove(int index) {
        if (last == null || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        Node temp = last.getNext();
        Node pre = last;
        for (int i = 0; i < index; i++) {
            pre = temp;
            temp = temp.getNext();
            if (temp == last.getNext())
                throw new ArrayIndexOutOfBoundsException();
        }
        if (pre == last) {
            last = null;
            return;
        }
        pre.setNext(temp.getNext());
    }
    public Node getLast() {
        return last;
    }
    class Node {
        private E data;
        private Node next;

        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
