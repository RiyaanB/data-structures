package com.company;

public class SparseMatrix {

    class SmNode
    {
        public int pos,data;
        public SmNode next;
        public String toString()
        {
            return "(" + pos + "," + data + ")";
        }
    }
    class SmLinkedList
    {
        SmNode head;
        public void add(int d, int p)
        {
            if(head == null)
            {
                head = new SmNode();
                head.pos = p;
                head.data = d;
                return;
            }
            while(head.next != null)
            {
                head = head.next;
            }
            head.next = new SmNode();
            head.next.pos = p;
            head.next.data = d;
        }

        public String toString()
        {
            String s = "";
            SmNode t = head;
            while(t!= null)
            {
                s += t;
                t = t.next;
            }
            return s;
        }

        public SmLinkedList add(SmLinkedList l)
        {
            SmLinkedList n = new SmLinkedList();
            SmNode f1 = head;
            SmNode f2 = l.head;
            boolean t = false;
            while (!(f1.next == null && f2.next == null))
            {
                if(f1 == null || f1.pos > f2.pos){
                    n.add(f2.data,f2.pos);
                    f2 = f2.next;
                }
                else if(f2 == null || f1.pos < f2.pos) {
                    n.add(f1.data, f1.pos);
                    f1 = f1.next;
                }
                else {
                    n.add(f1.pos, f1.data + f2.data);
                    f1 = f1.next;
                    f2 = f2.next;
                }
            }
            return n;
        }
    }
    SmLinkedList[] l;
    int lenOfRow;
    public SparseMatrix(int[][] m)
    {
        l = new SmLinkedList[m.length];
        lenOfRow = m[0].length;
        for(int y = 0; y < m.length; y++)
        {
            l[y] = new SmLinkedList();
            for(int x = 0; x < m[y].length; x++)
            {
                if(m[y][x] != 0)
                    l[y].add(m[y][x],x);
            }
        }
    }
    public SparseMatrix(int i)
    {
        l = new SmLinkedList[i];
    }
    public String toString()
    {
        String i = "";
        for(int c = 0; c < l.length; c++)
        {
            i += c + ": " + l[c] + "\n";
        }
        return i;
    }

    public SparseMatrix add(SparseMatrix b){
        SparseMatrix n = new SparseMatrix(l.length);
        for(int i = 0; i < l.length; i++)
        {
            n.l[i] = l[i].add(b.l[i]);
        }
        return n;
    }

    public SparseMatrix multiply(SparseMatrix a)
    {
        SparseMatrix b = new SparseMatrix(new int[l.length][lenOfRow]);
        for(int i = 0; i < l.length; i++)
        {
            
        }
        return b;
    }
}
