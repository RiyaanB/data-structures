package com.company;

public class Main {
    public static void main(String[] args){
        MinArrayHeap m = new MinArrayHeap(9);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(1);
        System.out.println(m);
        m.remove();
        System.out.println(m);
        m.add(5);
        System.out.println(m);
    }
}
