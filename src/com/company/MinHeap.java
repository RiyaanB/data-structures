package com.company;

public class MinHeap {
    int len;
    int[] vals;
    public MinHeap(int max)
    {
        vals = new int[max];
        len = 0;
    }

    public boolean add(int num)
    {
        if(vals.length == len)
            return false;
        int t = len;
        while(true) {
            if(vals[(t-1)/2] > num)
            {
                vals[t] = vals[(t-1)/2];
                vals[(t-1)/2] = num;
                t = (t-1)/2;
                if(t == 0)
                    break;
            }
            else {
                vals[t] = num;
                break;
            }
        }
        len++;
        return true;
    }

    public int remove() {
        if (len-- == 0)
            throw new ArrayIndexOutOfBoundsException();
        int temp = vals[0];
        int c = 0;
        while(c < len) {
            if((2*c + 2 > len) || vals[(2*c)+1] < vals[(2*c)+2]) {
                vals[c] = vals[(2*c)+1];
                c = 2*c + 1;
            }
            else{
                vals[c] = vals[(2*c)+2];
                c = 2*c + 2;
            }
        }
        return temp;

    }
    public String toString()
    {
        String s = "";
        for(int i: vals)
            s += i + " ";
        return s;
    }
}
