package com.company;

public class Sorting {

    public static int[] StraightInsertion(int[] x){
        for(int i = 1; i < x.length; i++){
            int h = x[i], j = i;
            while(j > 0 && x[j-1] > h){
                x[j--] = x[j];
            }
            x[j] = h;
        }
        return x;
    }
    public static int[] ShellInsertion(int[] x){
        for(int pow = 2; x.length/pow != 0; pow *= 2){
            int num = x.length/pow;
            for(int i = 0; i < x.length; i++){
                int h = x[i], j = i;
                while(j > num && x[j - num] > h){
                    x[j] = x[j-num];
                    j -= num;
                }
                x[j] = h;
            }
        }

        for(int i:x){
            System.out.print(i + ",");
        }
        return x;
    }
}