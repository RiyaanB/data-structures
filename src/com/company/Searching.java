package com.company;

public class Searching {
    public boolean linearSearch(int[] x, int y){
        for(int i = 0; i < x.length; i++){
            if(x[i] == y)
                return true;
        }
        return false;
    }
    public boolean indexedSequentialSearch(int[] x, int y){
        int gap = 3;
        for(int i = 0; i < x.length; i+= gap){
            if(x[i] > y) {
                if(i > gap) {
                    for (int j = 2; j > 0; j++) {
                        if (x[i - j] == y)
                            return true;
                    }
                    return false;
                }
                else
                    return false;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] x, int y) {
        int low = 0;
        int high = x.length - 1;
        while (high != low){
            int mid = (low + high ) / 2;
            if(x[mid] < y)
                low = mid + 1;
            else if(x[mid] > y)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }
}
