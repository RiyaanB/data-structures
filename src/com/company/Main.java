package com.company;
import java.util.ArrayDeque;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Main {
    public static void main(String[] args){
        java.util.ArrayDeque<Integer> javaDeck = new java.util.ArrayDeque<Integer>();
        Deque<Integer> myDeque = new Deque<Integer>();
        javaDeck.addFirst(10);
        javaDeck.addFirst(20);
        javaDeck.addLast(0);
        javaDeck.addLast(-10);
        System.out.println(javaDeck);
        myDeque.addFirst(10);
        myDeque.addFirst(20);
        myDeque.addLast(0);
        myDeque.addLast(-10);
        System.out.println(myDeque);
    }
}
