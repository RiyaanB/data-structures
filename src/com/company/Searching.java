package com.company;

public class Searching {
    public static final int INF = Integer.MAX_VALUE;
    public static boolean linearSearch(int[] x, int y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y)
                return true;
        }
        return false;
    }

    public static boolean indexedSequentialSearch(int[] x, int y) {
        int gap = 3;
        for (int i = 0; i < x.length; i += gap) {
            if (x[i] > y) {
                if (i > gap) {
                    for (int j = 2; j > 0; j++) {
                        if (x[i - j] == y)
                            return true;
                    }
                    return false;
                } else
                    return false;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] x, int y) {
        int low = 0;
        int high = x.length - 1;
        while (high > low) {
            int mid = (low + high) / 2;
            if (x[mid] < y)
                low = mid + 1;
            else if (x[mid] > y)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static boolean isPrime(int x) {
        int l = (int) Math.sqrt(x) + 1;
        for (int i = 2; i < l; i++) {
            if (x % i == 0)
                return true;
        }
        return false;
    }

    public static int hash(int tableSize, int num) {
        return (num%11 + 1) % 11;
    }
    public static int[] linearProbingArray(int[] x){
        int tableSize = x.length + 1;
        while (!isPrime(tableSize))
            tableSize++;
        int[] hashtable = new int[tableSize];
        for(int i = 0; i < hashtable.length; i++)
            hashtable[i] = INF;
        for(int i:x){
            int l = hash(tableSize, i);
            while(hashtable[l] != INF)
                l++;
            hashtable[l] = i;
        }
        return hashtable;
    }
    public static boolean linearProbing(int[] hashtable, int x){
        int limit =  hash(hashtable.length, x);
        int c = limit;
        do{
            if(hashtable[c] == x)
                return true;
            else
                c = (c+1) % hashtable.length;
        } while (c != limit);
        return false;
    }
    public static int[] quadraticProbingArray(int[] x){
        int tableSize = x.length + 1;
        while (!isPrime(tableSize))
            tableSize++;
        int[] hashtable = new int[tableSize];
        for(int i = 0; i < hashtable.length; i++)
            hashtable[i] = INF;
        for(int i:x) {
            int l = hash(hashtable.length, i);
            int p = l;
            int power = 1;
            while (hashtable[p] != INF)
                p = l + power * power++;
            hashtable[p] = i;
        }
        return hashtable;
    }
    public static boolean quadraticProbing(int[] hashtable, int x){
        return false;
    }
}
