package com.company;

public class Main {
    public static void main(String[] args){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(50);
        b.insert(25);
        b.insert(10);
        b.insert(80);
        b.insert(70);
        b.insert(90);
        b.insert(60);
        b.insert(75);
        System.out.println(b);
        b.remove(25);
        System.out.println(b);
    }
}
