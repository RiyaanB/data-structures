package com.company;

public class MinArrayHeap {
    int len;
    int[] vals;

    public MinArrayHeap(int max) {
        vals = new int[max];
        len = 0;
    }

    public boolean add(int num) {
        if (vals.length == len)
            return false;
        int t = len++;
        while (true) {
            if (t > 0 && vals[(t - 1) / 2] > num) {
                vals[t] = vals[(t - 1) / 2];
                t = (t - 1) / 2;
            } else {
                break;
            }
        }
        vals[t] = num;
        return true;
    }

    public int remove() {
        if (len == 0)
            throw new ArrayIndexOutOfBoundsException();
        len--;
        int temp = vals[0];
        int returnData = vals[len];
        int c = 1;
        while (c < len) {
            if (c + 1 < len && vals[c] > vals[c + 1])
                c++;
            if (returnData > vals[c])
                vals[(c - 1) / 2] = vals[c];
            else
                break;
            c = c * 2 + 1;
        }
        vals[(c - 1) / 2] = returnData;
        return temp;
    }
    public boolean isEmpty() {
        return len == 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < len; i++)
            s += vals[i] + " ";
        return s;
    }
}
