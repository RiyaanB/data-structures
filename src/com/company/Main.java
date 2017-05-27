package com.company;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);

        System.out.println(q.delete());
        System.out.println(q.delete());
        System.out.println(q.delete());
    }
}
