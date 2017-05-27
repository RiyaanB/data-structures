package com.company;

public class LinkedList
{
    class Node
    {
        private int data;
        private Node next;
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node first;
    public boolean add(int value)
    {
        Node newnode = new Node();
        newnode.setData(value);
        newnode.setNext(null);
        if(first == null)
            first = newnode;
        else
        {
            Node temp=first;
            while(temp.getNext()!=null)
                temp=temp.getNext();
            temp.setNext(newnode);

        }
        return true;
    }
    public String toString()
    {
        Node temp=first;
        String s = "";
        while(temp!=null)
        {
            s += temp.getData() + " ";
            temp=temp.getNext();
        }
        return s;
    }
    public int count()
    {
        Node temp = first;
        int c = 0;
        while(temp!=null)
        {
            c++;
            temp = temp.getNext();
        }
        return c;
    }
    public int max()
    {
        Node temp = first;
        int max = temp.getData();
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
            max = Math.max(max, temp.getData());
        }
        return max;
    }
    public boolean insertAtIndex(int value, int pos)
    {
        Node newnode = new Node();
        newnode.setData(value);
        if (pos == 0)
        {
            newnode.setNext(first);
            first = newnode;
            return true;
        }
        Node temp = first.getNext();
        Node pre = first;
        int c;
        for(c = 1; c < pos&&temp!=null; c++)
        {
            pre = temp;
            temp = temp.getNext();
        }
        if(c==pos)
        {
            newnode.setNext(temp);
            pre.setNext(newnode);
            return true;
        }
        return false;
    }
    public boolean insertAfter(int val1, int val2)
    {
        Node temp = first;
        while(temp != null)
        {
            if (temp.getData() == val1)
            {
                Node newnode = new Node();
                newnode.setData(val2);
                newnode.setNext(temp.getNext());
                temp.setNext(newnode);
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    public boolean deletePos(int pos)
    {
        if(pos == 1)
        {
            first = first.getNext();
            return true;
        }
        Node temp = first.getNext();
        Node pre = first;
        int i;
        for(i = 2; i < pos && temp != null; i++)
        {
            pre = temp;
            temp = temp.getNext();
        }
        if(i == pos)
        {
            pre.setNext(temp.getNext());
            return true;
        }
        return false;
    }

    public boolean deleteVal(int val)
    {
        if (first == null)
        {
            return false;
        }
        if(first.getData() == val)
        {
            first = first.getNext();
        }
        Node temp = first;
        Node pre = first;
        while(temp != null)
        {
            if(temp.getData() == val)
            {
                pre.setNext(temp.getNext());
                return true;
            }
            pre = temp;
            temp = temp.getNext();
        }
        return false;
    }
    public boolean reverse()
    {
        Node temp = first;
        Node pre = null;
        Node hold;
        while (temp != null)
        {
            hold = temp.getNext();
            temp.setNext(pre);
            pre = temp;
            temp = hold;
        }
        first = pre;
        return true;
    }
    public int get(int index) throws Exception
    {
        int i = 0;
        Node temp = first;
        while(i < index && temp != null)
        {
            temp = temp.getNext();
            i++;
        }
        if(temp == null)
        {
            throw new Exception();
        }
        return temp.getData();
    }
    public LinkedList getCopy()
    {
        LinkedList n = new LinkedList();
        int size = this.count();
        for(int c = 0; c < size; c++)
        {
            try {
                n.add(this.get(c));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n;
    }
    public boolean inList(int val)
    {
        Node temp = first;
        while(temp != null)
        {
            if(temp.getData() == val)
            {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    public LinkedList intersection(LinkedList two)
    {
        LinkedList n = new LinkedList();
        Node temp = first;
        while(temp != null)
        {
            if(two.inList(temp.getData()))
                n.add(temp.getData());
            temp = temp.getNext();
        }
        return n;
    }
    public LinkedList union(LinkedList two)
    {
        LinkedList n = new LinkedList();
        Node temp = first;
        while(temp != null)
        {
            if (!n.inList(temp.getData()))
            {
                n.add(temp.getData());
            }
            temp = temp.getNext();
        }
        temp = two.getFirst();
        while(temp != null)
        {
            if (!n.inList(temp.getData()))
            {
                n.add(temp.getData());
            }
            temp = temp.getNext();
        }
        return n;
    }
    public Node getFirst()
    {
        return first;
    }
    public boolean isSorted()
    {
        if(this.count() == 0)
        {
            return true;
        }
        Node temp = first;
        while(temp.getNext() != null)
        {
            if(!(temp.getData() <= temp.getNext().getData()))
            {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
    }
    public void insertedSorted(int val)
    {
        if(!this.isSorted())
            this.sort();
        Node temp = first;
        Node newnode = new Node();
        Node pre = new Node();
        newnode.setData(val);
        while(temp != null)
        {
            if(temp.getData() > val)
            {
                break;
            }
            pre = temp;
            temp = temp.getNext();
        }
        if(temp == first)
        {
            newnode.setNext(first);
            first = newnode;
        }
        else
        {
            newnode.setNext(pre.getNext());
            pre.setNext(newnode);
        }
    }
    public void sort()
    {
        boolean changed = true;
        while(changed)
        {
            Node temp = first;
            changed = false;
            while(temp.getNext() != null)
            {
                if(temp.getData() > temp.getNext().getData())
                {
                    changed = true;
                    int t = temp.getData();
                    temp.setData(temp.getNext().getData());
                    temp.getNext().setData(t);

                }

                temp = temp.getNext();

            }
        }
    }
}


