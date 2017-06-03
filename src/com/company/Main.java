package com.company;

public class Main {
    public static void main(String[] args){
        ArrayMatrix a = new ArrayMatrix(new int[][]{{1,2,3},{4,5,6}});
        ArrayMatrix b = new ArrayMatrix(new int[][]{{1,2},{3,4,},{5,6}});
        System.out.println(a.add(b));
    }
}
